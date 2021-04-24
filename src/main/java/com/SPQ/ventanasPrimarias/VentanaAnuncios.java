package com.SPQ.ventanasPrimarias;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
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
	private DefaultListModel modeloPrecio;
	private DefaultListModel modeloOferta;
	private JScrollPane scrollPane;
	private JList list;
	private ButtonGroup buttonGroup;	
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
		list.setBounds(28, 123, 535, 524);
		getContentPane().add(list);
				
		DBManager conn = new DBManager();
		
		JRadioButton rdbtnCategoria = new JRadioButton("Categoría");
		rdbtnCategoria.setBounds(57, 40, 109, 23);
		getContentPane().add(rdbtnCategoria);
			
		JComboBox<Categoria> comboCategoria = new JComboBox<Categoria>();
		comboCategoria.setEnabled(false);
		comboCategoria.addItem(Categoria.INFORMATICO);
		comboCategoria.addItem(Categoria.ALBAÑIL);
        comboCategoria.addItem(Categoria.FONTANERO);      
        comboCategoria.addItem(Categoria.PERSIANERO);
		comboCategoria.setBounds(45, 70, 105, 22);
		getContentPane().add(comboCategoria);
		
		modelo = new DefaultListModel();
		modelo.addElement(conn.listarAnuncios());
		list.setModel(modelo);
		
		JLabel flitro = new JLabel("Filtrar por:");
		flitro.setBounds(62, 11, 104, 14);
		getContentPane().add(flitro);
		
		JRadioButton rdbtnPrecio = new JRadioButton("Precio:");
		rdbtnPrecio.setBounds(173, 40, 109, 23);
		getContentPane().add(rdbtnPrecio);
		
		JComboBox comboPrecio = new JComboBox();
		comboPrecio.setEnabled(false);
		comboPrecio.addItem("Mayor precio");
		comboPrecio.addItem("Menor precio");
		comboPrecio.setBounds(173, 70, 109, 22);
		getContentPane().add(comboPrecio);
		
		JRadioButton rdbtnOferta = new JRadioButton("Ofertas:");
		rdbtnOferta.setBounds(312, 40, 109, 23);
		getContentPane().add(rdbtnOferta);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCategoria);
		buttonGroup.add(rdbtnPrecio);
		buttonGroup.add(rdbtnOferta);
			
		rdbtnCategoria.addActionListener((ActionListener) new ActionListener() {
		public void actionPerformed(ActionEvent e){   

	        if (rdbtnCategoria.isSelected()){
	            comboCategoria.setEnabled(true);
	        }else{
	            comboCategoria.setEnabled(false);
	        }
	    }
		});
		
		comboCategoria.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   

				modeloCategoria = new DefaultListModel();
				modelo = modeloCategoria;
				try {
					modeloCategoria.addElement(conn.filtroCategoria((Categoria)comboCategoria.getSelectedItem()));
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list.setModel(modeloCategoria);
		    }
			});
		
		rdbtnPrecio.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   

		        if (rdbtnPrecio.isSelected()){
		            comboPrecio.setEnabled(true);
		        }else{
		        	comboPrecio.setEnabled(false);
		        }
		    }
			});
			
		comboPrecio.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(comboPrecio.getSelectedItem().toString().equals("Mayor precio")) {
					modeloPrecio = new DefaultListModel();
					modelo = modeloPrecio;
					try {
						modeloPrecio.addElement(conn.filtroPrecioMayor());
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					list.setModel(modeloPrecio);
					
				}else if(comboPrecio.getSelectedItem().toString().equals("Menor precio")) {
					modeloPrecio = new DefaultListModel();
					modelo = modeloPrecio;
					try {
						modeloPrecio.addElement(conn.filtroPrecioMenor());
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					list.setModel(modeloPrecio);

				}					
			}
		});
		
		rdbtnOferta.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   

		        if (rdbtnOferta.isSelected()){
		        	modeloOferta = new DefaultListModel();
					modelo = modeloOferta;
					try {
						modeloOferta.addElement(conn.filtroOfertas());
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					list.setModel(modeloOferta);
		            
		        }
		    }
			});
		
		this.setSize(600,697);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ANUNCIOS");
		this.setVisible(true);
		
	}
}
