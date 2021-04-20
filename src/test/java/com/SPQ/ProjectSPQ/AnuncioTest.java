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
		Usuario usuarioAitor=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, usuarioAitor);
		assertEquals("Aitor", anuncio.getNombre());	
	}
	
	@Test
	public void testGetDescripcion() {
		Usuario usuarioAitor=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, usuarioAitor);
		assertEquals("Ofrezco servicio de fontaneria", anuncio.getDescripcion());	
	}
		
	@Test
	public void testGetPrecio() {
		Usuario usuarioAitor=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true,usuarioAitor);
		assertEquals(60, anuncio.getPrecio(), 0.0f);	
	}
	
	@Test
	public void testGetCategoria() {
		Usuario usuarioAitor=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, usuarioAitor);
		assertEquals(Categoria.ALBAÑIL, anuncio.getCategoria());	
	}
	
	@Test
	public void testGetUsuario() {
		Usuario usuarioAitor=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.ALBAÑIL,true, usuarioAitor);
		assertEquals(usuarioAitor, anuncio.getUsuario());	
	}
	


}
