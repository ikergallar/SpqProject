package com.SPQ.clasesBasicas;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Categoria {
	
	static String idCategoria;
	
	String nombre;
	String descripcion;
	
	
	
	public Categoria(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Categoria() {
		this.nombre = "";
		this.descripcion = "";
	}
	public static String getIdCategoria() {
		return idCategoria;
	}
	public static void setIdCategoria(String idCategoria) {
		Categoria.idCategoria = idCategoria;
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
	
	
	
	
}
