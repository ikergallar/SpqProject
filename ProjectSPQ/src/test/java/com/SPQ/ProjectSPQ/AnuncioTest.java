package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;

public class AnuncioTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		Usuario usuarioAitor =new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		Categoria fontaneria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", fontaneria, usuarioAitor);
		assertEquals("Aitor", anuncio.getNombre());	
	}
	
	@Test
	public void testGetDescripcion() {
		Usuario usuarioAitor =new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		Categoria fontaneria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", fontaneria, usuarioAitor);
		assertEquals("Ofrezco servicio de fontaneria", anuncio.getDescripcion());	
	}
	
	@Test
	public void testGetPrecio() {
		Usuario usuarioAitor =new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		Categoria fontaneria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", fontaneria,usuarioAitor);
		assertEquals(60, anuncio.getPrecio());	
	}
	
	@Test
	public void testGetCategoria() {
		Usuario usuarioAitor =new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		Categoria fontaneria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", fontaneria, usuarioAitor);
		assertEquals(fontaneria, anuncio.getCategoria());	
	}
	
	@Test
	public void testGetUsuario() {
		Usuario usuarioAitor =new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
		Categoria fontaneria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		Anuncio anuncio=new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", fontaneria, usuarioAitor);
		assertEquals(usuarioAitor, anuncio.getUsuario());	
	}
	


}
