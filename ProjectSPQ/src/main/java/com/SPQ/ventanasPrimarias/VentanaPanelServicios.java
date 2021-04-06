package com.SPQ.ventanasPrimarias;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPanelServicios extends JPanel{
	
	public VentanaPanelServicios(String textoNombre, String textoFoto, String textoDescripción, int ref, double textoPrecio, String textoCategoria, String textoContacto) {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblFoto = new JLabel(textoFoto);
		lblFoto.setBounds(30, 11, 170, 124);
		add(lblFoto);
		ImageIcon ico = new ImageIcon(textoFoto);
        ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(img);
        
        JLabel lblNombre = new JLabel(textoNombre);
		lblNombre.setBounds(30, 146, 133, 13);
		add(lblNombre);
		
		JLabel lblCategoria = new JLabel(textoCategoria);
		lblCategoria.setBounds(30, 170, 119, 13);
		add(lblCategoria);
		
		JLabel lblContacto = new JLabel(textoContacto);
		lblContacto.setBounds(30, 194, 119, 13);
		add(lblContacto);
		
		JLabel lblDescripción = new JLabel(textoDescripción);
		lblDescripción.setBounds(30, 210, 119, 13);
		add(lblDescripción);
		
		JLabel lblRef = new JLabel(Integer.toString(ref));
		lblRef.setBounds(30, 230, 45, 13);
		add(lblRef);
		
		JLabel lblPrecio = new JLabel(Double.toString(textoPrecio));
		lblPrecio.setBounds(30, 210, 45, 13);
		add(lblPrecio);
		

		
		
        
	}

}
