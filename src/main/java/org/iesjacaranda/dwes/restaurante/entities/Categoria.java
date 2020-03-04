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
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4097753303810826022L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCat;
	
	@NotNull
	@Column(length = 45, unique = true)
	private String nombre;

	@NotNull
	@Column(length = 2000)
	private String descripcion;
	
	@OneToMany(mappedBy="codProd")
	private Set<Producto> producto;

	/**
	 * 
	 */
	public Categoria() {
		super();
	}
	
	/**
	 * @param codCat
	 * @param nombre
	 * @param descripcion
	 */
	public Categoria(int codCat, String nombre, String descripcion) {
		super();
		this.codCat = codCat;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * @param codCat
	 * @param nombre
	 * @param descripcion
	 * @param producto
	 */
	public Categoria(int codCat, String nombre, String descripcion, Set<Producto> producto) {
		super();
		this.codCat = codCat;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.producto = producto;
	}

	public Categoria(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Categoria(int i) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codCat
	 */
	public int getCodCat() {
		return codCat;
	}

	/**
	 * @param codCat the codCat to set
	 */
	public void setCodCat(int codCat) {
		this.codCat = codCat;
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
	 * @return the producto
	 */
	public Set<Producto> getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}

}
