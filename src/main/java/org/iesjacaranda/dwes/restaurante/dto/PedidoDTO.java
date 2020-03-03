package org.iesjacaranda.dwes.restaurante.dto;

/**
 * @author Manuel Melero
 *
 */
import java.sql.Date;
import java.util.Set;

public class PedidoDTO {
	
	private int codPed;

	private Date fecha;

	private int enviado;

	private RestaurenteDTO codRes;

	private Set<PedidoProductoDTO> pedidoProducto;
	
	/**
	 * 
	 */
	public PedidoDTO() {
		super();
	}

	/**
	 * @param codPed
	 * @param fecha
	 * @param enviado
	 * @param codRes
	 * @param pedidoProducto
	 */
	public PedidoDTO(int codPed, Date fecha, int enviado, RestaurenteDTO codRes,
			Set<PedidoProductoDTO> pedidoProducto) {
		super();
		this.codPed = codPed;
		this.fecha = fecha;
		this.enviado = enviado;
		this.codRes = codRes;
		this.pedidoProducto = pedidoProducto;
	}

	/**
	 * @return the codPed
	 */
	public int getCodPed() {
		return codPed;
	}

	/**
	 * @param codPed the codPed to set
	 */
	public void setCodPed(int codPed) {
		this.codPed = codPed;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the enviado
	 */
	public int getEnviado() {
		return enviado;
	}

	/**
	 * @param enviado the enviado to set
	 */
	public void setEnviado(int enviado) {
		this.enviado = enviado;
	}

	/**
	 * @return the codRes
	 */
	public RestaurenteDTO getCodRes() {
		return codRes;
	}

	/**
	 * @param codRes the codRes to set
	 */
	public void setCodRes(RestaurenteDTO codRes) {
		this.codRes = codRes;
	}

	/**
	 * @return the pedidoProducto
	 */
	public Set<PedidoProductoDTO> getPedidoProducto() {
		return pedidoProducto;
	}

	/**
	 * @param pedidoProducto the pedidoProducto to set
	 */
	public void setPedidoProducto(Set<PedidoProductoDTO> pedidoProducto) {
		this.pedidoProducto = pedidoProducto;
	}

}
