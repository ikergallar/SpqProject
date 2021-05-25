/**
 * @package ClasesBasicas
 *
 */
package com.SPQ.clasesBasicas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

/**
 * En la clase ANUNCIOGUARDADO almacenamos aquellos anuncios que han sido guardados
 * @author AitorA
 *
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class AnuncioGuardado {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idAnuncioGuardado;
	int idAnuncio;
	
	public int getIdAnuncio() {
		return idAnuncio;
	}
	public int getIdAnuncioGuardado() {
		return idAnuncioGuardado;
	}
	public void setIdAnuncioGuardado(int idAnuncioGuardado) {
		this.idAnuncioGuardado = idAnuncioGuardado;
	}
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	private GregorianCalendar fecha;
	int reportes;
	
	/**
	 * Devuelve la fecha
	 * @return GregorianCalendar con la fecha del AnuncioGuardado
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}
	/**
	 * Devuelve la fecha
	 * @return Int con los reportes de AnuncioGuardado
	 */
	public int getReportes() {
		return reportes;
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
	 * @param Int con el numero de reportes del AnuncioGuardado
	 */
	public void setReportes(int reportes) {
		this.reportes = reportes;
	}
	
	/**
	 * Constructor de la clase AnuncioGuardado
	 * @param fecha GregorianCalendar para determinar la fecha de reserva de AnuncioGuardado
	 * @param nombre String para determinar el nombre del AnuncioGuardado
	 */
	public AnuncioGuardado(GregorianCalendar date, int reportes, int IdAnuncio) {
		super();
		this.fecha = date;
		this.reportes = reportes;
		this.idAnuncio = idAnuncio;
	}
	
	/**
	 * Constructor vacio de la clase AnuncioGuardado
	 */
	public AnuncioGuardado() {
	}
	
	/**
	 * toString
	 */
	public String toString() {
		Client client = ClientBuilder.newClient();
		final WebTarget appTarget = client.target("http://localhost:8080/myapp");
		final WebTarget servicioTarget = appTarget.path("servicios");
		WebTarget seleccionarTarget = servicioTarget.path("servicio").queryParam("idanuncio",getIdAnuncio());
		GenericType<Anuncio> genericType = new GenericType<Anuncio>() {
		};
		
		Anuncio anuncio = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		
		return anuncio.getNombre() + ", " + anuncio.getDescripcion() + ", Fecha: " + fecha + ", " + anuncio.getPrecio() + " euros, CATEGORIA:" + anuncio.getCategoria();
	}

}
