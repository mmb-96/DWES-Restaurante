/**
 * 
 */
package org.iesjacaranda.dwes.restaurante.service;

import org.iesjacaranda.dwes.restaurante.dto.RestaurenteDTO;
import org.iesjacaranda.dwes.restaurante.entities.Restaurente;
import org.iesjacaranda.dwes.restaurante.respository.RestaurenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Melero
 *
 */
@Service
public class RestaurenteServiceImpl implements RestaurenteService {
	
	@Autowired
	RestaurenteRepository restauranteRepository;

	@Override
	public RestaurenteDTO comprobarRestaurante(RestaurenteDTO restauranteDTO) {
		Restaurente res = new Restaurente(restauranteDTO.getCorroe(), restauranteDTO.getClave());
		Restaurente resObt = restauranteRepository.findBycorroeAndClave(res.getCorroe(), res.getClave());
		if ( resObt != null ) {
			return  new RestaurenteDTO(resObt.getCodRes(), resObt.getCorroe(), resObt.getClave(), resObt.getPais(), resObt.getCp(), resObt.getCiudad(), resObt.getDireccion());
		}
		return null;
	}

}
