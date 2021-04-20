package com.SPQ.sockets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;


public class Servidor {
	
public static void main(String[] args) {
		
		MarcoServidor mimarco = new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoServidor extends JFrame implements Runnable {
	
	private JTextArea areaTexto;
	
	public MarcoServidor() {
		setBounds (1200, 300, 280, 350);
		
		JPanel milamina = new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areaTexto = new JTextArea();
		
		milamina.add(areaTexto, BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread hilo = new Thread(this);
		
		hilo.start();
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Holaa");
		
		try {
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true) {
				
				Socket misocket = servidor.accept();
			
				DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
			
				String mensaje_texto = flujo_entrada.readUTF();
				
				areaTexto.append("\n" + mensaje_texto);
			
				misocket.close();
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

