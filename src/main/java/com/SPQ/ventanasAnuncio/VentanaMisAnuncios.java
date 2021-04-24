package com.SPQ.ventanasAnuncio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaMisAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private JScrollPane scrollPane;
	private JList list;
	private ButtonGroup buttonGroup;	
	
	public VentanaMisAnuncios(Usuario usuario) {
		getContentPane().setLayout(null);
						
		list = new JList();
		list.setBounds(28, 35, 535, 524);
		getContentPane().add(list);
				
		DBManager conn = new DBManager();
		
		modelo = new DefaultListModel();
		try {
			modelo.addElement(conn.misAnuncios(usuario.getNombreUsuario()));
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.setModel(modelo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.RED);
		btnEditar.setBounds(70, 585, 144, 39);
		getContentPane().add(btnEditar);
		
		
		btnEditar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   
				Anuncio anuncio;
				try {
					anuncio = conn.seleccionarAnuncio((Anuncio)list.getSelectedValue());
					VentanaEditarAnuncio edit = new VentanaEditarAnuncio(usuario, anuncio);	
					edit.setVisible(true);
					dispose();
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}										        			      		        
		    }
		});
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList lista = (JList)evt.getSource();
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

