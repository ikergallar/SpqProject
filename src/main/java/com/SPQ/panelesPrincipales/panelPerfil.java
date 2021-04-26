package com.SPQ.panelesPrincipales;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasAnuncio.VentanaMisAnuncios;
import com.SPQ.ventanasLogin.VentanaContrasenya;
import com.SPQ.ventanasLogin.VentanaLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelPerfil extends JPanel {

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTel;
	private JTextField textUsuario;
	private JTextField textMail;
	private Usuario usuario;
	
	public panelPerfil(Usuario usuario) {
		setBackground(new Color(39, 45, 53));
		setLayout(null);

		int contBarra = 0;
	    	
	    DBManager con = new DBManager();
	    		 		  		    

		setBounds(100, 100, 835, 592);
		setBackground(new Color(39, 45, 53));
		setLayout(null);
		
		JLabel lblTituloPerfil = new JLabel("MI PERFIL");
		lblTituloPerfil.setForeground(new Color(255, 255, 255));
		lblTituloPerfil.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTituloPerfil.setBounds(334, 11, 126, 40);
		add(lblTituloPerfil);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(46, 102, 46, 14);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(46, 127, 89, 14);
		add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(46, 152, 76, 14);
		add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(46, 177, 76, 14);
		add(lblTelefono);
		
		JLabel lblDatos = new JLabel("Mis datos");
		lblDatos.setForeground(new Color(255, 255, 255));
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatos.setBounds(36, 64, 126, 14);
		add(lblDatos);
		
		textNombre = new JTextField(usuario.getNombre());
		textNombre.setBounds(172, 100, 201, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField(usuario.getApellido());
		textApellido.setColumns(10);
		textApellido.setBounds(172, 125, 201, 20);
		add(textApellido);
		
		textDireccion = new JTextField(usuario.getDireccion());
		textDireccion.setColumns(10);
		textDireccion.setBounds(172, 150, 201, 20);
		add(textDireccion);
		
		textTel = new JTextField(usuario.getTelefono());
		textTel.setColumns(10);
		textTel.setBounds(172, 175, 201, 20);
		add(textTel);
		

		JLabel lblDetalles = new JLabel("Detalles de la cuenta");
		lblDetalles.setForeground(Color.WHITE);
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalles.setBounds(36, 213, 157, 14);
		add(lblDetalles);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(46, 251, 76, 14);
		add(lblUsuario);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMail.setForeground(Color.WHITE);
		lblMail.setBounds(46, 276, 76, 14);
		add(lblMail);
		
		textUsuario = new JTextField(usuario.getNombreUsuario());
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(172, 249, 201, 20);
		add(textUsuario);
		
		textMail = new JTextField(usuario.getMail());
		textMail.setColumns(10);
		textMail.setBounds(172, 274, 201, 20);
		add(textMail);
		
			
		
			JButton btnNewButton = new JButton("GUARDAR");
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DBManager con = new DBManager();
					
					try {
						usuario.setNombre(textNombre.getText());
						usuario.setApellido(textApellido.getText());
						usuario.setDireccion(textDireccion.getText());
						usuario.setTelefono(textTel.getText());
						usuario.setNombreUsuario(textUsuario.getText());
						con.updateUsuario(usuario);
						
						JOptionPane.showMessageDialog(null, "Datos editados correctamente", "Informacion", 1);
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
			});
			
			btnNewButton.setBounds(36, 494, 337, 68);
			add(btnNewButton);
			
			JButton botonCerrarSesion = new JButton("Cerrar Sesion");
			botonCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
			botonCerrarSesion.setForeground(Color.WHITE);
			botonCerrarSesion.setBackground(Color.RED);
			botonCerrarSesion.setBounds(664, 15, 134, 40);
			add(botonCerrarSesion);
			
			final JLabel cambiarPass = new JLabel("¿Deseas cambiar tu contraseña? Pincha aquí.");
			cambiarPass.setForeground(Color.GRAY);
			cambiarPass.setBounds(36, 305, 273, 14);
			add(cambiarPass);
			
			JButton btnServicios = new JButton("MIS SERVICIOS");
			btnServicios.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnServicios.setForeground(Color.WHITE);
			btnServicios.setBackground(Color.RED);
			btnServicios.setBounds(461, 494, 337, 68);
			add(btnServicios);
			
			btnServicios.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					VentanaMisAnuncios misAnuncios = new VentanaMisAnuncios(usuario);
					misAnuncios.setVisible(true);
					
				}
				
			});
			
			cambiarPass.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					VentanaContrasenya sec = new VentanaContrasenya(usuario);
					sec.setVisible(true);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					cambiarPass.setForeground(Color.WHITE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cambiarPass.setForeground(Color.GRAY);
				}
			});
						
			botonCerrarSesion.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					VentanaLogin login = new VentanaLogin();
					login.setVisible(true);				
				}
				
			});
	}

}