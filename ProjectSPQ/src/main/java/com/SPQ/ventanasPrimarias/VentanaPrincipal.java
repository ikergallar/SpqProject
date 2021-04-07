package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;

public class VentanaPrincipal {

	private JFrame frmPrincipal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	static String nomUsuario;

	public static void lanzar(String nomUser) {
		nomUsuario = nomUser;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		lanzar("Prueba");
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
		frmPrincipal = new JFrame();
		frmPrincipal.getContentPane().setBackground(Color.WHITE);
		frmPrincipal.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		btnNewButton.setBounds(775, 408, 127, 52);
		frmPrincipal.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Pagar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		btnNewButton_1.setBounds(629, 408, 127, 52);
		frmPrincipal.getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 66, 862, 317);
		frmPrincipal.getContentPane().add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Lista de vuelos:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 11, 202, 44);
		frmPrincipal.getContentPane().add(lblNewLabel);

		String bienvenida = "¡Bienvenido, " + nomUsuario + "!";
		JLabel lblBienvenida = new JLabel(bienvenida);
		lblBienvenida.setForeground(Color.BLACK);
		lblBienvenida.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		lblBienvenida.setBounds(40, 440, 268, 20);
		frmPrincipal.getContentPane().add(lblBienvenida);
		frmPrincipal.setBackground(Color.WHITE);
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("EasyBooking - Reserva");
		frmPrincipal.setBounds(100, 100, 947, 525);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
