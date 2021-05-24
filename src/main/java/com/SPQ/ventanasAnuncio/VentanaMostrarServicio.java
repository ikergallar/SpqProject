package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.datanucleus.query.inmemory.method.LocalDateGetDayOfMonth;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.AnuncioGuardado;
import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;

public class VentanaMostrarServicio extends JDialog {
	private JTextField tfCategoria;
	private JTextField tfPrecio;
	private JTextField tfDescripcion;
	private JTextField txtValoracion;
	CardLayout cl = new CardLayout();

	private List<Anuncio> fav = new ArrayList<Anuncio>();

	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget servicioTarget = appTarget.path("servicios");
	final WebTarget servicioGuardadoTarget = appTarget.path("serviciosGuardados");
	final WebTarget contratarTarget = servicioGuardadoTarget.path("comprar");
	final WebTarget updateServicioTarget = servicioTarget.path("updateValoracion");
	final WebTarget eliminarServicioTarget = servicioTarget.path("eliminar");

	private JTextField textField;

	public VentanaMostrarServicio(Anuncio anuncio, Usuario usuario) {
		getContentPane().setBackground(new Color(39, 45, 53));
		setTitle("Hustle - Servicio");
		setBounds(100, 100, 513, 700);
		getContentPane().setLayout(null);
	
		JLabel lblNewLabel = new JLabel(anuncio.getNombre());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(28, 10, 371, 105);
		getContentPane().add(lblNewLabel);

		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valoracion;

				valoracion = txtValoracion.getText();

				if (valoracion.equals("5") || valoracion.equals("4") || valoracion.equals("3") || valoracion.equals("2")
						|| valoracion.equals("1") || valoracion.equals("")) {
					anuncio.setValoracion(5);
					updateServicioTarget.request().put(Entity.entity(anuncio, MediaType.APPLICATION_JSON));
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, valore el servicio de 1 a 5", "Error", 0);
					txtValoracion.setText("");
				}
			}
		});
		btnCerrar.setBackground(new Color(255, 0, 0));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCerrar.setBounds(237, 584, 260, 77);
		getContentPane().add(btnCerrar);

		JLabel lblImagenEstrella = new JLabel("");
		lblImagenEstrella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (usuario.getFavoritos() == null) {
					fav.add(anuncio);
					usuario.setFavoritos(fav);
				} else {
					fav = usuario.getFavoritos();
					fav.add(anuncio);
					usuario.setFavoritos(fav);
				}
			}
		});
		lblImagenEstrella.setBounds(409, 38, 55, 55);
		getContentPane().add(lblImagenEstrella);
		lblImagenEstrella.setIcon(new ImageIcon(getClass().getResource("/estrellaVacia.png")));

		JPanel panelServicios = new JPanel();
		panelServicios.setBounds(28, 104, 437, 429);
		getContentPane().add(panelServicios);
		panelServicios.setLayout(cl);

		JPanel panelComentarios = new JPanel();
		panelComentarios.setBackground(new Color(39,45,53));
		panelServicios.add(panelComentarios, "2");
		panelComentarios.setLayout(null);
		
		JLabel lblValoracion = new JLabel("Valorar (1-5)");
		lblValoracion.setBounds(39, 270, 100, 19);
		panelComentarios.add(lblValoracion);
		lblValoracion.setForeground(Color.WHITE);
		lblValoracion.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtValoracion = new JTextField();
		txtValoracion.setBounds(165, 262, 44, 38);
		panelComentarios.add(txtValoracion);
		txtValoracion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Comentario");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(39, 329, 100, 19);
		panelComentarios.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(165, 311, 243, 55);
		panelComentarios.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("COMENTAR");
		btnNewButton.setBounds(107, 377, 89, 23);
		panelComentarios.add(btnNewButton);

		JPanel panelInfo = new JPanel();
		panelServicios.add(panelInfo, "1");
		panelInfo.setBackground(new Color(39, 45, 53));
		panelInfo.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(lblCategoria);

		tfCategoria = new JTextField();
		tfCategoria.setText(anuncio.getCategoria().name());
		tfCategoria.setBackground(new Color(39, 45, 53));
		tfCategoria.setForeground(Color.WHITE);
		tfCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCategoria.setEditable(false);
		panelInfo.add(tfCategoria);
		tfCategoria.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(lblPrecio);

		tfPrecio = new JTextField();
		tfPrecio.setText(Float.toString(anuncio.getPrecio()));
		tfPrecio.setBackground(new Color(39, 45, 53));
		tfPrecio.setForeground(Color.WHITE);
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setEditable(false);
		panelInfo.add(tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(lblDescripcion);

		tfDescripcion = new JTextField();
		tfDescripcion.setText(anuncio.getDescripcion());
		tfDescripcion.setBackground(new Color(39, 45, 53));
		tfDescripcion.setForeground(Color.WHITE);
		tfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescripcion.setEditable(false);
		panelInfo.add(tfDescripcion);
		tfDescripcion.setColumns(10);

		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setForeground(Color.WHITE);
		lblOferta.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(lblOferta);

		JCheckBox chckbxOferta = new JCheckBox("");
		chckbxOferta.setEnabled(false);
		chckbxOferta.setBackground(new Color(39, 45, 53));
		panelInfo.add(chckbxOferta);

		JLabel lblPerfil = new JLabel("Ver Perfil:");
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(lblPerfil);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 45, 53));
		panelInfo.add(panel);

		JButton btnAbrirPerfil = new JButton("ABRIR");
		btnAbrirPerfil.setBounds(61, 21, 95, 32);
		btnAbrirPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMostrarPerfil mostrar = new VentanaMostrarPerfil(usuario);
				mostrar.setVisible(true);
			}
		});
		panel.setLayout(null);
		btnAbrirPerfil.setBackground(Color.RED);
		btnAbrirPerfil.setForeground(Color.WHITE);
		btnAbrirPerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnAbrirPerfil);

		JLabel lblNewLabel_1 = new JLabel("Comentarios");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(39, 45, 53));
		panelInfo.add(panel_1);

		JButton btnAccederComentarios = new JButton("ACCEDER");
		btnAccederComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelServicios, "2");
			}
		});
		btnAccederComentarios.setForeground(Color.WHITE);
		btnAccederComentarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAccederComentarios.setBackground(Color.RED);
		btnAccederComentarios.setBounds(61, 21, 95, 32);
		panel_1.add(btnAccederComentarios);
		
		JButton btnContratar = new JButton("CONTRATAR");
		btnContratar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnContratar.setBackground(Color.RED);
		btnContratar.setForeground(Color.WHITE);
		btnContratar.setBounds(0, 584, 237, 77);
		getContentPane().add(btnContratar);
		
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnuncioGuardado anuncioContratado = new AnuncioGuardado();
				anuncioContratado.setIdAnuncio(anuncio.getIdAnuncio());
  //              anuncioContratado.setFecha(java.time.LocalTime.now());
				servicioGuardadoTarget.request().post(Entity.entity(anuncioContratado, MediaType.APPLICATION_JSON));
				eliminarServicioTarget.request().put(Entity.entity(anuncio, MediaType.APPLICATION_JSON));
				JOptionPane.showMessageDialog(null, "Servicio contratado correctamente", "Correcto", 1);
				dispose();
			}
		});
		
		if (usuario.getFavoritos() != null) {
			for (Anuncio anuncioFav : fav) {
				if (anuncio.equals(anuncioFav)) {
					lblImagenEstrella.setIcon(new ImageIcon(getClass().getResource("/estrellaRoja.png")));
					break;
				}
			}
		}
		if (anuncio.isOferta()) {
			chckbxOferta.setSelected(true);
		}


	}
}
