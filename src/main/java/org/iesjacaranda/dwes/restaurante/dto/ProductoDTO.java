package org.iesjacaranda.dwes.restaurante.dto;

/**
 * @author Manuel Melero
 *
 */
import java.sql.Date;
import java.util.Set;

import org.iesjacaranda.dwes.restaurante.entities.Categoria;

public class ProductoDTO {

	private int codPro;
	
	private String nombre;

	private String descripcion;

	private Date fecha;

	private double peso;

	private int stock;

	private CategoriaDTO codCat;

	private Set<PedidoProductoDTO> pedidoProducto;

	/**
	 * 
	 */
	public ProductoDTO() {
		super();
	}
	
	/**
	 * @param codProd
	 * @param nombre
	 * @param descripcion
	 * @param fecha
	 * @param peso
	 * @param stock
	 * @param codCat
	 */
	public ProductoDTO(String nombre, String descripcion, Date fecha, double peso, int stock,
			CategoriaDTO codCat) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.peso = peso;
		this.stock = stock;
		this.codCat = codCat;
	}
	
	/**
	 * @param codPro
	 * @param nombre
	 * @param descripcion
	 * @param peso
	 * @param stock
	 */
	public ProductoDTO(int codPro, String nombre, String descripcion, double peso, int stock) {
		super();
		this.codPro = codPro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;

	}
	
	/**
	 * @param codPro
	 * @param nombre
	 * @param descripcion
	 * @param fecha
	 * @param peso
	 * @param stock
	 */
	public ProductoDTO(int codPro, String nombre, String descripcion, Date fecha, double peso, int stock) {
		super();
		this.codPro = codPro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.peso = peso;
		this.stock = stock;

	}

	/**
	 * @param codPro
	 * @param nombre
	 * @param descripcion
	 * @param fecha
	 * @param peso
	 * @param stock
	 * @param codCat
	 */
	public ProductoDTO(int codPro, String nombre, String descripcion, Date fecha, double peso, int stock,
			CategoriaDTO codCat) {
		super();
		this.codPro = codPro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.peso = peso;
		this.stock = stock;
		this.codCat = codCat;
	}
	
	/**
	 * @param codPro
	 * @param nombre
	 * @param descripcion
	 * @param fecha
	 * @param peso
	 * @param stock
	 * @param codCat
	 * @param pedidoProducto
	 */
	public ProductoDTO(int codPro, String nombre, String descripcion, Date fecha, double peso, int stock,
			CategoriaDTO codCat, Set<PedidoProductoDTO> pedidoProducto) {
		super();
		this.codPro = codPro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.peso = peso;
		this.stock = stock;
		this.codCat = codCat;
		this.pedidoProducto = pedidoProducto;
	}

	/**
	 * @return the codPro
	 */
	public int getCodPro() {
		return codPro;
	}

	/**
	 * @param codPro the codPro to set
	 */
	public void setCodPro(int codPro) {
		this.codPro = codPro;
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
	public CategoriaDTO getCodCat() {
		return codCat;
	}

	/**
	 * @param codCat the codCat to set
	 */
	public void setCodCat(CategoriaDTO codCat) {
		this.codCat = codCat;
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

	@Override
	public String toString() {
		return "ProductoDTO [codPro=" + codPro + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha="
				+ fecha + ", peso=" + peso + ", stock=" + stock + "]";
	}
	
	

}
