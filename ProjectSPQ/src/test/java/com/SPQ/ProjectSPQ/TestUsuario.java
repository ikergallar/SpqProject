package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Usuario;

public class TestUsuario {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getNombre(),"Aitor");	
	}

	@Test
	public void testGetApellido() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getApellido(),"Davila");	
	}

	@Test
	public void testGetNombreUsuario() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getNombreUsuario(),"aidav13");	
	}
	
	@Test
	public void testGetPass() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getPass(),"pass123");	
	}
	
	@Test
	public void testGetMail() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getMail(),"aidav@gmail.com");	
	}
	
	@Test
	public void testGetTelefono() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getTelefono(),"6839283948");	
	}
	
	@Test
	public void testGetDireccion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getDireccion(),"Calle Ave del Paraiso 9, Barcelona");	
	}
	
	@Test
	public void testGetDescripcion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getDescripcion(),"Buena zona");	
	}
	
	@Test
	public void testGetAnuncio() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getAnuncios(),null);	
	}
	
	@Test
	public void testGetPalabraRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getPalabraRecuperacion(),"Dua");	
	}
	
	@Test
	public void testGetPreguntaRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		assertEquals(usuario.getPreguntaRecuperacion(),"¿Como se llama mi gato?");	
	}

}