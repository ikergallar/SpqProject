package com.SPQ.clasesBasicas;

import java.sql.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class AnuncioGuardado extends Anuncio{
	private Date fecha;
	private String nombre;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public AnuncioGuardado(String nombre, String descripcion, float precio, String foto, Categoria categoria,
			boolean oferta, Date fecha, String nombreGuardado) {
		super(nombre, descripcion, precio, foto, categoria, oferta);
		this.fecha = fecha;
		this.nombre = nombreGuardado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
