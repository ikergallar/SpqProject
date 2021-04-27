package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.clasesBasicas.UsuarioConectado;

import junit.framework.JUnit4TestAdapter;

import static org.mockito.Mockito.*;

public class UsuarioTest {
	
	private Usuario u;
//	private UsuarioConectado mockServer = mock(UsuarioConectado.class);
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(UsuarioTest.class);
		}
	
	@Before
	public void setUp(){
		
		u= new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
	}
	
	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testgetStatusConectado() {
//		when(UsuarioConectado.isConnected("Peter")).thenReturn(true);
//		assertEquals("Conectado", u.getNombre());	
//	}
//	
//	@Test
//	public void testgetStatusNoConectado() {
//		when(UsuarioConectado.isConnected("Peter")).thenReturn(false);
//		assertEquals("No conectado", u.getNombre());	
//	}
	@Test
	public void testGetNombre() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("Aitor", usuario.getNombre());	
	}

	@Test
	public void testGetApellido() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("Davila", usuario.getApellido());	
	}

	@Test
	public void testGetNombreUsuario() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("aidav13", usuario.getNombreUsuario());	
	}
	
	@Test
	public void testGetPass() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("pass123", usuario.getPass());	
	}
	
	@Test
	public void testGetMail() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("aidav@gmail.com", usuario.getMail());	
	}
	
	@Test
	public void testGetTelefono() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("6839283948", usuario.getTelefono());	
	}
	
	@Test
	public void testGetDireccion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("Calle Ave del Paraiso 9, Barcelona", usuario.getDireccion());	
	}
	
	@Test
	public void testGetPalabraRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("Dua", usuario.getPalabraRecuperacion());	
	}
	
	@Test
	public void testGetPreguntaRecuperacion() {
		Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		assertEquals("¿Como se llama mi gato?", usuario.getPreguntaRecuperacion());	
	}
	
	@Test
	public void testSetNombre() {
		Usuario usuario=new Usuario();
		String nombre = "Aitor";
		usuario.setNombre(nombre);
	}
	
	@Test
	public void testSetApellido() {
		Usuario usuario=new Usuario();
		String apellido = "Davila";
		usuario.setApellido(apellido);
	}
	
	@Test
	public void testSetNombreUsuario() {
		Usuario usuario=new Usuario();
		String nombreUsuario = "aidav123";
		usuario.setNombreUsuario(nombreUsuario);
	}
	@Test
	public void testSetPass() {
		Usuario usuario=new Usuario();
		String pass = "pass123";
		usuario.setPass(pass);
	}
	
	@Test
	public void testSetMail() {
		Usuario usuario=new Usuario();
		String mail = "aidav@gmail.com";
		usuario.setMail(mail);
	}
	
	@Test
	public void testSetTelefono() {
		Usuario usuario=new Usuario();
		String telefono = "6839283948";
		usuario.setTelefono(telefono);
	}
	
	@Test
	public void testSetDireccion() {
		Usuario usuario=new Usuario();
		String direccion = "Calle Ave del Paraiso 9, Barcelona";
		usuario.setDireccion(direccion);
	}
	
	@Test
	public void testSetPalabraRecuperacion() {
		Usuario usuario=new Usuario();
		String palabraRecuperacion = "Dua";
		usuario.setPalabraRecuperacion(palabraRecuperacion);
	}
	
	@Test
	public void testSetPreguntaRecuperacion() {
		Usuario usuario=new Usuario();
		String preguntaRecuperacion = "¿Como se llama mi gato?";
		usuario.setPreguntaRecuperacion(preguntaRecuperacion);
	}

}