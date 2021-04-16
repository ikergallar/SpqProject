package com.SPQ.ProjectSPQ;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Categoria;

public class CategoriaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		Categoria categoria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		assertEquals("Fontaneria", categoria.getNombre());	
	}
	
	public void testGetDescripcion() {
		Categoria categoria=new Categoria("Fontaneria", "Te arreglo cañerias y retretes");
		assertEquals("Te arreglo cañerias y retretes", categoria.getDescripcion());	
	}
}