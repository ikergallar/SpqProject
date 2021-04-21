package com.SPQ.sockets;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class Cliente {
	
	public static void main(String[] args) {
		
		MarcoCliente mimarco = new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	
class MarcoCliente extends JFrame {
	
	public MarcoCliente() {
		
		setBounds (600, 300, 200, 350);
	
		LaminaMarcoCliente milamina = new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaMarcoCliente extends JPanel {
	
	private JTextField campo1, nick, ip;
	private JButton miboton;
	private JTextArea campoChat;
	
	public LaminaMarcoCliente() {
		
		nick = new JTextField(5);
		
		add(nick);
		
		JLabel texto = new JLabel("CHAT");
		
		add(texto);
		
		ip = new JTextField(8);
		
		add(ip);
		
		campoChat = new JTextArea(12,20);
		
		add(campoChat);
		
		campo1 = new JTextField(20);
		
		add(campo1);
		
		miboton = new JButton ("Enviar");
		
		EnviaTexto miEvento = new EnviaTexto(); 
		
		miboton.addActionListener(miEvento);
		
		add(miboton);
		
	
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//System.out.println(campo1.getText());
			
			try {
				Socket misocket = new Socket("192.168.56.1", 9999);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				datos.setIp(ip.getText());
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
				paquete_datos.writeObject(datos);
				
				misocket.close();
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
		
		
	}
}
class PaqueteEnvio implements Serializable{
	
	private String nick, ip, mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
