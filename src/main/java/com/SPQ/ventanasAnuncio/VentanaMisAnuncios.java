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
import javax.swing.JButton;
import java.awt.Color;

public class VentanaMisAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private JList<List<Anuncio>> list;
	private List<Anuncio> listaAnuncios;
	
	public VentanaMisAnuncios(Usuario usuario) {
		getContentPane().setLayout(null);
						
		list = new JList<List<Anuncio>>();
		list.setBounds(28, 35, 535, 524);
		getContentPane().add(list);
				
		DBManager conn = new DBManager();
		
		modelo = new DefaultListModel<List<Anuncio>>();

		try {
			listaAnuncios = conn.misAnuncios(usuario.getNombreUsuario());
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (Anuncio anuncios : listaAnuncios) {
			modelo.addElement(anuncios);
			list.setModel(modelo);
		}
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.RED);
		btnEditar.setBounds(70, 585, 144, 39);
		getContentPane().add(btnEditar);
		
		
		btnEditar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   
					Anuncio anuncio = ((Anuncio)list.getSelectedValue());
					if(anuncio instanceof Anuncio) {
					VentanaEditarAnuncio edit = new VentanaEditarAnuncio(usuario, anuncio);	
					edit.setVisible(true);
					dispose();
					}
													        			      		        
		    }
		});
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList<List<Anuncio>> lista = (JList<List<Anuncio>>)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	Anuncio anuncio = (Anuncio) list.getSelectedValue();
		        	if(anuncio instanceof Anuncio) {
					    new VentanaEditarAnuncio(usuario,anuncio);	
		        	}
		        	
		        }		    
		    }
		});
											
		this.setSize(600,697);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("MIS ANUNCIOS");
		this.setVisible(true);
		
	}
}

