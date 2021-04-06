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
			

		
			
			

			
		}
	}

