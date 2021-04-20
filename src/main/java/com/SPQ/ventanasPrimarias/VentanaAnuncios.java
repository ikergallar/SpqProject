package com.SPQ.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class VentanaAnuncios extends JFrame{
	
	private JPanel pNorte,pCentral;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textPrecio;
	private JComboBox<Categoria> comboCategoria;
	
		
	public VentanaAnuncios(Usuario usuario) {				
		
		DBManager con = new DBManager();
		
		pNorte = new JPanel();
		pNorte.setBackground(Color.WHITE);
		pCentral = new JPanel();
		getContentPane().add(pNorte,BorderLayout.NORTH);
		getContentPane().add(pCentral,BorderLayout.CENTER);
		
		setTitle("Servicios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(300, 200, 900, 900);
		
		JLabel derecha = new JLabel("");
		derecha.setBackground(Color.WHITE);		
        
        pNorte.add(derecha);
        
        JScrollPane scrollbar = new JScrollPane(pCentral);
        pCentral.setLayout(null);
        
        textNombre = new JTextField();
        textNombre.setBounds(63, 94, 86, 20);
        pCentral.add(textNombre);
        textNombre.setColumns(10);
        
        textDescripcion = new JTextField();
        textDescripcion.setBounds(63, 176, 86, 20);
        pCentral.add(textDescripcion);
        textDescripcion.setColumns(10);
        
        textPrecio = new JTextField();
        textPrecio.setBounds(63, 293, 86, 20);
        pCentral.add(textPrecio);
        textPrecio.setColumns(10);
        
        JLabel nombrelbl = new JLabel("Nombre");
        nombrelbl.setBounds(79, 53, 46, 14);
        pCentral.add(nombrelbl);
        
        JLabel descripcionlbl = new JLabel("descripcion");
        descripcionlbl.setBounds(79, 147, 46, 14);
        pCentral.add(descripcionlbl);
        
        JLabel preciolbl = new JLabel("precio");
        preciolbl.setBounds(79, 257, 46, 14);
        pCentral.add(preciolbl);
        
        JLabel categorialbl = new JLabel("categoria");
        categorialbl.setBounds(103, 368, 46, 14);
        pCentral.add(categorialbl);
        
        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(425, 508, 89, 23);
        pCentral.add(btnCrear);
        
        comboCategoria = new JComboBox();
        comboCategoria.addItem(Categoria.ALBAÑIL);
        comboCategoria.addItem(Categoria.FONTANERO);
        comboCategoria.addItem(Categoria.INFORMATICO);
        comboCategoria.addItem(Categoria.PERSIANERO);
        comboCategoria.setBounds(79, 420, 103, 30);
        pCentral.add(comboCategoria);
        btnCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre;
				String descripcion;
				float  precio;
				Categoria categoria;
								
				nombre = textNombre.getText();
				descripcion = textDescripcion.getText();
				precio = Float.parseFloat(textPrecio.getText());
				categoria = (Categoria) comboCategoria.getSelectedItem();				
				
				if (nombre.equals("") || descripcion.equals("") || precio < 0 || categoria.equals(null)) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);
					
				}else {
					    	
				    try {
				    		Anuncio anuncio = new Anuncio();
				    		anuncio.setNombre(nombre);
				    		anuncio.setDescripcion(descripcion);
				    		anuncio.setPrecio(precio);
				    		anuncio.setCategoria(categoria);
				    		anuncio.setUsuario(usuario);
																			
								try {
									
										con.crearAnuncio(anuncio);
										JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1);
                                        dispose();											
										
									
								} catch (DBException e1) {
									e1.printStackTrace();
								}
								
								
						} catch (HeadlessException | SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}														  
				}
			}
			
		});		
        
        getContentPane().add(scrollbar, BorderLayout.CENTER);
        scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);       

	}
}
