package org.iesjacaranda.dwes.restaurante.entities;

/**
 * @author Manuel Melero
 *
 */
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class Pedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8604480084813833921L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codPed;
	
	@NotNull
	@Column
	private Date fecha;
		
	@NotNull
	@Column
	private int enviado;
	
	@ManyToOne
	@JoinColumn(name = "codRes", referencedColumnName = "codRes")
	private Restaurente codRes;
	
	@OneToMany(mappedBy="codPed")
	private Set<PedidoProducto> pedidoProducto;
	
	/**
	 * 
	 */
	public Pedido() {
		super();
	}

	/**
	 * @param codPed
	 * @param fecha
	 * @param enviado
	 * @param codRes
	 * @param pedidoProducto
	 */
	public Pedido(int codPed, Date fecha, int enviado, Restaurente codRes, Set<PedidoProducto> pedidoProducto) {
		super();
		this.codPed = codPed;
		this.fecha = fecha;
		this.enviado = enviado;
		this.codRes = codRes;
		this.pedidoProducto = pedidoProducto;
	}

	/**
	 * @param codPed
	 * @param fecha
	 * @param enviado
	 * @param codRes
	 */
	public Pedido (Date fecha, int enviado, Restaurente codRes) {
		super();
		this.fecha = fecha;
		this.enviado = enviado;
		this.codRes = codRes;
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
	public Restaurente getCodRes() {
		return codRes;
	}

	/**
	 * @param codRes the codRes to set
	 */
	public void setCodRes(Restaurente codRes) {
		this.codRes = codRes;
	}

	/**
	 * @return the pedidoProducto
	 */
	public Set<PedidoProducto> getPedidoProducto() {
		return pedidoProducto;
	}

	/**
	 * @param pedidoProducto the pedidoProducto to set
	 */
	public void setPedidoProducto(Set<PedidoProducto> pedidoProducto) {
		this.pedidoProducto = pedidoProducto;
	}

}
