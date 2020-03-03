/**
 * 
 */
package org.iesjacaranda.dwes.restaurante.dto;

import java.util.ArrayList;

/**
 * @author Manu
 *
 */
public class CarritoDTO {
	
	private ArrayList<PedidoProductoDTO> carrito;
	
	public CarritoDTO(){
		carrito = new ArrayList<PedidoProductoDTO>();
	}
	
	public void addCarrito(ProductoDTO producto, int unidades) {
		PedidoProductoDTO pedProd = new PedidoProductoDTO(producto, unidades);
		PedidoProductoDTO pedProdEncon = this.encontrado(pedProd);
		if (carrito.size() == 0 ) {
			carrito.add(pedProd);
		} else {
			if (pedProdEncon != null) {
				int cantidadAnterior = pedProdEncon.getUnidades();
				int cantidadSumar = pedProd.getUnidades();
				carrito.remove(pedProdEncon);
				pedProd.setUnidades(cantidadAnterior + cantidadSumar);
				carrito.add(pedProd);
			} else {
				carrito.add(pedProd);
			}
		}
		this.comprobarUnidad(pedProd);
	}
	
	public void eliminarCantidadCarrito(ProductoDTO producto, int unidades) {
		PedidoProductoDTO pedProd = new PedidoProductoDTO(producto, unidades);
		PedidoProductoDTO pedProdEncon = this.encontrado(pedProd);
		if (pedProdEncon != null) {
			int cantidadAnterior = pedProdEncon.getUnidades();
			int cantidadRestar = pedProd.getUnidades();
			carrito.remove(pedProdEncon);
			pedProd.setUnidades(cantidadAnterior - cantidadRestar);
			carrito.add(pedProd);
		}
		this.comprobarUnidad(pedProd);
	}
	
	public void modCarrito(ProductoDTO producto, int unidades) {
		PedidoProductoDTO pedProd = new PedidoProductoDTO(producto, unidades);
		PedidoProductoDTO pedProdEncon = this.encontrado(pedProd);
		if ( pedProdEncon != null ) {
			carrito.remove(pedProdEncon);
			carrito.add(pedProd);
		}
		this.comprobarUnidad(pedProd);
	}
	
	public ArrayList<PedidoProductoDTO> getCarrito(){
		return carrito;
	}
	
	public void borrarCarrito(){
		carrito.clear();
	}
	
	private void comprobarUnidad(PedidoProductoDTO pedProd){
		if (pedProd.getUnidades() <= 0 ) {
			carrito.remove(pedProd);
		}
	}
	
	private PedidoProductoDTO encontrado(PedidoProductoDTO pedProd) {
		ProductoDTO codprod = pedProd.getCodProd();
		for (PedidoProductoDTO car : carrito ) {
			if ( car.getCodProd().getCodPro() ==  codprod.getCodPro() ) {
				return car;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "CarritoDTO [carrito=" + carrito + "]";
	}
	
	 
	

}
