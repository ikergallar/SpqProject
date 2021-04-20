package com.SPQ.sockets;

import java.awt.BorderLayout;

import javax.swing.*;


public class Servidor {
	
public static void main(String[] args) {
		
		MarcoServidor mimarco = new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoServidor extends JFrame {
	
	private JTextArea areaTexto;
	
	public MarcoServidor() {
		setBounds (1200, 300, 280, 350);
		
		JPanel milamina = new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areaTexto = new JTextArea();
		
		milamina.add(areaTexto, BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
	
	}
}

