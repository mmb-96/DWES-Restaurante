package org.iesjacaranda.dwes.restaurante.dto;

/**
 * @author Manuel Melero
 *
 */
import java.util.Set;


public class RestaurenteDTO {

	private int codRes;
	
	private String corroe;
	
	private String clave;

	private String pais;

	private int cp;
	
	private String ciudad;
	
	private String direccion;

	private Set<PedidoDTO> pedido;

	/**
	 * 
	 */
	public RestaurenteDTO() {
		super();
	}
	
	/**
	 * @param corroe
	 * @param clave
	 */
	public RestaurenteDTO(String corroe, String clave) {
		this.corroe = corroe;
		this.clave = clave;

	}
	
	/**
	 * @param codRes
	 */
	public RestaurenteDTO(int codRes) {
		this.codRes = codRes;

	}
	
	/**
	 * @param codRes
	 * @param corroe
	 * @param clave
	 * @param pais
	 * @param cp
	 * @param ciudad
	 * @param direccion
	 */
	public RestaurenteDTO(int codRes, String corroe, String clave, String pais, int cp, String ciudad, String direccion) {
		this.codRes = codRes;
		this.corroe = corroe;
		this.clave = clave;
		this.pais = pais;
		this.cp = cp;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	/**
	 * @param codRes
	 * @param corroe
	 * @param clave
	 * @param pais
	 * @param cp
	 * @param ciudad
	 * @param direccion
	 * @param pedido
	 */
	public RestaurenteDTO(int codRes, String corroe, String clave, String pais, int cp, String ciudad, String direccion,
			Set<PedidoDTO> pedido) {
		super();
		this.codRes = codRes;
		this.corroe = corroe;
		this.clave = clave;
		this.pais = pais;
		this.cp = cp;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.pedido = pedido;
	}

	/**
	 * @return the codRes
	 */
	public int getCodRes() {
		return codRes;
	}

	/**
	 * @param codRes the codRes to set
	 */
	public void setCodRes(int codRes) {
		this.codRes = codRes;
	}

	/**
	 * @return the corroe
	 */
	public String getCorroe() {
		return corroe;
	}

	/**
	 * @param corroe the corroe to set
	 */
	public void setCorroe(String corroe) {
		this.corroe = corroe;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the pedido
	 */
	public Set<PedidoDTO> getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Set<PedidoDTO> pedido) {
		this.pedido = pedido;
	}

}
