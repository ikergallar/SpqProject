package com.SPQ.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;

public class VentanaRegistro extends JDialog {

<<<<<<< HEAD

	private JPanel contentPane;
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField texto_email;
	private JPasswordField texto_contrasena;
	private JTextField textNumero;
	private JTextField texto_usuario;
	private JTextField texto_direccion;
	private ButtonGroup sexo = new ButtonGroup();
	final VentanaPrincipal principal = new VentanaPrincipal();
	
	
	
	
=======
	private final JPanel contentPanel = new JPanel();
	private JTextField tfCorreo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
>>>>>>> branch 'main' of https://github.com/ikergallar/SpqProject.git

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
<<<<<<< HEAD
		
		
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
		
		JLabel labelDireccion = new JLabel("Numero de contacto");
		labelDireccion.setForeground(Color.WHITE);
		labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDireccion.setBounds(31, 265, 136, 17);
		contentPane.add(labelDireccion);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(161, 265, 169, 19);
		contentPane.add(textNumero);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(260, 97, 70, 17);
		contentPane.add(labelUsuario);
		
		texto_usuario = new JTextField();
		texto_usuario.setColumns(10);
		texto_usuario.setBounds(334, 97, 118, 19);
		contentPane.add(texto_usuario);
		
		JLabel labelSexo = new JLabel("Sexo");
		labelSexo.setForeground(Color.WHITE);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSexo.setBounds(260, 137, 70, 17);
		contentPane.add(labelSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(327, 136, 98, 21);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(427, 136, 82, 21);
		contentPane.add(rdbtnFemenino);
		
		sexo.add(rdbtnFemenino);
		sexo.add(rdbtnMasculino);
		
		
		JLabel labelD = new JLabel("Direcci\u00F3n de contacto");
		labelD.setForeground(Color.WHITE);
		labelD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelD.setBounds(31, 304, 136, 17);
		contentPane.add(labelD);
		
		texto_direccion = new JTextField();
		texto_direccion.setColumns(10);
		texto_direccion.setBounds(161, 304, 169, 19);
		contentPane.add(texto_direccion);
		
		
		JButton btnRegistrar = new JButton("Finalizar registro");
		btnRegistrar.setBounds(388, 303, 153, 33);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario;
				String contrasenya;
				String email;
				String nombre;
				String apellido;
				
				int i = 1;
				
				nombreUsuario = texto_usuario.getText();
				contrasenya = String.valueOf(texto_contrasena.getPassword());
				email = texto_email.getText();
				nombre = textoNombre.getText();
				apellido = textoApellido.getText();
				
				
				if (nombreUsuario.equals("") || contrasenya.equals("") || email.equals("") || nombre.equals("")||apellido.equals("")) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);
					
				}else {
					
					if (email.contains("@") && email.contains(".")) {
				
						Usuario usuario = new Usuario();
						usuario.setNombreUsuario(nombreUsuario);
						usuario.setPass(contrasenya);
						usuario.setMail(email);
						usuario.setNombre(nombre);
						usuario.setApellido(apellido);
						
						DBManager conexion = new DBManager();
						
						try {
							conexion.connect();
							
								conexion.registrarUsuario(usuario);
								JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1);					
							
								
								VentanaLogin ini = new VentanaLogin(); 
								setVisible(false);
								//ini.setVisible(true);
								conexion.disconnect();
								
							
						} catch (DBException e1) {
							e1.printStackTrace();
=======
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Registro");
		setBounds(100, 100, 725, 555);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBackground(Color.WHITE);
			lblCorreo.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblCorreo);
		}
		{
			tfCorreo = new JTextField();
			contentPanel.add(tfCorreo);
			tfCorreo.setColumns(30);
		}
		{
			JLabel lblSisAuto = new JLabel("Nombre de usuario:");
			lblSisAuto.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblSisAuto);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Contraseña:");
			lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Confirmar contraseña:");
			lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Apellido:");
			lblNewLabel_3.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel_3);
		}
		{
			textField_4 = new JTextField();
			contentPanel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if (rdbtnFacebook.isSelected() && tfCorreo.getText().length() >= 10) {
							JOptionPane.showMessageDialog(null, "Registro completado.", "", 1);
							lblError.setVisible(false);
							String correo = tfCorreo.getText();
							System.out.println(correo);
							System.out.println(rdbtnFacebook.getText());
							setVisible(false);
						} else {
							lblError.setVisible(true);
>>>>>>> branch 'main' of https://github.com/ikergallar/SpqProject.git
						}
				
					}else {
						JOptionPane.showMessageDialog(null, "Direccion de correo no validaa", "Error", 0);
						
					}
				}
			}
			
		});
		
		JLabel labelDisponerDeCuenta = new JLabel("\u00BFYa dispone de una cuenta?");
		labelDisponerDeCuenta.setForeground(Color.WHITE);
		labelDisponerDeCuenta.setBounds(270, 29, 161, 13);
		contentPane.add(labelDisponerDeCuenta);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		
		
		/*btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin inicio = new VentanaLogin();
				inicio.setVisible(true);
				setVisible(false);
			}
		});*/
		btnIniciarSesion.setBounds(441, 27, 117, 17);
		contentPane.add(btnIniciarSesion);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondo.setBounds(0, 0, 579, 372);
		ImageIcon ico4 = new ImageIcon("imagenes/fondos.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img4);
		contentPane.add(labelFondo);
		
		
		
	}
}