package com.SPQ.clasesBasicas;

import static org.junit.Assert.assertEquals;

import org.glassfish.jersey.test.JerseyTest;
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
	
	Anuncio anuncio;
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(AnuncioTest.class);
		}
	
	
	@Before
	public void setUp() throws Exception {
		anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true);		

	}
		
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIdAnuncio() {
	    Anuncio anuncio = new Anuncio();
        anuncio.setIdAnuncio(1);
        assertEquals(1, anuncio.getIdAnuncio());
	} 
	
	@Test
	public void testGetNombre() {
		assertEquals("Aitor", anuncio.getNombre());	
	}
	
	@Test
	public void testGetDescripcion() {
		assertEquals("Ofrezco servicio de fontaneria", anuncio.getDescripcion());	
	}
		
	@Test
	public void testGetPrecio() {
		assertEquals(60, anuncio.getPrecio(), 0.0f);	
	}
	
	@Test
	public void testGetCategoria() {
		assertEquals(Categoria.FONTANERO, anuncio.getCategoria());	
	}
	
	@Test
	public void testIsOferta() {
		assertEquals(true, anuncio.isOferta());	
	}
	
	@Test
	public void testGetIdUsuario() {
        anuncio.setIdUsuario(1);
        assertEquals(1, anuncio.getIdUsuario());
	}
	
	@Test
	public void testSetIdAnuncio() {
		int idAnuncio = 1;
		anuncio.setIdUsuario(idAnuncio);
	} 
	@Test
	public void testSetNombre() {
		String nombre = "Aitor";
		anuncio.setNombre(nombre);	
	}
	
	@Test
	public void testSetDescripcion() {
		String descripcion = "Ofrezco servicio de fontaneria";
		anuncio.setDescripcion(descripcion);
	}
		
	@Test
	public void testSetPrecio() {
		Float precio = 60.0f;
		anuncio.setPrecio(precio);	
	}
	
	@Test
	public void testSetCategoria() {
		Categoria categoria = Categoria.FONTANERO;
		anuncio.setCategoria(categoria);
	}
	
	@Test
	public void testSetOferta() {
		boolean oferta = true;
		anuncio.setOferta(oferta);
	}
	
	@Test
	public void testSetIdUsuario() {
		int idUsuario = 1;
		anuncio.setIdUsuario(idUsuario);
	} 
	
}
