package com.SPQ.dao;

import java.util.List;
import java.util.ArrayList;

import com.SPQ.modelo.*;


public class ProductoDao {

	public static List getProductos() {
		List<Producto> lista = new ArrayList();
		Producto producto = new Producto(1, "Pez", 12);
		Producto producto1 = new Producto(2, "b", 23);
		Producto producto2 = new Producto(3, "c", 54);
		Producto producto3 = new Producto(4, "d", 80);
		Producto producto4 = new Producto(5, "e", 32);
		
		lista.add(producto);
		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);
		lista.add(producto4);
		return lista;
	}
	
}
