package com.SPQ.clasesBasicas;

import java.sql.Date;

public class AnuncioGuardado extends Anuncio{
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public AnuncioGuardado(String nombre, String descripcion, float precio, String foto, Categoria categoria,
			boolean oferta, String nombreUsuario, Date fecha) {
		super(nombre, descripcion, precio, foto, categoria, oferta, nombreUsuario);
		this.fecha = fecha;
	}
	
	
	

}
