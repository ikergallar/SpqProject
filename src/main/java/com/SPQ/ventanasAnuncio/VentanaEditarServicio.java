package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class VentanaEditarServicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfDescripcion;
	private List<Usuario> usuarios;
	
	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget servicioTarget = appTarget.path("servicios");
	final WebTarget updateServicioTarget = servicioTarget.path("update");
	
	public VentanaEditarServicio(Usuario usuario, Anuncio anuncio) {

		setResizable(false);
		setTitle("Hustle - Editar Servicio");
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
		
		JLabel lblEditarServicio = new JLabel("EDITAR SERVICIO");
		lblEditarServicio.setForeground(Color.WHITE);
		lblEditarServicio.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEditarServicio.setBounds(178, 29, 214, 27);
		contentPane.add(lblEditarServicio);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.addItem(Categoria.ALBAYIL);
		comboBoxCategoria.addItem(Categoria.FONTANERO);
		comboBoxCategoria.addItem(Categoria.INFORMATICO);
		comboBoxCategoria.addItem(Categoria.PERSIANERO);
		comboBoxCategoria.setSelectedItem(anuncio.getCategoria());
		comboBoxCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxCategoria.setBounds(327, 107, 214, 27);
		contentPane.add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setBounds(328, 82, 68, 14);
		contentPane.add(lblCategoria);
		
		tfNombre = new JTextField(anuncio.getNombre());
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfNombre.setBounds(36, 107, 214, 27);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField(anuncio.getDescripcion());
		tfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(36, 240, 214, 106);
		contentPane.add(tfDescripcion);
		
		JButton btnEditarAnuncio = new JButton("EDITAR ANUNCIO");
		
		btnEditarAnuncio.setForeground(Color.WHITE);
		btnEditarAnuncio.setBackground(Color.RED);
		btnEditarAnuncio.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarAnuncio.setBounds(327, 273, 214, 73);
		contentPane.add(btnEditarAnuncio);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(36, 170, 214, 27);
		spinner.setValue(anuncio.getPrecio());
		contentPane.add(spinner);
		
		JToggleButton tglbtnOferta = new JToggleButton("Oferta");
		tglbtnOferta.setBackground(Color.RED);
		tglbtnOferta.setForeground(Color.WHITE);
		tglbtnOferta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tglbtnOferta.setSelected(anuncio.isOferta());
		tglbtnOferta.setBounds(327, 169, 214, 27);
		contentPane.add(tglbtnOferta);
		
		btnEditarAnuncio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre;
				String descripcion;
				float  precio;
				Categoria categoria;
				boolean oferta;

				nombre = tfNombre.getText();
				descripcion = tfDescripcion.getText();
				precio = Float.valueOf(spinner.getValue().toString());
				categoria = (Categoria) comboBoxCategoria.getSelectedItem();		
				oferta = tglbtnOferta.isSelected();

				if (nombre.equals("") || descripcion.equals("") || precio < 0 || categoria.equals(null)) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);
					
				}else {
					    		    	
		    		anuncio.setNombre(nombre);
		    		anuncio.setDescripcion(descripcion);
		    		anuncio.setPrecio(precio);
		    		anuncio.setCategoria(categoria);
		    		anuncio.setOferta(oferta);
		    		anuncio.setIdUsuario(usuario.getIdUsuario());

		    		updateServicioTarget.request().put(Entity.entity(anuncio, MediaType.APPLICATION_JSON));
					JOptionPane.showMessageDialog(null, "Anuncio creado correctamente", "Correcto", 1);
                    dispose();																				
																																										  
				}
			}
			
		});					
	}

}
