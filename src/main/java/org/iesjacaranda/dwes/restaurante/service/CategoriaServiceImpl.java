package org.iesjacaranda.dwes.restaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.iesjacaranda.dwes.restaurante.dto.CategoriaDTO;
import org.iesjacaranda.dwes.restaurante.entities.Categoria;
import org.iesjacaranda.dwes.restaurante.respository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Melero
 *
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<CategoriaDTO> getCategoriaAll() {
		List<Categoria> catEnty = categoriaRepository.findAll();
		List<CategoriaDTO> categoriaDTO = new ArrayList<CategoriaDTO>();
		for (Categoria cat : catEnty) {
			categoriaDTO.add(new CategoriaDTO(cat.getCodCat(), cat.getNombre(), cat.getDescripcion()));
		}
		return categoriaDTO;
	}
}