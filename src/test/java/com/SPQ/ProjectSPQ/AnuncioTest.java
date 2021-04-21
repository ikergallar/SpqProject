package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;

import junit.framework.JUnit4TestAdapter;

public class AnuncioTest {
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(AnuncioTest.class);
		}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, "gomezJuan");
		assertEquals("Aitor", anuncio.getNombre());	
	}
	
	@Test
	public void testGetDescripcion() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, "gomezJuan");		
		assertEquals("Ofrezco servicio de fontaneria", anuncio.getDescripcion());	
	}
		
	@Test
	public void testGetPrecio() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, "gomezJuan");		
		assertEquals(60, anuncio.getPrecio(), 0.0f);	
	}
	
	@Test
	public void testGetCategoria() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, "gomezJuan");		
		assertEquals(Categoria.ALBAÑIL, anuncio.getCategoria());	
	}
	
	@Test
	public void testGetNombreUsuario() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, "gomezPepe");
		assertEquals("gomezPepe", anuncio.getNombreUsuario());	
	}
	
}
