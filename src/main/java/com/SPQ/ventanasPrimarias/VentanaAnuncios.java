package com.SPQ.ventanasPrimarias;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasLogin.VentanaLogin;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VentanaAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private DefaultListModel modeloCategoria;
	private JScrollPane scrollPane;
	private JList list;
	private JList listaCategoria;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnuncios window = new VentanaAnuncios();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public VentanaAnuncios() throws DBException {
		getContentPane().setLayout(null);
					
		
		list = new JList();
		list.setBounds(192, 155, 218, 365);
		getContentPane().add(list);
		
		listaCategoria = new JList();
		listaCategoria.setBounds(192, 155, 218, 365);
		getContentPane().add(listaCategoria);
		
		DBManager conn = new DBManager();
		
		JRadioButton rdbtnCategoria = new JRadioButton("Categoría");
		rdbtnCategoria.setBounds(57, 40, 109, 23);
		getContentPane().add(rdbtnCategoria);
		
		JComboBox<Categoria> comboCategoria = new JComboBox<Categoria>();
		comboCategoria.addItem(Categoria.INFORMATICO);
		comboCategoria.addItem(Categoria.ALBAÑIL);
        comboCategoria.addItem(Categoria.FONTANERO);      
        comboCategoria.addItem(Categoria.PERSIANERO);
		comboCategoria.setBounds(45, 70, 105, 22);
		getContentPane().add(comboCategoria);
		
		modelo = new DefaultListModel();
		modelo.addElement(conn.listarAnuncios());
		list.setModel(modelo);
		
		modeloCategoria = new DefaultListModel();
		modeloCategoria.addElement(conn.filtroCategoria((Categoria)comboCategoria.getSelectedItem()));
		listaCategoria.setModel(modeloCategoria);
		
		scrollPane = new JScrollPane(listaCategoria);
		scrollPane.setBounds(45, 106, 411, 521);
		getContentPane().add(scrollPane);
		
		JLabel flitro = new JLabel("Filtrar por:");
		flitro.setBounds(62, 11, 104, 14);
		getContentPane().add(flitro);
		
		
		
		
		this.setSize(600,697);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ANUNCIOS");
		this.setVisible(true);

		
	}
}
