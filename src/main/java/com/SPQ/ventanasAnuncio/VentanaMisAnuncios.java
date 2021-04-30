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
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaMisAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private JList<List<Anuncio>> list;
	private List<Anuncio> listaAnuncios;
	
	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget servicioTarget = appTarget.path("servicios");
	
	public VentanaMisAnuncios(Usuario usuario) {
		getContentPane().setBackground(new Color(39, 45, 53));
		getContentPane().setLayout(null);
						
		list = new JList<List<Anuncio>>();
		list.setBounds(28, 83, 535, 476);
		getContentPane().add(list);
				
		
		modelo = new DefaultListModel<List<Anuncio>>();
		
		WebTarget listarServicioTarget = servicioTarget.path("misServicios").queryParam("idUsuario", usuario.getIdUsuario());
		GenericType<List<Anuncio>> genericType = new GenericType<List<Anuncio>>() {};
		listaAnuncios = listarServicioTarget.request(MediaType.APPLICATION_JSON).get(genericType);;
		
		for (Anuncio anuncios : listaAnuncios) {
			modelo.addElement(anuncios);
			list.setModel(modelo);
		}
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(0, 592, 592, 83);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		
		JButton btnEditar = new JButton("EDITAR");
		panelBotones.add(btnEditar);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.RED);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		panelBotones.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.RED);
		
		JButton btnNuevoAnuncio = new JButton("NUEVO ANUNCIO");
		panelBotones.add(btnNuevoAnuncio);
		btnNuevoAnuncio.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNuevoAnuncio.setForeground(Color.WHITE);
		btnNuevoAnuncio.setBackground(Color.RED);
		
		JLabel lblNewLabel = new JLabel("MIS SERVICIOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(208, 21, 201, 38);
		getContentPane().add(lblNewLabel);
		btnNuevoAnuncio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		btnEliminar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   
				
				Anuncio anuncio = (Anuncio) list.getSelectedValue();
				modelo.removeElement(anuncio);
//				try {
//					conn.eliminarAnuncio(anuncio);
//				} catch (DBException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
													        			      		        
		
		});
		
		
		btnEditar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   
					Anuncio anuncio = ((Anuncio)list.getSelectedValue());
					VentanaEditarServicio edit = new VentanaEditarServicio(usuario, anuncio);	
					edit.setVisible(true);
					dispose();
													        			      		        
		    }
		});
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList<List<Anuncio>> lista = (JList<List<Anuncio>>)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	Anuncio anuncio = (Anuncio) list.getSelectedValue();
		        	if(anuncio instanceof Anuncio) {
		        		VentanaEditarServicio edit = new VentanaEditarServicio(usuario, anuncio);	
						edit.setVisible(true);
						dispose();	
		        	}
		        	
		        }		    
		    }
		});
											
		this.setSize(608,714);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Hustle - Mis Servicios");
		this.setVisible(true);
		
	}
}

