package org.iesjacaranda.dwes.restaurante.respository;

import java.util.List;

import org.iesjacaranda.dwes.restaurante.entities.Categoria;
import org.iesjacaranda.dwes.restaurante.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel Melero
 *
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	public List<Producto> findAllBycodCat(Categoria categoria);

}
