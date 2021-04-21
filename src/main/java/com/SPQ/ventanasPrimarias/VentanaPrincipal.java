package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VentanaPrincipal {

	private JFrame frmHustle;

	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHustle = new JFrame();
		frmHustle.getContentPane().setBackground(new Color(39, 45, 53));
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
		ventPerfil.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventPerfil);
		ventPerfil.setLayout(null);
		
		JLabel imgPerfil = new JLabel("");
		imgPerfil.setBounds(42, 43, 64, 64);
		imgPerfil.setIcon(new ImageIcon(getClass().getResource("/iconoPerfil.png")));
		ventPerfil.add(imgPerfil);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setBounds(136, 61, 65, 22);
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventPerfil.add(lblPerfil);
		
		JPanel ventServicios = new JPanel();
		ventServicios.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventServicios);
		
		JLabel imgServicios = new JLabel("");
		ventServicios.add(imgServicios);
		
		JLabel lblServicios = new JLabel("SERVICIOS");
		lblServicios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblServicios.setForeground(Color.WHITE);
		ventServicios.add(lblServicios);
		
		JPanel ventOferta = new JPanel();
		ventOferta.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventOferta);
		
		JLabel imgOferta = new JLabel("");
		ventOferta.add(imgOferta);
		
		JLabel lblOferta = new JLabel("OFERTA");
		lblOferta.setForeground(Color.WHITE);
		lblOferta.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventOferta.add(lblOferta);
		
		JPanel ventChat = new JPanel();
		ventChat.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventChat);
		
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
}
