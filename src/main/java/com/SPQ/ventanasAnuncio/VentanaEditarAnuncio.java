package com.SPQ.ventanasAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JCheckBox;


public class VentanaEditarAnuncio extends JFrame{
	
	private JPanel pNorte,pCentral;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textPrecio;
	private JComboBox<Categoria> comboCategoria;
	
		
	public VentanaEditarAnuncio(Usuario usuario, Anuncio anuncio) {						
		
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
        
        textNombre = new JTextField(anuncio.getNombre());
        textNombre.setBounds(63, 94, 86, 20);
        pCentral.add(textNombre);
        textNombre.setColumns(10);
        
        textDescripcion = new JTextField(anuncio.getDescripcion());
        textDescripcion.setBounds(63, 176, 86, 20);
        pCentral.add(textDescripcion);
        textDescripcion.setColumns(10);
        
        JLabel nombrelbl = new JLabel("Nombre");
        nombrelbl.setBounds(79, 53, 46, 14);
        pCentral.add(nombrelbl);
        
        JLabel descripcionlbl = new JLabel("descripcion");
        descripcionlbl.setBounds(79, 147, 46, 14);
        pCentral.add(descripcionlbl);
        
        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(425, 508, 89, 23);
        pCentral.add(btnCrear);
        
        JLabel preciolbl = new JLabel("precio");
        preciolbl.setBounds(79, 236, 46, 14);
        pCentral.add(preciolbl);
        
        textPrecio = new JTextField(Float.toString(anuncio.getPrecio()));
        textPrecio.setBounds(63, 285, 86, 20);
        pCentral.add(textPrecio);
        textPrecio.setColumns(10);
        
        JLabel categorialbl = new JLabel("categoria");
        categorialbl.setBounds(79, 340, 46, 14);
        pCentral.add(categorialbl);
        
        comboCategoria = new JComboBox();
        comboCategoria.addItem(Categoria.ALBAYIL);
        comboCategoria.addItem(Categoria.FONTANERO);
        comboCategoria.addItem(Categoria.INFORMATICO);
        comboCategoria.addItem(Categoria.PERSIANERO);
        comboCategoria.setSelectedItem(anuncio.getCategoria());
        comboCategoria.setBounds(63, 389, 103, 30);
        pCentral.add(comboCategoria);
        
        JCheckBox boxOferta = new JCheckBox("Oferta");
        boxOferta.setBounds(69, 508, 97, 23);
        boxOferta.setSelected(anuncio.isOferta());
        pCentral.add(boxOferta);
        
        JLabel lblOferta = new JLabel("En oferta:");
        lblOferta.setBounds(79, 488, 99, 14);
        pCentral.add(lblOferta);
        btnCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager con = new DBManager();
				
				String nombre;
				String descripcion;
				float  precio;
				Categoria categoria;
				String nombreUsuario;
				boolean oferta;
								
				nombre = textNombre.getText();
				descripcion = textDescripcion.getText();
				precio = Float.parseFloat(textPrecio.getText());
				categoria = (Categoria) comboCategoria.getSelectedItem();		
				nombreUsuario = usuario.getNombreUsuario();
				oferta = boxOferta.isSelected();
				
				if (nombre.equals("") || descripcion.equals("") || precio < 0 || categoria.equals(null)) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);
					
				}else {
					    					   				    				    							
				    try {
				    	anuncio.setNombre(nombre);
			    		anuncio.setDescripcion(descripcion);
			    		anuncio.setPrecio(precio);
			    		anuncio.setCategoria(categoria);
			    		anuncio.setNombreUsuario(nombreUsuario);
			    		anuncio.setOferta(oferta);			
						con.updateAnuncio(anuncio);
						
						JOptionPane.showMessageDialog(null, "Anuncio editado correctamente", "Correcto", 1);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
                        dispose();											
																											  
				}
			}
			
		});		
        
        getContentPane().add(scrollbar, BorderLayout.CENTER);
        scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);       

	}
}
