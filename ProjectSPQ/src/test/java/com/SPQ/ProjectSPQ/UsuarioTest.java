package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.clasesBasicas.UsuarioConectado;

import junit.framework.JUnit4TestAdapter;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class UsuarioTest {
	
	private Usuario u;
	private UsuarioConectado mockServer = Mockito.mock(UsuarioConectado.class);
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(UsuarioTest.class);
		}
	
	@Before
	public void setUp(){
		
		u= new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", mockServer);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetStatusConectado() {
		when(mockServer.isConnected("Peter")).thenReturn(true);
		assertEquals("Conectado", u.getNombre());	
	}
	
	@Test
	public void testgetStatusNoConectado() {
		when(mockServer.isConnected("Peter")).thenReturn(false);
		assertEquals("No conectado", u.getNombre());	
	}
	@Test
	public void testGetNombre() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("Aitor", usuario.getNombre());	
	}

	@Test
	public void testGetApellido() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("Davila", usuario.getApellido());	
	}

	@Test
	public void testGetNombreUsuario() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("aidav13", usuario.getNombreUsuario());	
	}
	
	@Test
	public void testGetPass() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?, null", null);
		assertEquals("pass123", usuario.getPass());	
	}
	
	@Test
	public void testGetMail() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("aidav@gmail.com", usuario.getMail());	
	}
	
	@Test
	public void testGetTelefono() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("6839283948", usuario.getTelefono());	
	}
	
	@Test
	public void testGetDireccion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("Calle Ave del Paraiso 9, Barcelona", usuario.getDireccion());	
	}
	
	@Test
	public void testGetDescripcion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("Buena zona", usuario.getDescripcion());	
	}
	
	@Test
	public void testGetAnuncio() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals(null,usuario.getAnuncios());	
	}
	
	@Test
	public void testGetPalabraRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("Dua", usuario.getPalabraRecuperacion());	
	}
	
	@Test
	public void testGetPreguntaRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?", null);
		assertEquals("¿Como se llama mi gato?", usuario.getPreguntaRecuperacion());	
	}

}