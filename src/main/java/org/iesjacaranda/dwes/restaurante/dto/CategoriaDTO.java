package org.iesjacaranda.dwes.restaurante.dto;

/**
 * @author Manuel Melero
 *
 */
import java.util.Set;


public class CategoriaDTO {

	private int codCat;

	private String nombre;

	private String descripcion;

	private Set<ProductoDTO> producto;

	/**
	 * 
	 */
	public CategoriaDTO() {
		super();
	}
	
	/**
	 * @param nombre
	 * @param descripcion
	 */
	public CategoriaDTO(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * @param codCat
	 * @param nombre
	 * @param descripcion
	 */
	public CategoriaDTO(int codCat, String nombre, String descripcion) {
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
	public CategoriaDTO(int codCat, String nombre, String descripcion, Set<ProductoDTO> producto) {
		super();
		this.codCat = codCat;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.producto = producto;
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
	public Set<ProductoDTO> getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Set<ProductoDTO> producto) {
		this.producto = producto;
	}

}
