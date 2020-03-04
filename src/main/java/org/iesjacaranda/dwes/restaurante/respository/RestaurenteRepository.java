package org.iesjacaranda.dwes.restaurante.respository;

import org.iesjacaranda.dwes.restaurante.entities.Restaurente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel Melero
 *
 */
@Repository
public interface RestaurenteRepository extends JpaRepository<Restaurente, Integer> {
	
	public Restaurente findBycorreoAndClave(String correo, String clave);

}
