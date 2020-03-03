package org.iesjacaranda.dwes.restaurante.dto;

/**
 * @author Manuel Melero
 *
 */
public class PedidoProductoDTO {

	private int codPedProd;

	private PedidoDTO codPed;

	private ProductoDTO codProd;

	private int unidades;

	/**
	 * 
	 */
	public PedidoProductoDTO() {
		super();
	}

	/**
	 * @param codProd
	 * @param unidades
	 */
	public PedidoProductoDTO(ProductoDTO codProd, int unidades) {
		this.codProd = codProd;
		this.unidades = unidades;
	}
	
	/**
	 * @param codPedProd
	 * @param codPed
	 * @param codProd
	 * @param unidades
	 */
	public PedidoProductoDTO(int codPedProd, PedidoDTO codPed, ProductoDTO codProd, int unidades) {
		super();
		this.codPedProd = codPedProd;
		this.codPed = codPed;
		this.codProd = codProd;
		this.unidades = unidades;
	}

	/**
	 * @return the codPedProd
	 */
	public int getCodPedProd() {
		return codPedProd;
	}

	/**
	 * @param codPedProd the codPedProd to set
	 */
	public void setCodPedProd(int codPedProd) {
		this.codPedProd = codPedProd;
	}

	/**
	 * @return the codPed
	 */
	public PedidoDTO getCodPed() {
		return codPed;
	}

	/**
	 * @param codPed the codPed to set
	 */
	public void setCodPed(PedidoDTO codPed) {
		this.codPed = codPed;
	}

	/**
	 * @return the codProd
	 */
	public ProductoDTO getCodProd() {
		return codProd;
	}

	/**
	 * @param codProd the codProd to set
	 */
	public void setCodProd(ProductoDTO codProd) {
		this.codProd = codProd;
	}

	/**
	 * @return the unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "PedidoProductoDTO [codProd=" + codProd + ", unidades=" + unidades + "]";
	}
	
	

}
