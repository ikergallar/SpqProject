package com.SPQ.clasesBasicas;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.SPQ.clasesBasicas.AnuncioGuardado;
import com.SPQ.clasesBasicas.Categoria;

public class AnuncioGuardadoTest {

	@Test
	public void testGetFecha() {
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = "11-11-2001";
			Date date = sdf.parse(fecha);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			AnuncioGuardado anuncio = new AnuncioGuardado(gc,"pedro");
			assertEquals("11-11-2001", sdf.format(anuncio.getFecha().getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testGetNombre() {
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = "11-11-2001";
			Date date = sdf.parse(fecha);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			AnuncioGuardado anuncio = new AnuncioGuardado(gc,"pedro");
			assertEquals("pedro", anuncio.getNombre());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testSetNombre() {
		AnuncioGuardado anuncio = new AnuncioGuardado();
		String nombre = "Pedro";
		anuncio.setNombre(nombre);
	}
	
	@Test
	public void testSetFecha() {
		
		try {
			AnuncioGuardado anuncio = new AnuncioGuardado();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = "11-11-2001";
			Date date;
			date = sdf.parse(fecha);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			anuncio.setFecha(gc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
