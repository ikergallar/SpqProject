package com.SPQ.modelo;

public class Producto {

	private int id;
	private String nombreProducto;
	private float precio;
	
	public Producto(int id, String nombreProducto, float precio) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
