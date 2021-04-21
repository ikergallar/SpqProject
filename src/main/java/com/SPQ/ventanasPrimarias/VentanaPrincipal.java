package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaPrincipal {

	private JFrame frmHustle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmHustle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHustle = new JFrame();
		frmHustle.setTitle("Hustle - Inicio");
		frmHustle.setBounds(100, 100, 1080, 720);
		frmHustle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHustle.getContentPane().setLayout(null);
		
		JLayeredPane panelesDinamicos = new JLayeredPane();
		panelesDinamicos.setBounds(229, 89, 835, 592);
		frmHustle.getContentPane().add(panelesDinamicos);
		
		JPanel panelSelecVentana = new JPanel();
		panelSelecVentana.setBounds(0, 89, 231, 592);
		frmHustle.getContentPane().add(panelSelecVentana);
		panelSelecVentana.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel ventPerfil = new JPanel();
		panelSelecVentana.add(ventPerfil);
		
		JLabel imgPerfil = new JLabel("");
		ventPerfil.add(imgPerfil);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		ventPerfil.add(lblPerfil);
		
		JPanel ventServicios = new JPanel();
		panelSelecVentana.add(ventServicios);
		
		JLabel imgServicios = new JLabel("");
		ventServicios.add(imgServicios);
		
		JLabel lblServicios = new JLabel("SERVICIOS");
		ventServicios.add(lblServicios);
		
		JPanel ventOferta = new JPanel();
		panelSelecVentana.add(ventOferta);
		
		JLabel imgOferta = new JLabel("");
		ventOferta.add(imgOferta);
		
		JLabel lblOferta = new JLabel("OFERTA");
		ventOferta.add(lblOferta);
		
		JPanel ventChat = new JPanel();
		panelSelecVentana.add(ventChat);
		
		JLabel imgChat = new JLabel("");
		ventChat.add(imgChat);
		
		JLabel lblChat = new JLabel("CHAT");
		ventChat.add(lblChat);
		
		JPanel logoImg = new JPanel();
		logoImg.setBounds(0, 0, 422, 89);
		frmHustle.getContentPane().add(logoImg);
		logoImg.setLayout(null);
		
		JLabel imgLogoHorizontal = new JLabel("New label");
		imgLogoHorizontal.setBounds(10, 11, 402, 67);
		logoImg.add(imgLogoHorizontal);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(938, 31, 89, 23);
		frmHustle.getContentPane().add(btnCerrarSesion);
	}
}
