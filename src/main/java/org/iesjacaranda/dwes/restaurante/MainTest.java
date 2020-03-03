package org.iesjacaranda.dwes.restaurante;

import java.sql.Date;

import org.iesjacaranda.dwes.restaurante.dto.CarritoDTO;
import org.iesjacaranda.dwes.restaurante.dto.CategoriaDTO;
import org.iesjacaranda.dwes.restaurante.dto.ProductoDTO;
import org.iesjacaranda.dwes.restaurante.entities.Categoria;
import org.iesjacaranda.dwes.restaurante.entities.Producto;
import org.iesjacaranda.dwes.restaurante.respository.CategoriaRepository;
import org.iesjacaranda.dwes.restaurante.respository.PedidoProductoRepository;
import org.iesjacaranda.dwes.restaurante.respository.ProductoRepository;
import org.iesjacaranda.dwes.restaurante.service.CategoriaService;
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
		ProductoDTO prod = new ProductoDTO(2,"prueba", "preuba", 10, 10, new CategoriaDTO("Prueba", "Esto es una prueba CRAK"));
		ProductoDTO prod2 = new ProductoDTO(3,"ad", "ad", 1, 1, new CategoriaDTO("Pruebasssa", "Esto es una prueba CRAK"));

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
		
		proREs.save(new Producto(3, "ad", "ad", 1, 1, new Categoria(3)));
		
//		List<PedidoProductoDTO> calito = car.getCarrito();
//		for (PedidoProductoDTO cart : calito) {
//			
//			PedidoProducto ped = new PedidoProducto(1, new Pedido(1, fecha, 0, new Restaurente(1), null), new Producto(cart.getCodProd().getCodPro(), cart.getCodProd().getNombre(), cart.getCodProd().getDescripcion(), cart.getCodProd().getFecha()
//					, cart.getCodProd().getPeso(), cart.getCodProd().getStock(), new Categoria(cart.getCodProd().getCodCat().getCodCat(), cart.getCodProd().getCodCat().getNombre(), cart.getCodProd().getCodCat().getDescripcion()))
//					, cart.getUnidades());
//			ppRES.save(ped);
//			
//		}
	}

}
