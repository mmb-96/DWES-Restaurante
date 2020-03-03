package org.iesjacaranda.dwes.restaurante.service;

import java.util.List;

import org.iesjacaranda.dwes.restaurante.dto.CategoriaDTO;
import org.iesjacaranda.dwes.restaurante.dto.ProductoDTO;

/**
 * @author Manuel Melero
 *
 */
public interface ProductoService {
	
	public List<ProductoDTO> getProductos(CategoriaDTO categoria);

}
