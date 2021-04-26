package com.SPQ.ventanasAnuncio;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasLogin.VentanaLogin;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private DefaultListModel modeloCategoria;
	private DefaultListModel modeloPrecio;
	private DefaultListModel modeloOferta;
	private DefaultListModel modeloUsuario;
	private JScrollPane scrollPane;
	private JList list;
	private ButtonGroup buttonGroup;	
	private JTextField textUsername;
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
	public VentanaAnuncios(){
		getContentPane().setEnabled(false);
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
		comboCategoria.addItem(Categoria.ALBAYIL);
        comboCategoria.addItem(Categoria.FONTANERO);      
        comboCategoria.addItem(Categoria.PERSIANERO);
		comboCategoria.setBounds(45, 70, 105, 22);
		getContentPane().add(comboCategoria);
		
		modelo = new DefaultListModel();
		try {
			modelo.addElement(conn.listarAnuncios());
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
		rdbtnOferta.setBounds(306, 40, 109, 23);
		getContentPane().add(rdbtnOferta);
		
		JRadioButton rdbtnUsuario = new JRadioButton("Nombre de usuario:");
		rdbtnUsuario.setBounds(413, 40, 165, 23);
		getContentPane().add(rdbtnUsuario);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCategoria);
		buttonGroup.add(rdbtnPrecio);
		buttonGroup.add(rdbtnOferta);
		buttonGroup.add(rdbtnUsuario);
		
		
		textUsername = new JTextField();
		textUsername.setEnabled(false);
		textUsername.setBounds(423, 71, 86, 20);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnBuscar = new JButton("New button");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(509, 70, 24, 22);
		getContentPane().add(btnBuscar);
			
		rdbtnCategoria.addActionListener((ActionListener) new ActionListener() {
		public void actionPerformed(ActionEvent e){   

	        if (rdbtnCategoria.isSelected()){
	            comboCategoria.setEnabled(true);
	            textUsername.setEnabled(false);
	            btnBuscar.setEnabled(false);
	            comboPrecio.setEnabled(false);
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
		            textUsername.setEnabled(false);
		            btnBuscar.setEnabled(false);
		        	comboCategoria.setEnabled(false);
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
		        	textUsername.setEnabled(false);
		            btnBuscar.setEnabled(false);
		            comboCategoria.setEnabled(false);
		            comboPrecio.setEnabled(false);
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
		
		rdbtnUsuario.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   

		        if (rdbtnUsuario.isSelected()){
		            textUsername.setEnabled(true);
		            btnBuscar.setEnabled(true);
		   
		        }
		    }
			});

		btnBuscar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e){   
				String nomUsuario = textUsername.getText();

		        try {
					if (conn.filtroUsuario(nomUsuario) != null){
						modeloUsuario = new DefaultListModel();
						modelo = modeloUsuario;
						modeloUsuario.addElement(conn.filtroUsuario(nomUsuario));
						list.setModel(modeloUsuario);	        	
					}else{
						 JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", 0);
					}
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
