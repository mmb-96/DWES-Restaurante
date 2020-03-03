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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;

@Entity
@Table
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5647755705633546829L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codProd;
	
	@NotNull
	@Column(length = 45)
	private String nombre;

	@NotNull
	@Column(length = 90)
	private String descripcion;

	@NotNull
	@Column
	private double peso;
	
	@NotNull
	@Column
	private int stock;
	
	@Cascade(CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "codCat", referencedColumnName = "codCat")
	private Categoria codCat;
	
	@OneToMany(mappedBy="codProd")
	private Set<PedidoProducto> pedidoProducto;

	/**
	 * 
	 */
	public Producto() {
		super();
	}
	
	/**
	 * @param codProd
	 * @param nombre
	 * @param descripcion
	 * @param peso
	 * @param stock
	 * @param codCat
	 */
	public Producto(String nombre, String descripcion, double peso, int stock, Categoria codCat) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;

		this.peso = peso;
		this.stock = stock;
		this.codCat = codCat;
	}
	
	/**
	 * @param codProd
	 * @param nombre
	 * @param descripcion
	 * @param peso
	 * @param stock
	 * @param codCat
	 */
	public Producto(int codProd, String nombre, String descripcion, double peso, int stock,	Categoria codCat) {
		super();
		this.codProd = codProd;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
		this.codCat = codCat;
	}


	/**
	 * @param codProd
	 * @param nombre
	 * @param descripcion
	 * @param peso
	 * @param stock
	 * @param codCat
	 * @param pedidoProducto
	 */
	public Producto(int codProd, String nombre, String descripcion, double peso, int stock,	Categoria codCat, Set<PedidoProducto> pedidoProducto) {
		super();
		this.codProd = codProd;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
		this.codCat = codCat;
		this.pedidoProducto = pedidoProducto;
	}

	/**
	 * @return the codProd
	 */
	public int getCodProd() {
		return codProd;
	}

	/**
	 * @param codProd the codProd to set
	 */
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the codCat
	 */
	public Categoria getCodCat() {
		return codCat;
	}

	/**
	 * @param codCat the codCat to set
	 */
	public void setCodCat(Categoria codCat) {
		this.codCat = codCat;
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
