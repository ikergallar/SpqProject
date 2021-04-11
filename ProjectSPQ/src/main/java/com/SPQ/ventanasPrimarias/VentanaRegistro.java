package com.SPQ.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.dataBase.LogController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;

public class VentanaRegistro extends JDialog {


	private JPanel contentPane;
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField texto_email;
	private JPasswordField texto_contrasena;
	private JPasswordField texto_confPass;
	private JTextField textNumero;
	private JTextField texto_usuario;
	private JTextField texto_direccion;
	private ButtonGroup sexo = new ButtonGroup();
	final VentanaPrincipal principal = new VentanaPrincipal();
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		LogController.log ( Level.INFO, "Inicio Registro " + (new Date()),null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelIntroducirDatos = new JLabel("Introduzca los siguientes datos:");
		labelIntroducirDatos.setForeground(Color.WHITE);
		labelIntroducirDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelIntroducirDatos.setBounds(31, 54, 200, 33);
		contentPane.add(labelIntroducirDatos);
		
		JLabel labelRegistrarNuevoUsuario = new JLabel("REGISTRA NUEVO USUARIO");
		labelRegistrarNuevoUsuario.setForeground(Color.WHITE);
		labelRegistrarNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelRegistrarNuevoUsuario.setBounds(31, 23, 200, 21);
		contentPane.add(labelRegistrarNuevoUsuario);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNombre.setBounds(31, 97, 70, 17);
		contentPane.add(labelNombre);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(101, 97, 118, 19);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lableApellido = new JLabel("Apellido");
		lableApellido.setForeground(Color.WHITE);
		lableApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableApellido.setBounds(31, 137, 70, 17);
		contentPane.add(lableApellido);
		
		textoApellido = new JTextField();
		textoApellido.setColumns(10);
		textoApellido.setBounds(101, 137, 118, 19);
		contentPane.add(textoApellido);
		
		JLabel labelEmail = new JLabel("Correo electr\u00F3nico");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEmail.setBounds(31, 181, 112, 17);
		contentPane.add(labelEmail);
		
		texto_email = new JTextField();
		texto_email.setColumns(10);
		texto_email.setBounds(156, 181, 169, 19);
		contentPane.add(texto_email);
		
		JLabel labelContrasena = new JLabel("Contrase\u00F1a");
		labelContrasena.setForeground(Color.WHITE);
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelContrasena.setBounds(31, 223, 82, 17);
		contentPane.add(labelContrasena);
		
		texto_contrasena = new JPasswordField();
		texto_contrasena.setBounds(123, 223, 144, 19);
		contentPane.add(texto_contrasena);
		
		JLabel lblConfPass = new JLabel("Confirmar contraseña");
		lblConfPass.setBounds(41, 279, 46, 14);
		contentPane.add(lblConfPass);
		
		texto_confPass = new JPasswordField();
		texto_confPass.setBounds(123, 276, 144, 20);
		contentPane.add(texto_confPass);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(260, 97, 70, 17);
		contentPane.add(labelUsuario);
		
		texto_usuario = new JTextField();
		texto_usuario.setColumns(10);
		texto_usuario.setBounds(334, 97, 118, 19);
		contentPane.add(texto_usuario);
		
		
		
		JButton btnRegistrar = new JButton("Finalizar registro");
		btnRegistrar.setBounds(388, 303, 153, 33);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario;
				String contrasenya;
				String confPass;
				String email;
				String nombre;
				String apellido;
				int i = 1;
				
				DBManager conexion = new DBManager();
				
				nombreUsuario = texto_usuario.getText();
				contrasenya = String.valueOf(texto_contrasena.getPassword());
				confPass = String.valueOf(texto_confPass.getPassword());
				email = texto_email.getText();
				nombre = textoNombre.getText();
				apellido = textoApellido.getText();
				
				if (nombreUsuario.equals("") || contrasenya.equals("") || email.equals("") || nombre.equals("")||apellido.equals("")) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);
					LogController.log ( Level.WARNING, "Es necesario rellenar todos los campos " + (new Date()),null);
					
				}else {
					
					if(contrasenya.equals(confPass)) {
					
					    if (email.contains("@") && email.contains(".")) {
					    	
					    	try {
					    		conexion.connect();
								if(conexion.existeUsuario(nombreUsuario) == false) {
								
																				
									Usuario usuario = new Usuario();
									usuario.setNombreUsuario(nombreUsuario);
									usuario.setPass(contrasenya);
									usuario.setMail(email);
									usuario.setNombre(nombre);
									usuario.setApellido(apellido);
																	
									
									try {
										
											conexion.registrarUsuario(usuario);
											JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1);
											LogController.log ( Level.INFO, "Cuenta creada correctamente " + (new Date()),null);
											
											VentanaLogin ini = new VentanaLogin(); 
											setVisible(true);
											VentanaRegistro.this.dispose();
											
											conexion.disconnect();
											
										
									} catch (DBException e1) {
										e1.printStackTrace();
									}
									
									}else {
										JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", 0);
										LogController.log ( Level.WARNING, "El usuario ya existe " + (new Date()),null);
									}
							} catch (HeadlessException | SecurityException | DBException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
				
					     }else {
					    	 JOptionPane.showMessageDialog(null, "Direccion de correo no valida", "Error", 0);
							 LogController.log ( Level.WARNING, "Direccion de correo no valida " + (new Date()),null);
						    
					     }
					  }else {
						  JOptionPane.showMessageDialog(null, "Las contrasenyas no coinciden", "Error", 0);
						  LogController.log ( Level.WARNING, "Las contrasenyas no coinciden " + (new Date()),null);
							
					  }
				}
			}
			
		});
		
		JLabel labelDisponerDeCuenta = new JLabel("\u00BFYa dispone de una cuenta?");
		labelDisponerDeCuenta.setForeground(Color.WHITE);
		labelDisponerDeCuenta.setBounds(270, 29, 161, 13);
		contentPane.add(labelDisponerDeCuenta);
		
		
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin inicio = new VentanaLogin();
				//inicio.setVisible(true);
				setVisible(false);
			}
		});
		btnIniciarSesion.setBounds(441, 27, 117, 17);
		contentPane.add(btnIniciarSesion);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondo.setBounds(0, 0, 579, 372);
		ImageIcon ico4 = new ImageIcon("imagenes/fondos.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img4);
		contentPane.add(labelFondo);
		
		final JCheckBox checkVerPass = new JCheckBox("Visualizar contraseñas");
		checkVerPass.setBounds(70, 319, 180, 23);
		getContentPane().add(checkVerPass);
		checkVerPass.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkVerPass.isSelected()) {
					
					texto_contrasena.setEchoChar((char)0);
					texto_confPass.setEchoChar((char)0);
					
				}else {
					
					texto_contrasena.setEchoChar(('*'));
					texto_confPass.setEchoChar((char)0);
				}
				
			}
		});
		
		
		
	
		
	}
	}