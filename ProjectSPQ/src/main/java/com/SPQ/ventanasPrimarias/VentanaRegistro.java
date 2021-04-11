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
import javax.swing.JComboBox;

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
	private JTextField textoRespuesta;
	
	
	
	

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
		setTitle("Hustle - Registro");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 45, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNombre.setBounds(31, 48, 70, 17);
		contentPane.add(labelNombre);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(31, 76, 175, 19);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lableApellido = new JLabel("Apellido");
		lableApellido.setForeground(Color.WHITE);
		lableApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableApellido.setBounds(280, 48, 70, 17);
		contentPane.add(lableApellido);
		
		textoApellido = new JTextField();
		textoApellido.setColumns(10);
		textoApellido.setBounds(280, 76, 175, 19);
		contentPane.add(textoApellido);
		
		JLabel labelEmail = new JLabel("Correo");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEmail.setBounds(31, 200, 112, 17);
		contentPane.add(labelEmail);
		
		texto_email = new JTextField();
		texto_email.setColumns(10);
		texto_email.setBounds(31, 232, 175, 19);
		contentPane.add(texto_email);
		
		JLabel labelContrasena = new JLabel("Contrase\u00F1a");
		labelContrasena.setForeground(Color.WHITE);
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelContrasena.setBounds(280, 126, 82, 17);
		contentPane.add(labelContrasena);
		
		texto_contrasena = new JPasswordField();
		texto_contrasena.setBounds(280, 154, 173, 19);
		contentPane.add(texto_contrasena);
		
		JLabel lblConfPass = new JLabel("Confirmar contraseña");
		lblConfPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfPass.setForeground(new Color(255, 255, 255));
		lblConfPass.setBounds(280, 201, 200, 14);
		contentPane.add(lblConfPass);
		
		texto_confPass = new JPasswordField();
		texto_confPass.setBounds(280, 232, 175, 20);
		contentPane.add(texto_confPass);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(31, 126, 70, 17);
		contentPane.add(labelUsuario);
		
		texto_usuario = new JTextField();
		texto_usuario.setColumns(10);
		texto_usuario.setBounds(31, 154, 175, 19);
		contentPane.add(texto_usuario);
		
		
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBackground(new Color(255, 0, 0));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegistrar.setBounds(0, 385, 536, 72);
		contentPane.add(btnRegistrar);
		
		ImageIcon ico4 = new ImageIcon("imagenes/fondos.jpg");
		
		JLabel labelPregunta = new JLabel("Pregunta recuperación");
		labelPregunta.setForeground(Color.WHITE);
		labelPregunta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPregunta.setBounds(31, 285, 150, 17);
		contentPane.add(labelPregunta);
		
		final JComboBox comboPreguntas = new JComboBox();
		comboPreguntas.addItem("-");
		comboPreguntas.addItem("¿Nombre de tu madre?");
		comboPreguntas.addItem("¿Nombre de tu padre?");
		comboPreguntas.addItem("¿Ciudad natal?");
		comboPreguntas.addItem("¿Fecha especial?");
		comboPreguntas.addItem("¿Mascota de la infancia?");
		comboPreguntas.setBounds(31, 313, 175, 22);
		contentPane.add(comboPreguntas);
		
		JLabel labelRespuesta = new JLabel("Respuesta");
		labelRespuesta.setForeground(Color.WHITE);
		labelRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelRespuesta.setBounds(280, 285, 150, 17);
		contentPane.add(labelRespuesta);
		
		textoRespuesta = new JTextField();
		textoRespuesta.setColumns(10);
		textoRespuesta.setBounds(280, 314, 175, 19);
		contentPane.add(textoRespuesta);
		
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
				
				if (nombreUsuario.equals("") || contrasenya.equals("") || email.equals("") || nombre.equals("")||apellido.equals("") ||textoRespuesta.equals("")) {
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
									usuario.setPalabraRecuperacion(textoRespuesta.getText());
									usuario.setPreguntaRecuperacion(comboPreguntas.getSelectedItem().toString());
																	
									
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
		
		
		
	
		
	}
	}