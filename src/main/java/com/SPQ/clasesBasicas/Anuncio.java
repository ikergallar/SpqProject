package com.SPQ.clasesBasicas;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Anuncio {
	static String idAnuncio;

	String nombre;
	String descripcion;
	float precio;
	String foto;
	private Categoria categoria;
	Usuario usuario;
	
	
	public Anuncio(String nombre, String descripcion, float precio, String foto, Categoria categoria, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.categoria = categoria;
		this.usuario = usuario;

	}
	
	public Anuncio() {
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0;
		this.foto = "";
		this.categoria = null;
		this.usuario = null;

	}
	
	public static String getIdAnuncio() {
		return idAnuncio;
	}
	public static void setIdAnuncio(String idAnuncio) {
		Anuncio.idAnuncio = idAnuncio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//
	public String printAnuncio() {
		return "Anuncio [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria.getNombre()  + "]";
	}
	
	
}
