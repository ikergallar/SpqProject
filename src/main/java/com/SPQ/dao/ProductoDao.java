package com.SPQ.dao;

import java.util.List;
import java.util.ArrayList;

import com.SPQ.clasesBasicas.Usuario;


public class ProductoDao {

	public static List getUsuarios() {
		
		List<Usuario> lista = new ArrayList();
		
		Usuario usuario = new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		Usuario usuario1 = new Usuario("Juan", "Gomez" , "gomezJuan", "7","gomezJuan@gmail.com" , "678987123" ,"Calle Colon 13, Zaragoza","","Misifu","¿Como se llama mi gato?");
		Usuario usuario2 = new Usuario("Markel", "Alegria" , "markai", "091","markAle@gmail.com" , "786123064" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		Usuario usuario3 = new Usuario("Marta", "Fournier" , "marfur", "091","marF@gmail.com" , "672094560" ,"Calle Uhagon 12, Pamplona","","Dua","¿Como se llama mi gato?");
		Usuario usuario4 = new Usuario("Maria", "Gallarzagoitia" , "marGa", "893","marGallar@gmail.com" , "641527093" ,"Calle Bilbao, Sevilla","","Whiskas","¿Como se llama mi gato?");
		
		lista.add(usuario);
		lista.add(usuario1);
		lista.add(usuario2);
		lista.add(usuario3);
		lista.add(usuario4);
		
		return lista;
	}
	
}
