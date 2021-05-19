package com.SPQ.clasesBasicas;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComentarioTest {
	
	Usuario user;
	Comentario coment;
	
	@Before
	public void setUp() throws Exception {
		user=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?", "Descripcion perfil");
		coment=new Comentario("comentario de prueba", user.getNombreUsuario(), "17/05/2021");

	}
		
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMensaje() {
        assertEquals("comentario de prueba", coment.getMensaje());
	} 
	
	@Test
	public void testSetMensaje() {
		String mensaje2="mensaje 2";
		coment.setMensaje(mensaje2);	
	}
	
	@Test
	public void testGetNombreUsuario() {
        assertEquals("aidav13", coment.getNombreUsuario());
	} 
	
	@Test
	public void testSetNombreUsuario() {
		String nombreUsuario2="aitorf";
		coment.setMensaje(nombreUsuario2);	
	}
	@Test
	public void testGetFecha() {
        assertEquals("17/05/2021", coment.getFecha());
	} 
	
	@Test
	public void testSetFecha() {
		String fecha2="18/05/2021";
		coment.setMensaje(fecha2);	
	}
	@Test
	public void testGenerarComentario() {
		Comentario comentGen=new Comentario();
		comentGen.generarComentario("hol", user);
        assertEquals("aidav13", comentGen.getNombreUsuario());
	}
	

}
