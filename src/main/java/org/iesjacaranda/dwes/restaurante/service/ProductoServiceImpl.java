package org.iesjacaranda.dwes.restaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.iesjacaranda.dwes.restaurante.dto.CategoriaDTO;
import org.iesjacaranda.dwes.restaurante.dto.ProductoDTO;
import org.iesjacaranda.dwes.restaurante.entities.Categoria;
import org.iesjacaranda.dwes.restaurante.entities.Producto;
import org.iesjacaranda.dwes.restaurante.respository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Melero
 *
 */
@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoDTO> getProductos(CategoriaDTO categoria) {
		Categoria cat = new Categoria(categoria.getCodCat(), categoria.getNombre(), categoria.getDescripcion());
		List<Producto> prod = productoRepository.findAllBycodCat(cat);
		List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();
		for (Producto auxProd : prod ) {
			productoDTO.add(new ProductoDTO(auxProd.getCodProd(),  auxProd.getNombre(), auxProd.getDescripcion(),  auxProd.getFecha(), auxProd.getPeso(), auxProd.getStock()));
		}
		return productoDTO;
	}

}
