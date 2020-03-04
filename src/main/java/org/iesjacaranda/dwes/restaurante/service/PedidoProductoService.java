package org.iesjacaranda.dwes.restaurante.service;

import java.util.List;

import org.iesjacaranda.dwes.restaurante.dto.PedidoProductoDTO;
import org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO;

/**
 * @author Manuel Melero
 *
 */
public interface PedidoProductoService {

	void guardarPedido(List<PedidoProductoDTO> carritoLleno, RestaurenteDTO usuarioActual);

}
