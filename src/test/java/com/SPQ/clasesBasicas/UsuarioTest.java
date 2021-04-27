package com.SPQ.clasesBasicas;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.clasesBasicas.UsuarioConectado;

import junit.framework.JUnit4TestAdapter;

import static org.mockito.Mockito.*;

import org.glassfish.jersey.test.JerseyTest;

public class UsuarioTest {
	
	private Usuario usuario;
//	private UsuarioConectado mockServer = mock(UsuarioConectado.class);
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(UsuarioTest.class);
		}
	
	@Before
	public void setUp(){
		 usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
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
	public void testGetIdUsuario() {
        usuario.setIdUsuario(1);
        assertEquals(1, usuario.getIdUsuario());
	}
	@Test
	public void testGetNombre() {
		assertEquals("Aitor", usuario.getNombre());	
		
	}

	@Test
	public void testGetApellido() {
		assertEquals("Davila", usuario.getApellido());	
	}

	@Test
	public void testGetNombreUsuario() {
		assertEquals("aidav13", usuario.getNombreUsuario());	
	}
	
	@Test
	public void testGetPass() {
		assertEquals("pass123", usuario.getPass());	
	}
	
	@Test
	public void testGetMail() {
		assertEquals("aidav@gmail.com", usuario.getMail());	
	}
	
	@Test
	public void testGetTelefono() {
		assertEquals("6839283948", usuario.getTelefono());	
	}
	
	@Test
	public void testGetDireccion() {
		assertEquals("Calle Ave del Paraiso 9, Barcelona", usuario.getDireccion());	
	}
	
	@Test
	public void testGetFoto() {
		assertEquals("", usuario.getFoto());	
	}
	
	@Test
	public void testGetPalabraRecuperacion() {
		assertEquals("Dua", usuario.getPalabraRecuperacion());	
	}
	
	@Test
	public void testGetPreguntaRecuperacion() {
		assertEquals("¿Como se llama mi gato?", usuario.getPreguntaRecuperacion());	
	}
	
	@Test
	public void testSetIdUsuario() {
		int idUsuario = 1;
		usuario.setIdUsuario(idUsuario);
	}
	
	@Test
	public void testSetNombre() {
		String nombre = "Aitor";
		usuario.setNombre(nombre);
	}
	
	@Test
	public void testSetApellido() {
		String apellido = "Davila";
		usuario.setApellido(apellido);
	}
	
	@Test
	public void testSetNombreUsuario() {
		String nombreUsuario = "aidav123";
		usuario.setNombreUsuario(nombreUsuario);
	}
	@Test
	public void testSetPass() {
		String pass = "pass123";
		usuario.setPass(pass);
	}
	
	@Test
	public void testSetMail() {
		String mail = "aidav@gmail.com";
		usuario.setMail(mail);
	}
	
	@Test
	public void testSetTelefono() {
		String telefono = "6839283948";
		usuario.setTelefono(telefono);
	}
	
	@Test
	public void testSetDireccion() {
		String direccion = "Calle Ave del Paraiso 9, Barcelona";
		usuario.setDireccion(direccion);
	}
	
	@Test
	public void testSetFoto() {
		String foto = "";
		usuario.setFoto(foto);
	}
	
	@Test
	public void testSetPalabraRecuperacion() {
		String palabraRecuperacion = "Dua";
		usuario.setPalabraRecuperacion(palabraRecuperacion);
	}
	
	@Test
	public void testSetPreguntaRecuperacion() {
		String preguntaRecuperacion = "¿Como se llama mi gato?";
		usuario.setPreguntaRecuperacion(preguntaRecuperacion);
	}
	
	

}