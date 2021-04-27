package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;

import junit.framework.JUnit4TestAdapter;

@RunWith(MockitoJUnitRunner.class)
public class AnuncioTest {
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(AnuncioTest.class);
		}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	Anuncio anuncio;
	
	@Before
	public void init() {
		
		anuncio = new Anuncio();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAYIL,true);
		assertEquals("Aitor", anuncio.getNombre());	
	}
	
	@Test
	public void testGetDescripcion() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true);		
		assertEquals("Ofrezco servicio de fontaneria", anuncio.getDescripcion());	
	}
		
	@Test
	public void testGetPrecio() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAYIL,true);		
		assertEquals(60, anuncio.getPrecio(), 0.0f);	
	}
	
	@Test
	public void testGetCategoria() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAYIL,true);		
		assertEquals(Categoria.ALBAYIL, anuncio.getCategoria());	
	}
	
}
