package com.SPQ.ProjectSPQ;

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
	public void testGetIdAnuncio() {
	    Anuncio anuncio = new Anuncio();
        anuncio.setIdAnuncio(1);
        assertEquals(1, anuncio.getIdAnuncio());
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
	
	@Test
	public void testIsOferta() {
		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAYIL,true);		
		assertEquals(true, anuncio.isOferta());	
	}
	
	@Test
	public void testGetIdUsuario() {
	    Anuncio anuncio = new Anuncio();
        anuncio.setIdUsuario(1);
        assertEquals(1, anuncio.getIdUsuario());
	}
	
	@Test
	public void testSetIdAnuncio() {
		Anuncio anuncio=new Anuncio();
		int idAnuncio = 1;
		anuncio.setIdUsuario(idAnuncio);
	} 
	@Test
	public void testSetNombre() {
		Anuncio anuncio= new Anuncio();
		String nombre = "Aitor";
		anuncio.setNombre(nombre);	
	}
	
	@Test
	public void testSetDescripcion() {
		Anuncio anuncio= new Anuncio();
		String descripcion = "Ofrezco servicio de fontaneria";
		anuncio.setDescripcion(descripcion);
	}
		
	@Test
	public void testSetPrecio() {
		Anuncio anuncio= new Anuncio();
		Float precio = 60.0f;
		anuncio.setPrecio(precio);	
	}
	
	@Test
	public void testSetCategoria() {
		Anuncio anuncio= new Anuncio();		
		Categoria categoria = Categoria.FONTANERO;
		anuncio.setCategoria(categoria);
	}
	
	@Test
	public void testSetOferta() {
		Anuncio anuncio= new Anuncio();		
		boolean oferta = true;
		anuncio.setOferta(oferta);
	}
	
	@Test
	public void testSetIdUsuario() {
		Anuncio anuncio=new Anuncio();
		int idUsuario = 1;
		anuncio.setIdUsuario(idUsuario);
	} 
	
}
