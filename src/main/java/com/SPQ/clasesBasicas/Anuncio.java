package com.SPQ.clasesBasicas;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Anuncio {
	private static String idAnuncio;

	private String nombre;
	private String descripcion;
	private float precio;
	private String foto;
	private Categoria categoria;
	private boolean oferta;
	private String nombreUsuario;
	
	
	
	public Anuncio(String nombre, String descripcion, float precio, String foto, Categoria categoria,boolean oferta, String nombreUsuario, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.categoria = categoria;
		this.nombreUsuario = nombreUsuario;
		this.oferta = oferta;
		
		

	}
	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	
	public Anuncio() {
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0;
		this.foto = "";
		this.categoria = categoria.NINGUNA;
		this.nombreUsuario = "";

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
	public String getnombreUsuario() {
		return nombreUsuario;
	}
	public void setnombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	//
	public String printAnuncio() {
		return "Anuncio [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria + "]";
	}
	
	
}
