package com.SPQ.clasesBasicas;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
	Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?", "Descripcion perfil");
		anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());		

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
	public void testGetFoto() {
		assertEquals("", anuncio.getFoto());	
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
		anuncio.setIdUsuario(anuncio.getIdAnuncio());
	} 
	@Test
	public void testSetNombre() {
		anuncio.setNombre(anuncio.getNombre());	
	}
	
	@Test
	public void testSetDescripcion() {
		anuncio.setDescripcion(anuncio.getDescripcion());
	}
		
	@Test
	public void testSetPrecio() {
		anuncio.setPrecio(anuncio.getPrecio());	
	}
	
	@Test
	public void testSetFoto() {
		anuncio.setFoto(anuncio.getFoto());
	}
	
	@Test
	public void testSetCategoria() {
		anuncio.setCategoria(anuncio.getCategoria());
	}
	
	@Test
	public void testSetOferta() {
		anuncio.setOferta(anuncio.isOferta());
	}
	
	@Test
	public void testSetIdUsuario() {
		anuncio.setIdUsuario(anuncio.getIdUsuario());
	} 
	
	@Test
	public void testToString() {
		anuncio.toString();
	} 
	@Test
	public void testGetComentarios() {
        List<Comentario> comentarios=null;
        anuncio.setComentarios(comentarios);
	}
	@Test
	public void testSetComentarios() {
		List<Comentario> comentarios=null;
        anuncio.setComentarios(comentarios);
        assertEquals(null, anuncio.getComentarios());
	}
	@Test
	public void testanyadirComentario() {
		Comentario coment = new Comentario();
		coment.generarComentario("Este es un mensaje de prueba", usuario);
		anuncio.anyadirComentario(anuncio, coment);
		
		assertEquals("Este es un mensaje de prueba",anuncio.getComentarios().get(0));	
	}
	
}
