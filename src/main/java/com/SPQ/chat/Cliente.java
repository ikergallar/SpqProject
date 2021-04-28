package com.SPQ.chat;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

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
		
		addWindowListener(new EnvioOnline());
	}
}

//-------------- ENVIO SEÑAL ONLINE -----------------------------------
class EnvioOnline extends WindowAdapter{
	
	public void WindowOpened(WindowEvent e) {
		try {
			
			Socket misocket = new Socket("192.168.0.194", 9999);
			
			PaqueteEnvio datos = new PaqueteEnvio();
			
			datos.setMensaje("Online");
			
			ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
			
			paquete_datos.writeObject(datos);
			
			misocket.close();
		}catch(Exception e1) {
			
		}
	}
}

//-----------------------------------------------------------------------

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	private JTextField campo1;
	private JComboBox ip;
	private JLabel nick;
	private JButton miboton;
	private JTextArea campoChat;
	
	public LaminaMarcoCliente() {
		
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		
		JLabel n_nick = new JLabel("Nick: ");
		
		add(n_nick);
		
		nick = new JLabel();
		
		nick.setText(nick_usuario);
		
		add(nick);
		
		JLabel texto = new JLabel("Online: ");
		
		add(texto);
		
		ip = new JComboBox();
		
		/*ip.addItem("Usuario 1");
		ip.addItem("Usuario 2");
		ip.addItem("Usuario 3");
		
		ip.addItem("192.168.0.197");
		ip.addItem("192.168.0.198");*/
		
		add(ip);	
		
		campoChat = new JTextArea(12,20);
		
		add(campoChat);
		
		campo1 = new JTextField(20);
		
		add(campo1);
		
		miboton = new JButton ("Enviar");
		
		EnviaTexto miEvento = new EnviaTexto(); 
		
		miboton.addActionListener(miEvento);
		
		add(miboton);
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
		
	
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//System.out.println(campo1.getText());
			
			campoChat.append("\n" + campo1.getText());
			
			try {
				Socket misocket = new Socket("192.168.56.1", 9999);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				datos.setIp(ip.getSelectedItem().toString());
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket servidorCliente = new ServerSocket(9090);
			Socket cliente;
			PaqueteEnvio paqueteRecibido;
			
			while(true) { 
				cliente = servidorCliente.accept();
				
				ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido = (PaqueteEnvio) flujoentrada.readObject();
				
				if(!paqueteRecibido.getMensaje().equals(" online")) {
					campoChat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
				}else {
					campoChat.append("\n" +paqueteRecibido.getIps());
					ArrayList <String> IpsMenu = new ArrayList<String>();
					IpsMenu = paqueteRecibido.getIps();
					ip.removeAllItems();
					
					for(String z:IpsMenu) {
						ip.addItem(z);
					}
				}
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
class PaqueteEnvio implements Serializable{
	
	private String nick, ip, mensaje;
	
	private ArrayList<String> Ips;

	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}

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

