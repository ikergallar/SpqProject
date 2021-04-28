package com.SPQ.clasesBasicas;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.SPQ.clasesBasicas.Categoria;

import junit.framework.JUnit4TestAdapter;

public class CategoriaTest{	   
	   
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValores() {
        String categoria = "ALBAYIL";
        Categoria expResult = Categoria.ALBAYIL;
        Categoria result = Categoria.valueOf(categoria);
        assertEquals(expResult, result);

    }
}