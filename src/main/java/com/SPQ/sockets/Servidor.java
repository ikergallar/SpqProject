package com.SPQ.sockets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
			
			String nick, ip, mensaje;
			
			ArrayList<String> listaIp = new ArrayList<String>();
						
			PaqueteEnvio paquete_recibido;
					
			while(true) {
				
				Socket misocket = servidor.accept();
				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
				
				paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();
				
				nick = paquete_recibido.getNick();
				ip = paquete_recibido.getIp();
				mensaje = paquete_recibido.getMensaje();
				
				if(mensaje.equals(" online")) {
					
				areaTexto.append("\n" + nick + ": " + mensaje + " para " + ip);	
				
				Socket enviaDestinatario = new Socket(ip, 9090);
				
				ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
				
				paqueteReenvio.writeObject(paquete_recibido);
				paqueteReenvio.close();
				enviaDestinatario.close();
				misocket.close();
				}else {
						
				//------------------------ ONLINE ---------------------------------------------//
				
				InetAddress localizacion = misocket.getInetAddress();
			
				String ipRemota = localizacion.getHostAddress();
				
				System.out.println("Online "+ ipRemota);
				
				listaIp.add(ipRemota);
				
				for(String z:listaIp) {
					System.out.println("Array: "+ z);
				}
				//-----------------------------------------------------------------------------//
			}
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

