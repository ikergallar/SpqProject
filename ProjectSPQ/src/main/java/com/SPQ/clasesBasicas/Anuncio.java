package com.SPQ.clasesBasicas;

public class Anuncio {
	static String idAnuncio;

	String nombre;
	String descripcion;
	float precio;
	String foto;
	Categoria categoria;
	String usuario; //identificador del usuario que ha creado el anuncio
	
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	//
	public String printAnuncio() {
		return "Anuncio [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria.getNombre() + ", usuario=" + usuario + "]";
	}
	
	
}
