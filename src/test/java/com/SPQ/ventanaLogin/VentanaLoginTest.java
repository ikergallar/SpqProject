package com.SPQ.ventanaLogin;
//package com.SPQ.ventanaLogin;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.SPQ.clasesBasicas.Usuario;
//import com.SPQ.ventanasLogin.VentanaLogin;
//
//public class VentanaLoginTest {
//	Usuario usuario;
//	
//	@Before
//	public void setUp(){
//		 usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
//	}
//	
//	@After
//	public void tearDown() throws Exception {
//	}
//	
//	@Test
//	public void testLogin() {
//		
//		VentanaLogin login = new VentanaLogin();
//		boolean resultado = login.login("aidav", "pass123");
//		boolean acceso = false;
//		
//		if (usuario.getPass().equals("pass123")) {
//			acceso = true;				
//		}
//		
//		assertEquals(acceso,resultado);
//		
//	}
//
//}
