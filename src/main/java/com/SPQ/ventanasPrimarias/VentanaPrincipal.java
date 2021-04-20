package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
	}

}
