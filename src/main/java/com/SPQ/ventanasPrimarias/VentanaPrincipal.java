package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

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
		panelSelecVentana.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel ventPerfil = new JPanel();
		panelSelecVentana.add(ventPerfil);
		
		JPanel ventServicios = new JPanel();
		panelSelecVentana.add(ventServicios);
		
		JPanel ventOferta = new JPanel();
		panelSelecVentana.add(ventOferta);
		
		JPanel ventChat = new JPanel();
		panelSelecVentana.add(ventChat);
		
		JPanel ventMisServicios = new JPanel();
		panelSelecVentana.add(ventMisServicios);
		
		JPanel logoImg = new JPanel();
		logoImg.setBounds(0, 0, 422, 89);
		frmHustle.getContentPane().add(logoImg);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(938, 31, 89, 23);
		frmHustle.getContentPane().add(btnCerrarSesion);
	}
}
