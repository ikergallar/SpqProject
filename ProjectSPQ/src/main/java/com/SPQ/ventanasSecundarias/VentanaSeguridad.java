package com.SPQ.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasPrimarias.VentanaLogin;



public class VentanaSeguridad extends JFrame{
	int a = VentanaLogin.getUsuarioId();
		
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
		
	public VentanaSeguridad() {
		
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setBounds(100, 100, 454, 555);
			getContentPane().setBackground(Color.PINK);
			getContentPane().setLayout(null);
			
			JLabel lblCambiarContrasea = new JLabel("Cambiar contrase\u00F1a");
			lblCambiarContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblCambiarContrasea.setBounds(99, 22, 223, 20);
			getContentPane().add(lblCambiarContrasea);
			
			JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a actual");
			lblContraseaAntigua.setBounds(10, 75, 160, 20);
			getContentPane().add(lblContraseaAntigua);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(10, 107, 398, 26);
			getContentPane().add(passwordField);
			
			JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
			lblNuevaContrasea.setBounds(10, 158, 160, 20);
			getContentPane().add(lblNuevaContrasea);
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(10, 189, 398, 26);
			getContentPane().add(passwordField_1);
			
			JLabel label = new JLabel("Nueva contrase\u00F1a");
			label.setBounds(10, 243, 160, 20);
			getContentPane().add(label);
			
			passwordField_2 = new JPasswordField();
			passwordField_2.setBounds(10, 274, 398, 26);
			getContentPane().add(passwordField_2);
			
			JButton btnAtras = new JButton("Atras");
			btnAtras.setBounds(39, 366, 105, 29);
			getContentPane().add(btnAtras);
			
			JButton btnCambiar = new JButton("Cambiar");
			btnCambiar.setBounds(207, 366, 115, 32);
			getContentPane().add(btnCambiar);
			

			btnAtras.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaLogin va = new VentanaLogin();
					va.setVisible(true);
					setVisible(false);
					
				}
			});
			
			btnCambiar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { 
					DBManager dbm = new DBManager();
					try {
						dbm.connect();
					
						Usuario user = dbm.buscarUsuarioId(a);
						if (user.getContrasenya().equals(passwordField.getText()) && passwordField_1.getText().equals(passwordField_2.getText())) {
							user.setContrasenya(passwordField_1.getText());
							dbm.cambiarContrsenya(user);
							JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
							passwordField.setText("");
							passwordField_1.setText("");
							passwordField_2.setText("");
						}else {
							JOptionPane.showMessageDialog(null, "Los campos no coinciden o contraseña incorrecta", "Error", 0);
						}
						dbm.disconnect();
					} catch (DBException e1) {
						
						e1.printStackTrace();
					}
					
					
				}
			});
		}
	

}
