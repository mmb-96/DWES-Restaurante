/**
 * 
 */
package org.iesjacaranda.dwes.restaurante.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.iesjacaranda.dwes.restaurante.dto.CarritoDTO;
import org.iesjacaranda.dwes.restaurante.dto.CategoriaDTO;
import org.iesjacaranda.dwes.restaurante.dto.PedidoProductoDTO;
import org.iesjacaranda.dwes.restaurante.dto.ProductoDTO;
import org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO;
import org.iesjacaranda.dwes.restaurante.service.CategoriaService;
import org.iesjacaranda.dwes.restaurante.service.ProductoService;
import org.iesjacaranda.dwes.restaurante.service.RestaurenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Manu
 *
 */
@RestController
public class ControllerApp {
	
	private String pagSiguiente = null;
	
	@Autowired
	RestaurenteService restauranteService;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	ProductoService productoService;
	CarritoDTO carritoDTO = new CarritoDTO();
	
    @GetMapping("/")  
    public ModelAndView bookingForm(Model model)  {  
      //create a reservation object   
    	RestaurenteDTO res=new RestaurenteDTO();  
      //provide reservation object to the model   
    	model.addAttribute("restaurante", res);
		return new ModelAndView("index");    
    } 
    
    @PostMapping("/submitForm")  
    // @ModelAttribute binds form data to the object  
    public ModelAndView submitForm(@ModelAttribute("restaurante") RestaurenteDTO res, HttpServletRequest request) {
    	HttpSession session = request.getSession(true);	    
    	RestaurenteDTO resDTO = restauranteService.comprobarRestaurante(res);
    	List<CategoriaDTO> catDTO = null;
    	if ( resDTO != null ) {
            session.setAttribute("usuarioActual",resDTO);
            catDTO = categoriaService.getCategoriaAll();
            request.setAttribute("categoria", catDTO);
            pagSiguiente = "confirmation-page";
    	}else {
    		request.setAttribute("msg", "No exixte el usuario o la contraseña es incorrecta.");
    		pagSiguiente = "index";
    	}
    	return new ModelAndView(pagSiguiente);   
    }
    
    @GetMapping("/obtenerProducto")
    public ModelAndView getProductos(@RequestParam int id, String nombre, String descripcion,  HttpServletRequest request){
        List<ProductoDTO> listaProdructo = productoService.getProductos(new CategoriaDTO(id, nombre, descripcion));
        request.setAttribute("productos", listaProdructo);
        request.setAttribute("categoria", new CategoriaDTO(id, nombre, descripcion));
        return new ModelAndView("producto");  
    }
    
    @PostMapping("/addProdCar")
    public ModelAndView addProdCar(HttpServletRequest request){
    	carritoDTO.addCarrito(new ProductoDTO(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("peso")), Integer.parseInt(request.getParameter("stock"))), Integer.parseInt(request.getParameter("unidad")));
    	this.getProductos(Integer.parseInt(request.getParameter("idCat")), request.getParameter("nombreNombreCat"), request.getParameter("descripcionCat"), request);
        return new ModelAndView("producto");
    }
    
    @GetMapping("/verCarrito")
    public ModelAndView getCarrito(HttpServletRequest request){
    	List<PedidoProductoDTO> carritoLleno = carritoDTO.getCarrito();
    	System.out.println(carritoLleno);
    	request.setAttribute("calito", carritoLleno);
        return new ModelAndView("carrito");  
    }
    
    @PostMapping("/delModProducto")
    public ModelAndView delProducto(HttpServletRequest request){
    	String boton = request.getParameter("accion");
    	if (boton.equalsIgnoreCase("eliminar")) {
    		carritoDTO.eliminarCantidadCarrito(new ProductoDTO(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("peso")), Integer.parseInt(request.getParameter("stock"))), Integer.parseInt(request.getParameter("unidad")));
    	} else if (boton.equalsIgnoreCase("modificar")) {
    		carritoDTO.modCarrito(new ProductoDTO(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("peso")), Integer.parseInt(request.getParameter("stock"))), Integer.parseInt(request.getParameter("unidadNew")));
    	}
    	
    	this.getCarrito(request);
        return new ModelAndView("carrito");
    }
}
