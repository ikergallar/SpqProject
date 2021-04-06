package com.SPQ.ventanasPrimarias;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class VentanaPerfil extends JFrame{
	
		
		private JPanel contentPane;
		private int contC1 = 0;
		private int contC2 = 0;
		private int contC3 = 0;
		private int contC4 = 0;

		
		private JTextField textField;
		private JTextField textNombre;
		private JTextField textApellidos;
		private JTextField textDireccion;
		private JTextField textPais;
		private JTextField textTelefono;
		private JTextField textMisDatos;
		
		public VentanaPerfil() {
			
			int contBarra = 0;
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 440, 522);
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("MI PERFIL");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(151, 11, 147, 40);
			getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setBounds(36, 82, 46, 14);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Apellidos");
			lblNewLabel_2.setBounds(36, 107, 89, 14);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n");
			lblNewLabel_3.setBounds(36, 132, 76, 14);
			getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Pa\u00EDs");
			lblNewLabel_4.setBounds(36, 157, 46, 14);
			getContentPane().add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Tel\u00E9fono");
			lblNewLabel_5.setBounds(36, 182, 76, 14);
			getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Mis datos");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_6.setBounds(26, 57, 126, 14);
			getContentPane().add(lblNewLabel_6);
			
			textField = new JTextField();
			textField.setBounds(172, 79, 201, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBounds(172, 104, 201, 20);
			getContentPane().add(textNombre);
			
			textApellidos = new JTextField();
			textApellidos.setColumns(10);
			textApellidos.setBounds(172, 129, 201, 20);
			getContentPane().add(textApellidos);
			
			textDireccion = new JTextField();
			textDireccion.setColumns(10);
			textDireccion.setBounds(172, 154, 201, 20);
			getContentPane().add(textDireccion);
			
			textPais = new JTextField();
			textPais.setColumns(10);
			textPais.setBounds(172, 179, 201, 20);
			getContentPane().add(textPais);
			

			JLabel lblNewLabel_7 = new JLabel("Detalles de la cuenta");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_7.setBounds(26, 220, 157, 14);
			getContentPane().add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("E-Mail");
			lblNewLabel_8.setBounds(36, 245, 76, 14);
			getContentPane().add(lblNewLabel_8);
			
			JLabel lblNewLabel_8_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_8_1.setBounds(26, 270, 76, 14);
			getContentPane().add(lblNewLabel_8_1);
			
			textTelefono = new JTextField();
			textTelefono.setColumns(10);
			textTelefono.setBounds(172, 242, 201, 20);
			getContentPane().add(textTelefono);
			
			textMisDatos = new JTextField();
			textMisDatos.setColumns(10);
			textMisDatos.setBounds(172, 267, 201, 20);
			getContentPane().add(textMisDatos);
			
			JLabel lblNewLabel_9 = new JLabel("Forma de pago");
			lblNewLabel_9.setBounds(28, 316, 138, 14);
			getContentPane().add(lblNewLabel_9);
			
			JButton btnTarjeta = new JButton("TARJETA");
			btnTarjeta.addMouseListener(new MouseAdapter() {

			});
			btnTarjeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnTarjeta.setBounds(284, 312, 89, 23);
			getContentPane().add(btnTarjeta);
			
			JButton btnTarjeta_1 = new JButton("Atr\u00E1s");
			btnTarjeta_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnTarjeta_1.addMouseListener(new MouseAdapter() {
				
			});
			btnTarjeta_1.setBounds(26, 394, 126, 23);
			getContentPane().add(btnTarjeta_1);
			
			JButton btnGuardarCambios = new JButton("Guardar cambios\r\n");
			btnGuardarCambios.addMouseListener(new MouseAdapter() {
			
			});
		
			
			

			
		}
	}

