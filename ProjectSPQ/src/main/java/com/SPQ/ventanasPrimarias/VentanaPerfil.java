package com.SPQ.ventanasPrimarias;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;



public class VentanaPerfil extends JFrame{
		
		private JTextField textNombre;
		private JTextField textApellido;
		private JTextField textDireccion;
		private JTextField textPais;
		private JTextField textTel;
		private JTextField textUsuario;
		private JTextField textContrasenya;
		private String nombreUsuario;
		private Usuario datosUsuario;
		
		public VentanaPerfil() {
			
			int contBarra = 0;

		    File f = new File("usuario.txt");
		    	try {
					BufferedReader br = new BufferedReader(new FileReader(f));
					String linea;
					while((linea = br.readLine()) != null) {
						nombreUsuario = linea;
					}
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    DBManager con = new DBManager();
		    
		    try {
		    	con.connect();
				datosUsuario = con.seleccionarDatos(nombreUsuario);
				
				con.disconnect();
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 440, 522);
			getContentPane().setBackground(Color.LIGHT_GRAY);
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
			
			textNombre = new JTextField(datosUsuario.getNombre());
			textNombre.setBounds(172, 79, 201, 20);
			getContentPane().add(textNombre);
			textNombre.setColumns(10);
			
			textApellido = new JTextField(datosUsuario.getApellido());
			textApellido.setColumns(10);
			textApellido.setBounds(172, 104, 201, 20);
			getContentPane().add(textApellido);
			
			textDireccion = new JTextField();
			textDireccion.setColumns(10);
			textDireccion.setBounds(172, 129, 201, 20);
			getContentPane().add(textDireccion);
			
			textPais = new JTextField();
			textPais.setColumns(10);
			textPais.setBounds(172, 154, 201, 20);
			getContentPane().add(textPais);
			
			textTel = new JTextField();
			textTel.setColumns(10);
			textTel.setBounds(172, 179, 201, 20);
			getContentPane().add(textTel);
			

			JLabel lblNewLabel_7 = new JLabel("Detalles de la cuenta");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_7.setBounds(26, 220, 157, 14);
			getContentPane().add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Usuario");
			lblNewLabel_8.setBounds(36, 245, 76, 14);
			getContentPane().add(lblNewLabel_8);
			
			JLabel lblNewLabel_8_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_8_1.setBounds(36, 269, 76, 14);
			getContentPane().add(lblNewLabel_8_1);
			
			textUsuario = new JTextField(datosUsuario.getNombreUsuario());
			textUsuario.setColumns(10);
			textUsuario.setBounds(172, 242, 201, 20);
			getContentPane().add(textUsuario);
			
			textContrasenya = new JTextField(datosUsuario.getPass());
			textContrasenya.setColumns(10);
			textContrasenya.setBounds(172, 267, 201, 20);
			getContentPane().add(textContrasenya);
			
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
			
			JButton btnNewButton = new JButton("Guardar");
			btnNewButton.setBounds(284, 394, 89, 23);
			getContentPane().add(btnNewButton);
			
			JButton btnGuardarCambios = new JButton("Guardar cambios\r\n");
			btnGuardarCambios.addMouseListener(new MouseAdapter() {
			
			});
		
			
			

			
		}
	}

