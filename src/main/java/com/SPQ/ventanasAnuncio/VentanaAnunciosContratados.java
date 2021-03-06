package com.SPQ.ventanasAnuncio;

import java.awt.EventQueue;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.AnuncioGuardado;
import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaAnunciosContratados extends JFrame {

	private DefaultListModel modelo;
	private JList<List<AnuncioGuardado>> list;
	private List<AnuncioGuardado> listaAnuncios;

	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget servicioTarget = appTarget.path("serviciosGuardados");

	public VentanaAnunciosContratados(Usuario usuario) {
		getContentPane().setBackground(new Color(39, 45, 53));
		getContentPane().setLayout(null);

		list = new JList<List<AnuncioGuardado>>();
		list.setBounds(28, 83, 535, 476);
		getContentPane().add(list);

		modelo = new DefaultListModel();

		WebTarget misServiciosTarget = servicioTarget.path("guardados").queryParam("idusuario",
				usuario.getIdUsuario());
		GenericType<List<AnuncioGuardado>> genericType = new GenericType<List<AnuncioGuardado>>() {
		};
		listaAnuncios = misServiciosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		;
		for (AnuncioGuardado anuncios : listaAnuncios) {
			modelo.addElement(anuncios);
			list.setModel(modelo);
		}

		JButton btnAbrir = new JButton("ABRIR");
		btnAbrir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAbrir.setForeground(Color.WHITE);
		btnAbrir.setBackground(Color.RED);
		btnAbrir.setBounds(28, 570, 263, 94);
		getContentPane().add(btnAbrir);
		

		JButton btnAtras = new JButton("CERRAR");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBackground(Color.RED);
		btnAtras.setBounds(300, 570, 263, 94);
		getContentPane().add(btnAtras);

		JLabel lblNewLabel = new JLabel("SERVICIOS CONTRATADOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(151, 21, 322, 38);
		getContentPane().add(lblNewLabel);		

		btnAbrir.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnuncioGuardado anuncio = ((AnuncioGuardado) list.getSelectedValue());
				VentanaMostrarServicioContratado contr = new VentanaMostrarServicioContratado(anuncio, usuario);
				contr.setVisible(true);
				dispose();

			}
		});	
		
		btnAtras.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});	

		this.setSize(608, 714);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Hustle - Servicios contratados");
		this.setVisible(true);

	}
}
