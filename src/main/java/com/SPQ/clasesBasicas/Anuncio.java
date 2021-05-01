package com.SPQ.clasesBasicas;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Anuncio {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idAnuncio;

	private String nombre;
	private String descripcion;
	private float precio;
	private String foto;
	private Categoria categoria;
	private boolean oferta;
	@ForeignKey
	private int idUsuario;
	
	
	
	public Anuncio(String nombre, String descripcion, float precio, String foto, Categoria categoria,boolean oferta, int idUsuario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.categoria = categoria;
		this.oferta = oferta;
		this.idUsuario = idUsuario;

				
	}
	
	public Anuncio() {
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0;
		this.foto = "";
		this.categoria = categoria.NINGUNA;
		this.oferta = false;
		this.idUsuario = 0;


	}

	public int getIdAnuncio() {
		return idAnuncio;
	}
	public  void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
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
	public double getPrecio() {
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
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int nombreUsuario) {
		this.idUsuario = nombreUsuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	@Override
	public String toString() {
		return nombre + ", " + descripcion + ", " + precio + " euros, CATEGORIA:" + categoria;
	}
	
	
	
	
	
	
}
