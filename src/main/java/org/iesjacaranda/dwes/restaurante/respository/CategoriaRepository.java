package org.iesjacaranda.dwes.restaurante.respository;

import org.iesjacaranda.dwes.restaurante.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel Melero
 *
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
