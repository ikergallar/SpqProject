package com.SPQ.clasesBasicas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class AnuncioGuardado extends Anuncio {
	private GregorianCalendar fecha;
	private String nombre;

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AnuncioGuardado(GregorianCalendar date, String nombre) {
		super();
		this.fecha = date;
		this.nombre = nombre;
	}

	public AnuncioGuardado() {
	}

}
