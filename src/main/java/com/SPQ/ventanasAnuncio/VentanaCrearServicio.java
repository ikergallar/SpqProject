package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaCrearServicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField tfDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearServicio frame = new VentanaCrearServicio();
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
	public VentanaCrearServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 45, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(36, 82, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescripcion.setBounds(36, 208, 68, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(36, 145, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblCrearServicio = new JLabel("CREAR SERVICIO");
		lblCrearServicio.setForeground(Color.WHITE);
		lblCrearServicio.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCrearServicio.setBounds(178, 29, 214, 27);
		contentPane.add(lblCrearServicio);
		
		JCheckBox chckbxOferta = new JCheckBox("Oferta");
		chckbxOferta.setForeground(Color.WHITE);
		chckbxOferta.setBackground(new Color(39, 45, 53));
		chckbxOferta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOferta.setBounds(327, 170, 97, 27);
		contentPane.add(chckbxOferta);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(327, 107, 214, 27);
		contentPane.add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setBounds(328, 82, 68, 14);
		contentPane.add(lblCategoria);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfNombre.setBounds(36, 107, 214, 27);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(36, 170, 214, 27);
		contentPane.add(tfPrecio);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(36, 240, 214, 106);
		contentPane.add(tfDescripcion);
		
		JButton btnCrearAnuncio = new JButton("CREAR ANUNCIO");
		btnCrearAnuncio.setForeground(Color.WHITE);
		btnCrearAnuncio.setBackground(Color.RED);
		btnCrearAnuncio.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCrearAnuncio.setBounds(327, 273, 214, 73);
		contentPane.add(btnCrearAnuncio);
	}
}
