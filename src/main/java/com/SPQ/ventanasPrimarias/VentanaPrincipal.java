package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.ventanasAnuncio.VentanaMisAnuncios;
import com.SPQ.ventanasLogin.VentanaContrasenya;
import com.SPQ.ventanasLogin.VentanaLogin;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame{

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTel;
	private JTextField textUsuario;
	private JTextField textMail;
	private DefaultListModel modelo;
	private DefaultListModel modeloCategoria;
	private DefaultListModel modeloPrecio;
	private DefaultListModel modeloOferta;
	private DefaultListModel modeloUsuario;
	private List<Anuncio> lista;
	private List<Anuncio> listaCategoria;
	private List<Anuncio> listaPrecio;
	private List<Anuncio> listaOferta;
	private List<Anuncio> listaUsuario;
	private JScrollPane scrollPane;
	private JList list;
	private ButtonGroup buttonGroup;	
	private JTextField textUsername;
	JPanel panelPerfil;
	JPanel panelServicios;
    DBManager con = new DBManager();
    JPanel panelesDinamicos;
    CardLayout cl= new CardLayout();



	public VentanaPrincipal(Usuario usuario) {

		setResizable(false);
		getContentPane().setBackground(new Color(39, 45, 53));
		setTitle("Hustle - Inicio");
		setBounds(100, 100, 1120, 729);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelesDinamicos = new JPanel();
		panelesDinamicos.setBackground(new Color(39, 45, 53));
		panelesDinamicos.setBounds(250, 89, 835, 592);
		getContentPane().add(panelesDinamicos);
		panelesDinamicos.setLayout(cl);
		
		panelPerfil = genPanelPerfil(usuario);
		panelPerfil.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelPerfil, "1");
		
		panelServicios = genPanelServicios();
		panelServicios.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelServicios, "2");
		
		JPanel panelChat = new JPanel();
		panelChat.setBounds(0, 0, 835, 592);
		panelesDinamicos.add(panelChat, "3");
		panelChat.setLayout(null);
		cl.show(panelesDinamicos, "1");
		
		JPanel panelSelecVentana = new JPanel();
		panelSelecVentana.setBounds(20, 89, 230, 600);
		getContentPane().add(panelSelecVentana);
		panelSelecVentana.setLayout(new GridLayout(3, 1, 0, 0));
		
		//Paneles laterales
		JPanel ventPerfil = new JPanel();
		JPanel ventServicios = new JPanel();
		JPanel ventChat = new JPanel();
		
		ventPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventPerfil.setBackground(Color.gray);
				ventChat.setBackground(new Color(39, 45, 53));
				ventServicios.setBackground(new Color(39, 45, 53));
				
				cl.show(panelesDinamicos, "1");
			}
		});
		ventPerfil.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventPerfil);
		ventPerfil.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgPerfil = new JLabel("");
		imgPerfil.setIcon(new ImageIcon(getClass().getResource("/iconoPerfil.png")));
		ventPerfil.add(imgPerfil);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventPerfil.add(lblPerfil);
		
		
		ventServicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventServicios.setBackground(Color.gray);
				ventChat.setBackground(new Color(39, 45, 53));
				ventPerfil.setBackground(new Color(39, 45, 53));
				
				cl.show(panelesDinamicos, "2");
			}
		});
		ventServicios.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventServicios);
		ventServicios.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgServicios = new JLabel("");
		imgServicios.setIcon(new ImageIcon(getClass().getResource("/iconoServicios.png")));
		ventServicios.add(imgServicios);
		
		JLabel lblServicios = new JLabel("SERVICIOS");
		lblServicios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblServicios.setForeground(Color.WHITE);
		ventServicios.add(lblServicios);
		
		
		ventChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventChat.setBackground(Color.gray);
				ventServicios.setBackground(new Color(39, 45, 53));
				ventPerfil.setBackground(new Color(39, 45, 53));
				
				cl.show(panelesDinamicos, "3");
			}
		});
		ventChat.setBackground(new Color(39, 45, 53));
		panelSelecVentana.add(ventChat);
		ventChat.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel imgChat = new JLabel("");
		imgChat.setIcon(new ImageIcon(getClass().getResource("/iconoChat.png")));
		ventChat.add(imgChat);
		
		JLabel lblChat = new JLabel("CHAT");
		lblChat.setForeground(Color.WHITE);
		lblChat.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventChat.add(lblChat);
		
		JPanel logoImg = new JPanel();
		logoImg.setBackground(new Color(39, 45, 53));
		logoImg.setBounds(0, 0, 422, 89);
		getContentPane().add(logoImg);
		logoImg.setLayout(null);
		
		JLabel imgLogoHorizontal = new JLabel("");
		imgLogoHorizontal.setIcon(new ImageIcon(getClass().getResource("/logoHorizontal.png")));
		imgLogoHorizontal.setBounds(10, 11, 402, 67);
		logoImg.add(imgLogoHorizontal);
	}
	

	
	public JPanel genPanelPerfil(Usuario usuario){
		JPanel panelPerfilGen=new JPanel();
		panelPerfilGen.setBackground(new Color(39, 45, 53));
		panelPerfilGen.setLayout(null);    	

	    		 		  		    

	    panelPerfilGen.setBounds(100, 100, 835, 592);
	    panelPerfilGen.setBackground(new Color(39, 45, 53));
	    panelPerfilGen.setLayout(null);
		
		JLabel lblTituloPerfil = new JLabel("MI PERFIL");
		lblTituloPerfil.setForeground(new Color(255, 255, 255));
		lblTituloPerfil.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTituloPerfil.setBounds(334, 11, 126, 40);
		panelPerfilGen.add(lblTituloPerfil);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(46, 102, 46, 14);
		panelPerfilGen.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(46, 127, 89, 14);
		panelPerfilGen.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(46, 152, 76, 14);
		panelPerfilGen.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(46, 177, 76, 14);
		panelPerfilGen.add(lblTelefono);
		
		JLabel lblDatos = new JLabel("Mis datos");
		lblDatos.setForeground(new Color(255, 255, 255));
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatos.setBounds(36, 64, 126, 14);
		panelPerfilGen.add(lblDatos);
		
		textNombre = new JTextField(usuario.getNombre());
		textNombre.setBounds(172, 100, 201, 20);
		panelPerfilGen.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField(usuario.getApellido());
		textApellido.setColumns(10);
		textApellido.setBounds(172, 125, 201, 20);
		panelPerfilGen.add(textApellido);
		
		textDireccion = new JTextField(usuario.getDireccion());
		textDireccion.setColumns(10);
		textDireccion.setBounds(172, 150, 201, 20);
		panelPerfilGen.add(textDireccion);
		
		textTel = new JTextField(usuario.getTelefono());
		textTel.setColumns(10);
		textTel.setBounds(172, 175, 201, 20);
		panelPerfilGen.add(textTel);
		

		JLabel lblDetalles = new JLabel("Detalles de la cuenta");
		lblDetalles.setForeground(Color.WHITE);
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalles.setBounds(36, 213, 157, 14);
		panelPerfilGen.add(lblDetalles);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(46, 251, 76, 14);
		panelPerfilGen.add(lblUsuario);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMail.setForeground(Color.WHITE);
		lblMail.setBounds(46, 276, 76, 14);
		panelPerfilGen.add(lblMail);
		
		textUsuario = new JTextField(usuario.getNombreUsuario());
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(172, 249, 201, 20);
		panelPerfilGen.add(textUsuario);
		
		textMail = new JTextField(usuario.getMail());
		textMail.setColumns(10);
		textMail.setBounds(172, 274, 201, 20);
		panelPerfilGen.add(textMail);
		
			
		
			JButton btnNewButton = new JButton("GUARDAR");
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DBManager con = new DBManager();
					
					try {
						usuario.setNombre(textNombre.getText());
						usuario.setApellido(textApellido.getText());
						usuario.setDireccion(textDireccion.getText());
						usuario.setTelefono(textTel.getText());
						usuario.setNombreUsuario(textUsuario.getText());
						con.updateUsuario(usuario);
						
						JOptionPane.showMessageDialog(null, "Datos editados correctamente", "Informacion", 1);
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
			});
			
			btnNewButton.setBounds(36, 494, 337, 68);
			panelPerfilGen.add(btnNewButton);
			
			JButton botonCerrarSesion = new JButton("Cerrar Sesion");
			botonCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
			botonCerrarSesion.setForeground(Color.WHITE);
			botonCerrarSesion.setBackground(Color.RED);
			botonCerrarSesion.setBounds(641, 15, 157, 51);
			panelPerfilGen.add(botonCerrarSesion);
			
			final JLabel cambiarPass = new JLabel("¿Deseas cambiar tu contraseña? Pincha aquí.");
			cambiarPass.setForeground(Color.GRAY);
			cambiarPass.setBounds(36, 314, 273, 14);
			panelPerfilGen.add(cambiarPass);
			
			JButton btnServicios = new JButton("MIS SERVICIOS");
			btnServicios.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnServicios.setForeground(Color.WHITE);
			btnServicios.setBackground(Color.RED);
			btnServicios.setBounds(461, 494, 337, 68);
			panelPerfilGen.add(btnServicios);
			
			btnServicios.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					VentanaMisAnuncios misAnuncios = new VentanaMisAnuncios(usuario);
					misAnuncios.setVisible(true);
					
				}
				
			});
			
			cambiarPass.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					VentanaContrasenya sec = new VentanaContrasenya(usuario);
					sec.setVisible(true);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					cambiarPass.setForeground(Color.WHITE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cambiarPass.setForeground(Color.GRAY);
				}
			});
						
			botonCerrarSesion.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);				
				}
				
			});
			return panelPerfilGen;
	}
	public JPanel genPanelServicios(){
		JPanel panelServiciosGen= new JPanel();
		
		panelServiciosGen.setBackground(new Color(39, 45, 53));
		panelServiciosGen.setSize(835,592);
		panelServiciosGen.setLayout(null);
					
		
		list = new JList();
		list.setBackground(Color.WHITE);
		list.setBounds(205, 88, 584, 440);
		panelServiciosGen.add(list);
				
		DBManager conn = new DBManager();
		
		JRadioButton rdbtnCategoria = new JRadioButton("Categoría");
		rdbtnCategoria.setBackground(new Color(39, 45, 53));
		rdbtnCategoria.setForeground(Color.WHITE);
		rdbtnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnCategoria.setBounds(41, 123, 109, 23);
		panelServiciosGen.add(rdbtnCategoria);
			
		JComboBox<Categoria> comboCategoria = new JComboBox<Categoria>();
		comboCategoria.setBackground(Color.RED);
		comboCategoria.setEnabled(false);
		comboCategoria.addItem(Categoria.INFORMATICO);
		comboCategoria.addItem(Categoria.ALBAYIL);
        comboCategoria.addItem(Categoria.FONTANERO);      
        comboCategoria.addItem(Categoria.PERSIANERO);
		comboCategoria.setBounds(41, 153, 133, 33);
		panelServiciosGen.add(comboCategoria);
		
		modelo = new DefaultListModel();
		
		try {
			lista = conn.listarAnuncios();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		for (Anuncio anuncios : lista) {
			modelo.addElement(anuncios);
			list.setModel(modelo);
		}
		
		
		JLabel flitro = new JLabel("FILTRADO");
		flitro.setForeground(Color.WHITE);
		flitro.setFont(new Font("Tahoma", Font.BOLD, 14));
		flitro.setBounds(22, 87, 104, 14);
		panelServiciosGen.add(flitro);
		
		JRadioButton rdbtnPrecio = new JRadioButton("Precio");
		rdbtnPrecio.setBackground(new Color(39, 45, 53));
		rdbtnPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPrecio.setForeground(Color.WHITE);
		rdbtnPrecio.setBounds(41, 220, 109, 23);
		panelServiciosGen.add(rdbtnPrecio);
		
		JComboBox comboPrecio = new JComboBox();
		comboPrecio.setForeground(Color.WHITE);
		comboPrecio.setBackground(Color.RED);
		comboPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboPrecio.setEnabled(false);
		comboPrecio.addItem("Mayor precio");
		comboPrecio.addItem("Menor precio");
		comboPrecio.setBounds(41, 250, 133, 35);
		panelServiciosGen.add(comboPrecio);
		
		JRadioButton rdbtnOferta = new JRadioButton("Ofertas");
		rdbtnOferta.setBackground(new Color(39, 45, 53));
		rdbtnOferta.setForeground(Color.WHITE);
		rdbtnOferta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOferta.setBounds(41, 317, 109, 23);
		panelServiciosGen.add(rdbtnOferta);
		
		JRadioButton rdbtnUsuario = new JRadioButton("Nombre de usuario");
		rdbtnUsuario.setBackground(new Color(39, 45, 53));
		rdbtnUsuario.setForeground(Color.WHITE);
		rdbtnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnUsuario.setBounds(41, 369, 165, 23);
		panelServiciosGen.add(rdbtnUsuario);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCategoria);
		buttonGroup.add(rdbtnPrecio);
		buttonGroup.add(rdbtnOferta);
		buttonGroup.add(rdbtnUsuario);
		
		
		textUsername = new JTextField();
		textUsername.setForeground(Color.BLACK);
		textUsername.setBackground(Color.WHITE);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textUsername.setEnabled(false);
		textUsername.setBounds(41, 399, 98, 35);
		panelServiciosGen.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnBuscar = new JButton("New button");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(139, 399, 35, 35);
		panelServiciosGen.add(btnBuscar);
		
		JLabel lblTiruloServicios = new JLabel("SERVICIOS");
		lblTiruloServicios.setForeground(Color.WHITE);
		lblTiruloServicios.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTiruloServicios.setBounds(325, 29, 139, 33);
		panelServiciosGen.add(lblTiruloServicios);
			
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
						if(anuncios.getCategoria() != null) {
						   modeloCategoria.addElement(anuncios);
						   list.setModel(modeloCategoria);
						}else {
						    JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", 0);
						}
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
						if(anuncios.getIdUsuario() >0) {
							
						}
						modelo = modeloUsuario;
						modeloUsuario.addElement(anuncios);
						list.setModel(modeloUsuario);
					}
			    }
				});
		
			
		
		return panelServiciosGen;
	}
}
