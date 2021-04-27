package com.SPQ.main;

import com.SPQ.ventanasAnuncio.VentanaAnuncios;
import com.SPQ.ventanasLogin.VentanaLogin;

public class Main {
	
	VentanaLogin frmLogin = new VentanaLogin();
	
	public static void main(String[] args) {
		
//		VentanaLogin inicio = new VentanaLogin();
//		inicio.frmLogin.setVisible(true);
		
		VentanaAnuncios inicio = new VentanaAnuncios();
		inicio.setVisible(true);
		
		
		

	}

}
