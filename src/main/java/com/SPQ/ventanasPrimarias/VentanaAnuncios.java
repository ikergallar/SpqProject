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

public class VentanaAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private List<Anuncio> listaAnuncios;
	
	
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
	public VentanaAnuncios() {
		getContentPane().setLayout(null);
					
		
		JList list = new JList();
		list.setBounds(66, 530, 319, -479);
		getContentPane().add(list);
		
		DBManager conn = new DBManager();
		
		modelo = new DefaultListModel();

		try {
			listaAnuncios = conn.listarAnuncios();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
