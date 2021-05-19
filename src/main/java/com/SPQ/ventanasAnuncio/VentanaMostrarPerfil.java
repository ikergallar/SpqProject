package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Usuario;
import javax.swing.DropMode;


public class VentanaMostrarPerfil extends JFrame {
	private JTextField tfUserName;
	private JTextField tfMail;
	private JTextField tfDescripcion;

	public VentanaMostrarPerfil(Usuario perfil) {
		getContentPane().setBackground(new Color(39, 45, 53));
		setTitle("Hustle - Perfil " + perfil.getNombreUsuario());
		setBounds(100, 100, 513, 496);
		getContentPane().setLayout(null);

		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCerrar.setBackground(new Color(255, 0, 0));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCerrar.setBounds(0, 380, 497, 77);
		getContentPane().add(btnCerrar);

		JPanel panelServicio = new JPanel();
		panelServicio.setBackground(new Color(39, 45, 53));
		panelServicio.setBounds(28, 104, 438, 278);
		getContentPane().add(panelServicio);
		panelServicio.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblUserName = new JLabel("Nombre de usuario:");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblUserName);

		tfUserName = new JTextField();
		tfUserName.setText(perfil.getNombreUsuario());
		tfUserName.setBackground(new Color(39, 45, 53));
		tfUserName.setForeground(Color.WHITE);
		tfUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUserName.setEditable(false);
		panelServicio.add(tfUserName);
		tfUserName.setColumns(10);

		JLabel lblMail = new JLabel("Email:");
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblMail);

		tfMail = new JTextField();
		tfMail.setText(perfil.getMail());
		tfMail.setBackground(new Color(39, 45, 53));
		tfMail.setForeground(Color.WHITE);
		tfMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfMail.setEditable(false);
		panelServicio.add(tfMail);
		tfMail.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblDescripcion);

		tfDescripcion = new JTextField(perfil.getDescripcion());
		tfDescripcion.setText(" FALTA POR CREAR ATRIBUTO EN USUARIO ");
		tfDescripcion.setBackground(new Color(39, 45, 53));
		tfDescripcion.setForeground(Color.WHITE);
		tfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescripcion.setEditable(false);
		panelServicio.add(tfDescripcion);
		tfDescripcion.setColumns(10);

		JLabel lblNombreUser = new JLabel(perfil.getNombre()+ " "+ perfil.getApellido());
		lblNombreUser.setForeground(Color.WHITE);
		lblNombreUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNombreUser.setBounds(28, 0, 438, 105);
		getContentPane().add(lblNombreUser);
	}

}
