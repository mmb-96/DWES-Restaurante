package org.iesjacaranda.dwes.restaurante.entities;

/**
 * @author Manuel Melero
 *
 */
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class Restaurente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3261102587396250287L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codRes;
	
	@NotNull
	@Column(length = 90, unique = true)
	private String corroe;
	
	@NotNull
	@Column(length = 45)
	private String clave;
	
	@NotNull
	@Column(length = 45)
	private String pais;
	
	@NotNull
	private int cp;
	
	@NotNull
	@Column(length = 45)
	private String ciudad;
	
	@NotNull
	@Column(length = 2000)
	private String direccion;
	
	@OneToMany(mappedBy="codRes")
	private Set<Pedido> pedido;

	/**
	 * 
	 */
	public Restaurente() {
		super();
	}
	
	/**
	 * @param codRes
	 */
	public Restaurente(int codRes) {
		this.codRes = codRes;

	}
	
	
	/**
	 * @param corroe
	 * @param clave
	 */
	public Restaurente(String corroe, String clave) {
		this.corroe = corroe;
		this.clave = clave;

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
	public Restaurente(int codRes, String corroe, String clave, String pais, int cp, String ciudad, String direccion,
			Set<Pedido> pedido) {
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
	public Set<Pedido> getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}

}
