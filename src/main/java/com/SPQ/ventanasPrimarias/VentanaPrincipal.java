package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasAnuncio.VentanaMisAnuncios;
import com.SPQ.ventanasLogin.VentanaContrasenya;
import com.SPQ.ventanasLogin.VentanaLogin;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaPrincipal {

	private JFrame frmHustle;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTel;
	private JTextField textUsuario;
	private JTextField textMail;
	JPanel panelPerfil;

	public VentanaPrincipal(Usuario usuario) {
		initialize(usuario);
	}


	private void initialize(Usuario usuario) {
		frmHustle = new JFrame();
		frmHustle.setResizable(false);
		frmHustle.getContentPane().setBackground(new Color(39, 45, 53));
		frmHustle.setTitle("Hustle - Inicio");
		frmHustle.setBounds(100, 100, 1120, 729);
		frmHustle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHustle.getContentPane().setLayout(null);
		
		JLayeredPane panelesDinamicos = new JLayeredPane();
		panelesDinamicos.setBounds(250, 89, 835, 592);
		frmHustle.getContentPane().add(panelesDinamicos);
		
		panelPerfil = genPanelPerfil(usuario);
		panelPerfil.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelPerfil);
		
		JPanel panelSelecVentana = new JPanel();
		panelSelecVentana.setBounds(0, 89, 250, 601);
		frmHustle.getContentPane().add(panelSelecVentana);
		panelSelecVentana.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel ventPerfil = new JPanel();
		ventPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ventPerfil.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventPerfil);
		ventPerfil.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgPerfil = new JLabel("");
		imgPerfil.setIcon(new ImageIcon(getClass().getResource("/iconoPerfil.png")));
		ventPerfil.add(imgPerfil);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventPerfil.add(lblPerfil);
		
		JPanel ventServicios = new JPanel();
		ventServicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ventServicios.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventServicios);
		ventServicios.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgServicios = new JLabel("");
		ventServicios.add(imgServicios);
		
		JLabel lblServicios = new JLabel("SERVICIOS");
		lblServicios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblServicios.setForeground(Color.WHITE);
		ventServicios.add(lblServicios);
		
		JPanel ventOferta = new JPanel();
		ventOferta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ventOferta.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventOferta);
		ventOferta.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgOferta = new JLabel("");
		ventOferta.add(imgOferta);
		
		JLabel lblOferta = new JLabel("OFERTAS");
		lblOferta.setForeground(Color.WHITE);
		lblOferta.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventOferta.add(lblOferta);
		
		JPanel ventChat = new JPanel();
		ventChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ventChat.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventChat);
		ventChat.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgChat = new JLabel("");
		ventChat.add(imgChat);
		
		JLabel lblChat = new JLabel("CHAT");
		lblChat.setForeground(Color.WHITE);
		lblChat.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventChat.add(lblChat);
		
		JPanel logoImg = new JPanel();
		logoImg.setBackground(new Color(39, 45, 53));
		logoImg.setBounds(0, 0, 422, 89);
		frmHustle.getContentPane().add(logoImg);
		logoImg.setLayout(null);
		
		JLabel imgLogoHorizontal = new JLabel("");
		imgLogoHorizontal.setBounds(10, 11, 402, 67);
		logoImg.add(imgLogoHorizontal);
	}
	

	
	public JPanel genPanelPerfil(Usuario usuario){
		JPanel panelPerfilGen=new JPanel();
		panelPerfilGen.setBackground(new Color(39, 45, 53));
		panelPerfilGen.setLayout(null);

		int contBarra = 0;
	    	
	    DBManager con = new DBManager();
	    		 		  		    

	    panelPerfilGen.setBounds(100, 100, 835, 592);
	    panelPerfilGen.setBackground(new Color(39, 45, 53));
	    panelPerfilGen.setLayout(null);
		
		JLabel lblTituloPerfil = new JLabel("MI PERFIL");
		lblTituloPerfil.setForeground(new Color(255, 255, 255));
		lblTituloPerfil.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTituloPerfil.setBounds(334, 11, 126, 40);
		panelPerfilGen.add(lblTituloPerfil);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(46, 102, 46, 14);
		panelPerfilGen.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(46, 127, 89, 14);
		panelPerfilGen.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(46, 152, 76, 14);
		panelPerfilGen.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(46, 177, 76, 14);
		panelPerfilGen.add(lblTelefono);
		
		JLabel lblDatos = new JLabel("Mis datos");
		lblDatos.setForeground(new Color(255, 255, 255));
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatos.setBounds(36, 64, 126, 14);
		panelPerfilGen.add(lblDatos);
		
		textNombre = new JTextField(usuario.getNombre());
		textNombre.setBounds(172, 100, 201, 20);
		panelPerfilGen.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField(usuario.getApellido());
		textApellido.setColumns(10);
		textApellido.setBounds(172, 125, 201, 20);
		panelPerfilGen.add(textApellido);
		
		textDireccion = new JTextField(usuario.getDireccion());
		textDireccion.setColumns(10);
		textDireccion.setBounds(172, 150, 201, 20);
		panelPerfilGen.add(textDireccion);
		
		textTel = new JTextField(usuario.getTelefono());
		textTel.setColumns(10);
		textTel.setBounds(172, 175, 201, 20);
		panelPerfilGen.add(textTel);
		

		JLabel lblDetalles = new JLabel("Detalles de la cuenta");
		lblDetalles.setForeground(Color.WHITE);
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalles.setBounds(36, 213, 157, 14);
		panelPerfilGen.add(lblDetalles);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(46, 251, 76, 14);
		panelPerfilGen.add(lblUsuario);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMail.setForeground(Color.WHITE);
		lblMail.setBounds(46, 276, 76, 14);
		panelPerfilGen.add(lblMail);
		
		textUsuario = new JTextField(usuario.getNombreUsuario());
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(172, 249, 201, 20);
		panelPerfilGen.add(textUsuario);
		
		textMail = new JTextField(usuario.getMail());
		textMail.setColumns(10);
		textMail.setBounds(172, 274, 201, 20);
		panelPerfilGen.add(textMail);
		
			
		
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
			panelPerfilGen.add(btnNewButton);
			
			JButton botonCerrarSesion = new JButton("Cerrar Sesion");
			botonCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
			botonCerrarSesion.setForeground(Color.WHITE);
			botonCerrarSesion.setBackground(Color.RED);
			botonCerrarSesion.setBounds(664, 15, 134, 40);
			panelPerfilGen.add(botonCerrarSesion);
			
			final JLabel cambiarPass = new JLabel("¿Deseas cambiar tu contraseña? Pincha aquí.");
			cambiarPass.setForeground(Color.GRAY);
			cambiarPass.setBounds(36, 305, 273, 14);
			panelPerfilGen.add(cambiarPass);
			
			JButton btnServicios = new JButton("MIS SERVICIOS");
			btnServicios.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnServicios.setForeground(Color.WHITE);
			btnServicios.setBackground(Color.RED);
			btnServicios.setBounds(461, 494, 337, 68);
			panelPerfilGen.add(btnServicios);
			
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
			return panelPerfilGen;
	}
}
