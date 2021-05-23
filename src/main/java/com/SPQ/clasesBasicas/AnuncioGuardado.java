package com.SPQ.clasesBasicas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/**
 * En la clase ANUNCIOGUARDADO almacenamos aquellos anuncios que han sido guardados
 * @author AitorA
 *
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class AnuncioGuardado extends Anuncio {
	private GregorianCalendar fecha;
	private String nombre;
	
	/**
	 * Devuelve la fecha
	 * @return GregorianCalendar con la fecha del AnuncioGuardado
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}
	/**
	 * Actualiza la fecha del AnuncioGuardado
	 * @param fecha GregorianCalendar con la fecha del AnuncioGuardado
	 */
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	/**
	 * Devuelve la nombre
	 * @return String con el nombre del AnuncioGuardado
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Actualiza el nombre del AnuncioGuardado
	 * @param nombre String con el nuevo nombre del AnuncioGuardado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Constructor de la clase AnuncioGuardado
	 * @param fecha GregorianCalendar para determinar la fecha de reserva de AnuncioGuardado
	 * @param nombre String para determinar el nombre del AnuncioGuardado
	 */
	public AnuncioGuardado(GregorianCalendar date, String nombre) {
		super();
		this.fecha = date;
		this.nombre = nombre;
	}
	/**
	 * Constructor vacio de la clase AnuncioGuardado
	 */
	public AnuncioGuardado() {
	}

}
