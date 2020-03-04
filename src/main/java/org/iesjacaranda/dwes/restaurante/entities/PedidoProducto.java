package org.iesjacaranda.dwes.restaurante.entities;

/**
 * @author Manuel Melero
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class PedidoProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2360018076600846164L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codPedProd;
	
	@ManyToOne
	@JoinColumn(name = "codPed", referencedColumnName = "codPed")
	private Pedido codPed;
		
	@ManyToOne
	@JoinColumn(name = "codProducto", referencedColumnName = "codProd")
	private Producto codProducto;
		
	@NotNull
	@Column
	private int unidades;
	
	/**
	 * 
	 */
	public PedidoProducto() {
		super();
	}
	
	/**
	 * @param codPed
	 * @param codProd
	 * @param unidades
	 */
	public PedidoProducto(Pedido codPed, Producto codProd, int unidades) {
		this.codPed = codPed;
		this.codProducto = codProd;
		this.unidades = unidades;
	}

	/**
	 * @param codPedProd
	 * @param codPed
	 * @param codProd
	 * @param unidades
	 */
	public PedidoProducto(int codPedProd, Pedido codPed, Producto codProd, int unidades) {
		super();
		this.codPedProd = codPedProd;
		this.codPed = codPed;
		this.codProducto = codProd;
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
	public Pedido getCodPed() {
		return codPed;
	}

	/**
	 * @param codPed the codPed to set
	 */
	public void setCodPed(Pedido codPed) {
		this.codPed = codPed;
	}

	/**
	 * @return the codProd
	 */
	public Producto getCodProd() {
		return codProducto;
	}

	/**
	 * @param codProd the codProd to set
	 */
	public void setCodProd(Producto codProd) {
		this.codProducto = codProd;
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
	
}
