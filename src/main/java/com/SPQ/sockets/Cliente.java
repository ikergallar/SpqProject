package com.SPQ.sockets;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
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
		
		setBounds (600, 300, 280, 350);
	
		LaminaMarcoCliente milamina = new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaMarcoCliente extends JPanel {
	
	private JTextField campo1;
	private JButton miboton;
	
	public LaminaMarcoCliente() {
		
		
		
		
		JLabel texto = new JLabel("Cliente");
		
		add(texto);
		
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
				
				DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				
				flujo_salida.writeUTF(campo1.getText());
				
				flujo_salida.close();
				
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

