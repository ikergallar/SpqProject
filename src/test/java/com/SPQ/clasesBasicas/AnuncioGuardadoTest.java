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
	public void testGetNombre() {
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fecha1 = "11-11-2001";
			Date d1 = sdf.parse(fecha1);
			GregorianCalendar gc1 = new GregorianCalendar();
			gc1.setTimeInMillis(d1.getTime());
			AnuncioGuardado anuncio = new AnuncioGuardado(gc1,"pedro");
			assertEquals("11-11-2001", sdf.format(anuncio.getFecha().getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
