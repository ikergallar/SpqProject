package com.SPQ.ventanaRegistro;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.ventanasLogin.VentanaRegistro;

public class VentanaRegistroTest {
	Usuario usuario;
	
	@Before
	public void setUp(){
		 usuario=new Usuario("Iker", "Gallardo" , "gallardoIker", "123","gallardoIker@gmail.com" , "7172839023" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testRegistro() {
		
		VentanaRegistro registro = new VentanaRegistro();
		//boolean resultado = registro.registro("aidav", "pass123");
		boolean acceso = false;
		
		if (usuario.getPass().equals("123")) {
			acceso = true;				
		}
		
		//assertEquals(acceso,resultado);
		
	}

}