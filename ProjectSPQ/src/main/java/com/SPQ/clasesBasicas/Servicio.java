package com.SPQ.clasesBasicas;

public class Servicio {

	private String nombre;
	private String descripcion;
	private String foto;
	private int ref; //Referencia con id único
	private double precio;
	private String categoria;
	private String contacto;
	
	public Servicio(String nombre, String descripcion, String foto, int ref, double precio, String categoria, String contacto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.ref = ref;
		this.precio = precio;
		this.categoria = categoria;
		this.contacto = contacto;
	}
	
	public Servicio() {
		super();
		this.nombre = "";
		this.descripcion = "";
		this.foto = "";
		this.ref = 0;
		this.precio = 0.0;
		this.categoria = "";
		this.contacto = "";
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
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "Servicio [nombre=" + nombre + ", descripcion=" + descripcion + ", foto=" + foto + ", ref=" + ref + ", precio=" + precio
				+ ", categoria=" + categoria + ", contacto=" + contacto + "]";
	}
	
	
	
}
