package com.SPQ.clasesBasicas;

public class Categoria {
	
	static String idCategoria;
	
	String nombre;
	String descripcion;
	
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
