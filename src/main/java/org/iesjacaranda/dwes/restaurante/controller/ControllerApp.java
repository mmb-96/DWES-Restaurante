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
import org.iesjacaranda.dwes.restaurante.service.EmailService;
import org.iesjacaranda.dwes.restaurante.service.PedidoProductoService;
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
 * @author Manuel Melero
 *
 */
@RestController
public class ControllerApp {
	
	CarritoDTO carritoDTO = new CarritoDTO();
	private String pagSiguiente = null;
	
	@Autowired
	RestaurenteService restauranteService;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	ProductoService productoService;
	@Autowired
	PedidoProductoService pedidoProdructoService;
	@Autowired
	EmailService emailService;
	
    @GetMapping("/")  
    public ModelAndView login(Model model)  {  
    	// Crea un objeto de restaurante
    	RestaurenteDTO res=new RestaurenteDTO();  
    	// Proporcionar objeto de restaurante al modelo
    	model.addAttribute("restaurante", res);
		return new ModelAndView("index");    
    } 
    
    @PostMapping("/categoria")  
    // @ModelAttribute binds form data to the object  
    public ModelAndView logeado(@ModelAttribute("restaurante") RestaurenteDTO res, HttpServletRequest request) {
    	HttpSession session = request.getSession(true);	    
    	RestaurenteDTO resDTO = restauranteService.comprobarRestaurante(res);
    	List<CategoriaDTO> catDTO = null;
    	if ( resDTO != null ) {
            session.setAttribute("usuarioActual",resDTO);
            catDTO = categoriaService.getCategoriaAll();
            request.setAttribute("categoria", catDTO);
            pagSiguiente = "Categoria";
    	}else {
    		request.setAttribute("msg", "No existe el usuario o la contraseña es incorrecta.");
    		pagSiguiente = "index";
    	}
    	return new ModelAndView(pagSiguiente);   
    }
    
    @GetMapping("/categorias")  
    public ModelAndView vuelveCategoria(HttpServletRequest request) {
    	List<CategoriaDTO> catDTO = categoriaService.getCategoriaAll();;
        request.setAttribute("categoria", catDTO);
    	return new ModelAndView("Categoria");   
    }
    
    @GetMapping("/obtenerProducto")
    public ModelAndView getProductos(@RequestParam int id, String nombre, String descripcion,  HttpServletRequest request){
        List<ProductoDTO> listaProdructo = productoService.getProductos(new CategoriaDTO(id, nombre, descripcion));
        request.setAttribute("productos", listaProdructo);
        request.setAttribute("categoria", new CategoriaDTO(id, nombre, descripcion));
        return new ModelAndView("Producto");  
    }
    
    @PostMapping("/addProdCar")
    public ModelAndView addProdCar(HttpServletRequest request){
    	carritoDTO.addCarrito(new ProductoDTO(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("peso")), Integer.parseInt(request.getParameter("stock"))), Integer.parseInt(request.getParameter("unidad")));
    	this.getProductos(Integer.parseInt(request.getParameter("idCat")), request.getParameter("nombreNombreCat"), request.getParameter("descripcionCat"), request);
        return new ModelAndView("Producto");
    }
    
    @GetMapping("/verCarrito")
    public ModelAndView getCarrito(HttpServletRequest request){
    	List<PedidoProductoDTO> carritoLleno = carritoDTO.getCarrito();
    	request.setAttribute("calito", carritoLleno);
        return new ModelAndView("Carrito");  
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
        return new ModelAndView("Carrito");
    }
    
    @GetMapping("/realiPedido")
    public ModelAndView realizarPedido(HttpServletRequest request){
    	List<PedidoProductoDTO> carritoLleno = carritoDTO.getCarrito();
    	HttpSession misession= (HttpSession) request.getSession();
		RestaurenteDTO usuarioActual = (RestaurenteDTO) misession.getAttribute("usuarioActual");
		try {
			pedidoProdructoService.guardarPedido(carritoLleno, usuarioActual);
			request.setAttribute("msg", "Pedido realizado con éxito. Se enviará un correo de confirmación a:" + usuarioActual.getCorreo());
			emailService.enviarCorreo(usuarioActual.getCorreo());
			carritoDTO.borrarCarrito();
		} catch (Exception e) {
			System.out.println(e.toString());
			request.setAttribute("msg", "Pedido no realizado con éxito. Se ha producido un error, contacte con el responsable.");
		}
        return new ModelAndView("PedidoRealizado");  
    }
    
    @GetMapping("/cerrarSesion")
    public ModelAndView cerrarSesion(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        session.invalidate();
        request.setAttribute("msg", "La sasión se cerró correctamente, hasta la próxima");
        this.login(model);
        return new ModelAndView("index");

    }
}
