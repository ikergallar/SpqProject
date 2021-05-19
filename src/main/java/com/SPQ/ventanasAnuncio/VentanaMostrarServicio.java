package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMostrarServicio extends JDialog {
	private JTextField tfCategoria;
	private JTextField tfPrecio;
	private JTextField tfDescripcion;

	public VentanaMostrarServicio(Anuncio anuncio, Usuario usuario) {
		getContentPane().setBackground(new Color(39, 45, 53));
		setTitle("Hustle - Servicio");
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
		panelServicio.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblCategoria);

		tfCategoria = new JTextField();
		tfCategoria.setText(anuncio.getCategoria().name());
		tfCategoria.setBackground(new Color(39, 45, 53));
		tfCategoria.setForeground(Color.WHITE);
		tfCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCategoria.setEditable(false);
		panelServicio.add(tfCategoria);
		tfCategoria.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblPrecio);

		tfPrecio = new JTextField();
		tfPrecio.setText(Float.toString(anuncio.getPrecio()));
		tfPrecio.setBackground(new Color(39, 45, 53));
		tfPrecio.setForeground(Color.WHITE);
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setEditable(false);
		panelServicio.add(tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblDescripcion);

		tfDescripcion = new JTextField();
		tfDescripcion.setText(anuncio.getDescripcion());
		tfDescripcion.setBackground(new Color(39, 45, 53));
		tfDescripcion.setForeground(Color.WHITE);
		tfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescripcion.setEditable(false);
		panelServicio.add(tfDescripcion);
		tfDescripcion.setColumns(10);

		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setForeground(Color.WHITE);
		lblOferta.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblOferta);

		JCheckBox chckbxOferta = new JCheckBox("");
		chckbxOferta.setEnabled(false);
		chckbxOferta.setBackground(new Color(39, 45, 53));
		panelServicio.add(chckbxOferta);
		
		JLabel lblPerfil = new JLabel("Ver Perfil:");
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelServicio.add(lblPerfil);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39,45,53));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		panelServicio.add(panel);
		
		JButton btnAbrirPerfil = new JButton("ABRIR");
		btnAbrirPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMostrarPerfil mostrar = new VentanaMostrarPerfil(usuario);
				mostrar.setVisible(true);
			}
		});
		btnAbrirPerfil.setBackground(Color.RED);
		btnAbrirPerfil.setForeground(Color.WHITE);
		btnAbrirPerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnAbrirPerfil);
		if (anuncio.isOferta()) {
			chckbxOferta.setSelected(true);
		}

		JLabel lblNewLabel = new JLabel(anuncio.getNombre());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(28, 0, 438, 105);
		getContentPane().add(lblNewLabel);
	}
}
