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
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasLogin.VentanaLogin;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class VentanaAnuncios extends JFrame{
	
	private DefaultListModel modelo;
	private DefaultListModel modeloCategoria;
	private DefaultListModel modeloPrecio;
	private DefaultListModel modeloOferta;
	private DefaultListModel modeloUsuario;
	private List<Anuncio> listaCategoria;
	private List<Anuncio> listaPrecio;
	private List<Anuncio> listaOferta;
	private List<Anuncio> listaUsuario;
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
		getContentPane().setForeground(new Color(39, 45, 53));
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
					
		
		list = new JList();
		list.setBounds(205, 88, 584, 440);
		getContentPane().add(list);
				
		DBManager conn = new DBManager();
		
		JRadioButton rdbtnCategoria = new JRadioButton("Categoría");
		rdbtnCategoria.setForeground(Color.WHITE);
		rdbtnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnCategoria.setBounds(41, 123, 109, 23);
		getContentPane().add(rdbtnCategoria);
			
		JComboBox<Categoria> comboCategoria = new JComboBox<Categoria>();
		comboCategoria.setBackground(Color.RED);
		comboCategoria.setEnabled(false);
		comboCategoria.addItem(Categoria.INFORMATICO);
		comboCategoria.addItem(Categoria.ALBAYIL);
        comboCategoria.addItem(Categoria.FONTANERO);      
        comboCategoria.addItem(Categoria.PERSIANERO);
		comboCategoria.setBounds(41, 153, 133, 33);
		getContentPane().add(comboCategoria);
		
		modelo = new DefaultListModel();
		try {
			modelo.addElement(conn.listarAnuncios());
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		list.setModel(modelo);
		
		JLabel flitro = new JLabel("FILTRADO");
		flitro.setForeground(Color.WHITE);
		flitro.setFont(new Font("Tahoma", Font.BOLD, 14));
		flitro.setBounds(22, 87, 104, 14);
		getContentPane().add(flitro);
		
		JRadioButton rdbtnPrecio = new JRadioButton("Precio:");
		rdbtnPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPrecio.setForeground(Color.WHITE);
		rdbtnPrecio.setBounds(41, 220, 109, 23);
		getContentPane().add(rdbtnPrecio);
		
		JComboBox comboPrecio = new JComboBox();
		comboPrecio.setForeground(Color.WHITE);
		comboPrecio.setBackground(Color.RED);
		comboPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboPrecio.setEnabled(false);
		comboPrecio.addItem("Mayor precio");
		comboPrecio.addItem("Menor precio");
		comboPrecio.setBounds(41, 250, 133, 35);
		getContentPane().add(comboPrecio);
		
		JRadioButton rdbtnOferta = new JRadioButton("Ofertas:");
		rdbtnOferta.setForeground(Color.WHITE);
		rdbtnOferta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOferta.setBounds(41, 317, 109, 23);
		getContentPane().add(rdbtnOferta);
		
		JRadioButton rdbtnUsuario = new JRadioButton("Nombre de usuario:");
		rdbtnUsuario.setForeground(Color.WHITE);
		rdbtnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnUsuario.setBounds(41, 369, 165, 23);
		getContentPane().add(rdbtnUsuario);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCategoria);
		buttonGroup.add(rdbtnPrecio);
		buttonGroup.add(rdbtnOferta);
		buttonGroup.add(rdbtnUsuario);
		
		
		textUsername = new JTextField();
		textUsername.setForeground(Color.WHITE);
		textUsername.setBackground(Color.RED);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textUsername.setEnabled(false);
		textUsername.setBounds(41, 399, 98, 35);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnBuscar = new JButton("New button");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(139, 399, 35, 35);
		getContentPane().add(btnBuscar);
		
		JLabel lblTiruloServicios = new JLabel("SERVICIOS");
		lblTiruloServicios.setForeground(Color.WHITE);
		lblTiruloServicios.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTiruloServicios.setBounds(325, 29, 139, 33);
		getContentPane().add(lblTiruloServicios);
			
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
					try {
						listaCategoria = (conn.filtroCategoria((Categoria)comboCategoria.getSelectedItem()));
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for (Anuncio anuncios : listaCategoria) {
						modelo = modeloCategoria;
						modeloCategoria.addElement(anuncios);
						list.setModel(modeloCategoria);
					}
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
						try {
							listaPrecio = (conn.filtroPrecioMayor());
						} catch (DBException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						for (Anuncio anuncios : listaPrecio) {
							modelo = modeloPrecio;
							modeloPrecio.addElement(anuncios);
							list.setModel(modeloPrecio);
						}
										
					}else if(comboPrecio.getSelectedItem().toString().equals("Menor precio")) {
						modeloPrecio = new DefaultListModel();
						modelo = modeloPrecio;
						try {
							listaPrecio = (conn.filtroPrecioMenor());
						} catch (DBException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						for (Anuncio anuncios : listaPrecio) {
							modeloPrecio.addElement(anuncios);
							list.setModel(modeloPrecio);
						}
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
							listaOferta = (conn.filtroOfertas());
						} catch (DBException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						for (Anuncio anuncios : listaOferta) {
							modeloOferta.addElement(anuncios);
							list.setModel(modeloOferta);
						}
			            
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
					modeloUsuario = new DefaultListModel();
					Usuario usuario;
					try {
						usuario = conn.seleccionarUsuario(nomUsuario);
						listaUsuario = (conn.filtroUsuario(usuario));

					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				

					for (Anuncio anuncios : listaUsuario) {
						modelo = modeloUsuario;
						modeloUsuario.addElement(anuncios);
						list.setModel(modeloUsuario);
					}
			    }
				});
		
		this.setSize(835,592);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ANUNCIOS");
		this.setVisible(true);
		
	}
}
