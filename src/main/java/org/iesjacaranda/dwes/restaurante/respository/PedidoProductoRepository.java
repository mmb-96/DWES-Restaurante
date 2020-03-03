package org.iesjacaranda.dwes.restaurante.respository;

import org.iesjacaranda.dwes.restaurante.entities.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel Melero
 *
 */
@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Integer> {

}
