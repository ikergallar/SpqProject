package com.SPQ.ventanasPrimarias;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasLogin.VentanaLogin;
import javax.swing.JScrollPane;

public class VentanaAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private JScrollPane scrollPane;
	private JList list;
	
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
		list.setBounds(66, 530, 339, -479);
		getContentPane().add(list);
		
		DBManager conn = new DBManager();
		
		modelo = new DefaultListModel();
		modelo.addElement(conn.listarAnuncios());
		list.setModel(modelo);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(47, 50, 411, 521);
		getContentPane().add(scrollPane);
		
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ANUNCIOS");
		this.setVisible(true);

		
	}
}
