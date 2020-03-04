package org.iesjacaranda.dwes.restaurante.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.iesjacaranda.dwes.restaurante.dto.PedidoProductoDTO;
import org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO;
import org.iesjacaranda.dwes.restaurante.entities.Pedido;
import org.iesjacaranda.dwes.restaurante.entities.PedidoProducto;
import org.iesjacaranda.dwes.restaurante.entities.Producto;
import org.iesjacaranda.dwes.restaurante.entities.Restaurente;
import org.iesjacaranda.dwes.restaurante.respository.PedidoProductoRepository;
import org.iesjacaranda.dwes.restaurante.respository.PedidoRepository;
import org.iesjacaranda.dwes.restaurante.respository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Manuel Melero
 *
 */
@Service
public class PedidoProductoServiceImpl implements PedidoProductoService{
	
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PedidoProductoRepository pedidoProductoRepository;
	@Autowired
	ProductoRepository productoRepository;

	/**
	 * Metedo que realiza insert en la base de datos siempre y cuando no se produzca un error.
	 * @param carritoLleno
	 * @param usuarioActual
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void guardarPedido(List<PedidoProductoDTO> carritoLleno, RestaurenteDTO usuarioActual) {
		// Inserta un pedido en la base de datos
		java.util.Date d = new java.util.Date(); 
		Date fecha = new Date(d.getTime());
		Pedido pedido = new Pedido(fecha, 0, new Restaurente(usuarioActual.getCodRes()));
		pedidoRepository.save(pedido);
		// Recorre el carrito y inserta los pedidos de los productos.
		for (PedidoProductoDTO cart : carritoLleno) {	
			Optional<Producto> prodDB = productoRepository.findById(cart.getCodProd().getCodPro());
			Producto proOB = new Producto();
			if (prodDB.isPresent()) {
				proOB = prodDB.get();
			}
			PedidoProducto ped = new PedidoProducto(pedido, proOB , cart.getUnidades());
			pedidoProductoRepository.save(ped);
		}
	}

}
