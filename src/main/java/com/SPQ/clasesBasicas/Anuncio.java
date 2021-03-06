/**
 *  @package ClasesBasicas
 */
package com.SPQ.clasesBasicas;

import java.util.List;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase Anuncio donde cada anuncio tiene su id, nombre, descripcion, precio, categoria,
 * oferta, comentario, valoracion, y contador
 *  @author Iker
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Anuncio {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idAnuncio;

	private String nombre;
	private String descripcion;
	private float precio;
	private String foto;
	private Categoria categoria;
	protected boolean oferta;
	private List<Comentario> comentarios;
	
	
	@ForeignKey
	private int idUsuario;

	/**
	 * Constructor con argumentos de la clase Anuncio
	 * @param String nombre del Anuncio	
	 * @param String descripcion del Anuncio	
	 * @param Float precio del Anuncio
	 * @param String foto del Anuncio
	 * @param Enum categoria del Anuncio
	 * @param Boolean oferta del Anuncio
	 * @param Int idUsuario del anuncio
	 */
	public Anuncio(String nombre, String descripcion, float precio, String foto, Categoria categoria, boolean oferta,
			int idUsuario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.categoria = categoria;
		this.oferta = oferta;
		this.idUsuario = idUsuario;

	}
	
	/**
	 * Constructor sin argumentos de la clase Anuncio
	 */
	public Anuncio() {
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0;
		this.foto = "";
		this.categoria = categoria.NINGUNA;
		this.oferta = false;
		this.idUsuario = 0;
		this.comentarios = null;
	}

	/**
	 * Devuelve el id del Anuncio
	 * @return Int del valor del Id
	 */
	public int getIdAnuncio() {
		return idAnuncio;
	}
	/**
	 * Actualiza el id del Anuncio
	 * @param int id con el nuevo valor
	 */
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	/**
	 * Devuelve el nombre del Anuncio
	 * @return String del valor del nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Actualiza el nombre del Anuncio
	 * @param String nombre con el nuevo valor
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve la descripcion del Anuncio
	 * @return String descripcion del anuncio
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Actualiza la descripcion del Anuncio
	 * @param String descripcion con el nuevo valor
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Devuelve el precio del Anuncio
	 * @return Float precio del anuncio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Actualiza el precio del Anuncio
	 * @param Float precio con el nuevo valor
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * Devuelve la foto del Anuncio
	 * @return String foto del anuncio
	 */
	public String getFoto() {
		return foto;
	}
	/**
	 * Actualiza la foto del Anuncio
	 * @param String foto con el nuevo valor
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	/**
	 * Devuelve el id del usuario que ha creado el Anuncio
	 * @return int idUsuario del anuncio
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Actualiza el idUsuario del Anuncio
	 * @param int idUsuario del anuncio con el nuevo valor
	 */
	public void setIdUsuario(int nombreUsuario) {
		this.idUsuario = nombreUsuario;
	}
	/**
	 * Devuelve la categotia del Anuncio
	 * @return enum de la categoria del anuncio
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * Actualiza la categoria del Anuncio
	 * @param String nombre con el nuevo valor
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	/**
	 * Devuelve si el anuncio tiene oferta 
	 * @return boolean de la oferta del anuncio
	 */
	public boolean isOferta() {
		return oferta;
	}
	/**
	 * Actualiza la oferta del Anuncio
	 * @param Boolean oferta con el nuevo valor
	 */
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	/**
	 * Devuelve la lista de comentatarios del Anuncio
	 * @return lista de los comentarios del anuncio
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	/**
	 * Actualiza la lista de comentarios del Anuncio
	 * @param Lista comentarios con el nuevo valor
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return nombre + ", " + descripcion + ", " + precio + " euros, CATEGORIA:" + categoria;
	}
	/**
	 * Anyadir comentario al anuncio
	 * @param Anuncio
	 * @param Comentario
	 */
	

}
