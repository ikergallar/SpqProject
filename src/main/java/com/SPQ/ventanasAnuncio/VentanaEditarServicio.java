package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Usuario;

public class VentanaEditarServicio extends JFrame {

	private JPanel contentPane;

	
	public VentanaEditarServicio(Usuario usuario, Anuncio anuncio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
