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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		
		JPanel panelPerfil = new JPanel();
		panelPerfil.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelPerfil);
		
		JPanel panelServicios = new JPanel();
		panelServicios.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelServicios);
		
		JPanel panelOferta = new JPanel();
		panelOferta.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelOferta);
		
		JPanel panelChat = new JPanel();
		panelChat.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelChat);
		
		JPanel panelSelecVentana = new JPanel();
		panelSelecVentana.setBounds(0, 89, 231, 592);
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
}
