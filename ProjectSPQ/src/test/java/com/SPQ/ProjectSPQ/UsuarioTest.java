package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Usuario;

public class UsuarioTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("Aitor", usuario.getNombre());	
	}

	@Test
	public void testGetApellido() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("Davila", usuario.getApellido());	
	}

	@Test
	public void testGetNombreUsuario() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("aidav13", usuario.getNombreUsuario());	
	}
	
	@Test
	public void testGetPass() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("pass123", usuario.getPass());	
	}
	
	@Test
	public void testGetMail() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("aidav@gmail.com", usuario.getMail());	
	}
	
	@Test
	public void testGetTelefono() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("6839283948", usuario.getTelefono());	
	}
	
	@Test
	public void testGetDireccion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("Calle Ave del Paraiso 9, Barcelona", usuario.getDireccion());	
	}
	
	@Test
	public void testGetDescripcion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("Buena zona", usuario.getDescripcion());	
	}
	
	@Test
	public void testGetAnuncio() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(null,usuario.getAnuncios());	
	}
	
	@Test
	public void testGetPalabraRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("Dua", usuario.getPalabraRecuperacion());	
	}
	
	@Test
	public void testGetPreguntaRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals("¿Como se llama mi gato?", usuario.getPreguntaRecuperacion());	
	}

}