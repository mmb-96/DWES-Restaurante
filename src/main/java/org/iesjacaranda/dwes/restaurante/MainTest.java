package org.iesjacaranda.dwes.restaurante;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.iesjacaranda.dwes.restaurante.dto.CarritoDTO;
import org.iesjacaranda.dwes.restaurante.dto.CategoriaDTO;
import org.iesjacaranda.dwes.restaurante.dto.PedidoProductoDTO;
import org.iesjacaranda.dwes.restaurante.dto.ProductoDTO;
import org.iesjacaranda.dwes.restaurante.entities.Categoria;
import org.iesjacaranda.dwes.restaurante.entities.Pedido;
import org.iesjacaranda.dwes.restaurante.entities.PedidoProducto;
import org.iesjacaranda.dwes.restaurante.entities.Producto;
import org.iesjacaranda.dwes.restaurante.entities.Restaurente;
import org.iesjacaranda.dwes.restaurante.respository.CategoriaRepository;
import org.iesjacaranda.dwes.restaurante.respository.PedidoProductoRepository;
import org.iesjacaranda.dwes.restaurante.respository.PedidoRepository;
import org.iesjacaranda.dwes.restaurante.respository.ProductoRepository;
import org.iesjacaranda.dwes.restaurante.service.CategoriaService;
import org.iesjacaranda.dwes.restaurante.service.EmailService;
import org.iesjacaranda.dwes.restaurante.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainTest implements CommandLineRunner {

	@Autowired
	CategoriaService cat;
	@Autowired
	ProductoService prod;
	@Autowired
	PedidoProductoRepository ppRES;
	@Autowired
	ProductoRepository proREs;
	@Autowired
	CategoriaRepository catRES;
	@Autowired
	PedidoRepository pedRES;
	@Autowired(required = false)
	EmailService email;
	
	public static void main(String[] args) {
		SpringApplication.run(MainTest.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(cat.getCategoriaAll().toString());
//		
//		System.out.println(prod.getProductos(new CategoriaDTO(1, "Bebidas con", "Bebidas con alcohol")));
//		
		Date fecha = new Date(2010, 10, 10); 
		CarritoDTO car = new CarritoDTO();
		ProductoDTO prod = new ProductoDTO(1,"prueba", "preuba", 10, 10, new CategoriaDTO("Prueba", "Esto es una prueba CRAK"));
		ProductoDTO prod2 = new ProductoDTO(1,"ad", "ad", 1, 1, new CategoriaDTO("Pruebasssa", "Esto es una prueba CRAK"));

		car.addCarrito(prod2, 10);
		System.out.println(car.toString());
//		car.addCarrito(prod, 0);
//		System.out.println(car.toString());
		car.addCarrito(prod, 8);
		System.out.println(car.toString());
//		car.addCarrito(prod2, 2);
//		System.out.println(car.toString());
//		car.addCarrito(prod, 5);
//		System.out.println(car.toString());
		
//		proREs.save(new Producto("prueba", "preuba", 10, 10, new Categoria(1, "Prueba", "Esto es una prueba CRAK")));
		
		
		//Parte de insertar pedido y pedido producto, Falta la parte de Transaccional.
//		pedRES.save(new Pedido(fecha, 0, new Restaurente(1)));
//		Optional<Pedido> pedBD = pedRES.findById(2);
//		Pedido pedOb = new Pedido();
//		if (pedBD.isPresent()) {
//			pedOb = pedBD.get();
//		}
//		
//		List<PedidoProductoDTO> calito = car.getCarrito();
//		for (PedidoProductoDTO cart : calito) {
//			Producto prodOB = new Producto(cart.getCodProd().getCodPro(), new Categoria(cart.getCodProd().getCodCat().getCodCat()));
//			PedidoProducto ped = new PedidoProducto(1, pedOb, prodOB , cart.getUnidades());
//			ppRES.save(ped);
//			
//		}
		
		email.sendSimpleMessage();
		
		
	}

}
