//package com.SPQ.ventanasPrimarias;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Date;
//import java.util.logging.Level;
//
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//import com.SPQ.clasesBasicas.Usuario;
//import com.SPQ.dataBase.DBException;
//import com.SPQ.dataBase.DBManager;
//import com.SPQ.dataBase.LogController;
//import com.SPQ.ventanasSecundarias.VentanaContrasenya;
//
//
//
//public class VentanaPerfil extends JFrame{
//		
//		private JTextField textNombre;
//		private JTextField textApellido;
//		private JTextField textDireccion;
//		private JTextField textTel;
//		private JTextField textUsuario;
//		private JTextField textMail;
//		private String nombreUsuario;
//		private Usuario datosUsuario;
//		private Usuario usuario;
//		public static void main(String[] args) {
//			
//			LogController.log ( Level.INFO, "Perfil " + (new Date()),null);
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						VentanaPerfil frame = new VentanaPerfil();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					
//					
//				}
//			});
//		}
//		public VentanaPerfil() {
//			
//			setTitle("Hustle - Perfil");
//			setResizable(false);
//			getContentPane().setForeground(new Color(39, 45, 53));
//			
//			int contBarra = 0;
//
//		    File f = new File("usuario.txt");
//		    	try {
//					BufferedReader br = new BufferedReader(new FileReader(f));
//					String linea;
//					while((linea = br.readLine()) != null) {
//						nombreUsuario = linea;
//					}
//					br.close();
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		    	
//		    DBManager con = new DBManager();
//		    
//		    try {
//		    	con.connect();
//				datosUsuario = con.seleccionarDatos(nombreUsuario);
//				
//				con.disconnect();
//			} catch (DBException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		   
//		    
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			setBounds(100, 100, 513, 496);
//			getContentPane().setBackground(new Color(39, 45, 53));
//			getContentPane().setLayout(null);
//			
//			JLabel lblNewLabel = new JLabel("MI PERFIL");
//			lblNewLabel.setForeground(new Color(255, 255, 255));
//			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
//			lblNewLabel.setBounds(204, 11, 105, 40);
//			getContentPane().add(lblNewLabel);
//			
//			JLabel lblNewLabel_1 = new JLabel("Nombre");
//			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNewLabel_1.setForeground(Color.WHITE);
//			lblNewLabel_1.setBounds(36, 82, 46, 14);
//			getContentPane().add(lblNewLabel_1);
//			
//			JLabel lblNewLabel_2 = new JLabel("Apellidos");
//			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNewLabel_2.setForeground(Color.WHITE);
//			lblNewLabel_2.setBounds(36, 107, 89, 14);
//			getContentPane().add(lblNewLabel_2);
//			
//			JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n");
//			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNewLabel_3.setForeground(Color.WHITE);
//			lblNewLabel_3.setBounds(36, 132, 76, 14);
//			getContentPane().add(lblNewLabel_3);
//			
//			JLabel lblNewLabel_5 = new JLabel("Tel\u00E9fono");
//			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNewLabel_5.setForeground(Color.WHITE);
//			lblNewLabel_5.setBounds(36, 156, 76, 14);
//			getContentPane().add(lblNewLabel_5);
//			
//			JLabel lblNewLabel_6 = new JLabel("Mis datos");
//			lblNewLabel_6.setForeground(new Color(255, 255, 255));
//			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
//			lblNewLabel_6.setBounds(26, 57, 126, 14);
//			getContentPane().add(lblNewLabel_6);
//			
//			textNombre = new JTextField(datosUsuario.getNombre());
//			textNombre.setBounds(172, 79, 201, 20);
//			getContentPane().add(textNombre);
//			textNombre.setColumns(10);
//			
//			textApellido = new JTextField(datosUsuario.getApellido());
//			textApellido.setColumns(10);
//			textApellido.setBounds(172, 104, 201, 20);
//			getContentPane().add(textApellido);
//			
//			textDireccion = new JTextField(datosUsuario.getDireccion());
//			textDireccion.setColumns(10);
//			textDireccion.setBounds(172, 129, 201, 20);
//			getContentPane().add(textDireccion);
//			
//			textTel = new JTextField(datosUsuario.getTelefono());
//			textTel.setColumns(10);
//			textTel.setBounds(172, 154, 201, 20);
//			getContentPane().add(textTel);
//			
//
//			JLabel lblNewLabel_7 = new JLabel("Detalles de la cuenta");
//			lblNewLabel_7.setForeground(Color.WHITE);
//			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
//			lblNewLabel_7.setBounds(26, 192, 157, 14);
//			getContentPane().add(lblNewLabel_7);
//			
//			JLabel lblNewLabel_8 = new JLabel("Usuario");
//			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNewLabel_8.setForeground(Color.WHITE);
//			lblNewLabel_8.setBounds(36, 216, 76, 14);
//			getContentPane().add(lblNewLabel_8);
//			
//			JLabel lblNewLabel_8_1 = new JLabel("Mail");
//			lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNewLabel_8_1.setForeground(Color.WHITE);
//			lblNewLabel_8_1.setBounds(36, 244, 76, 14);
//			getContentPane().add(lblNewLabel_8_1);
//			
//			textUsuario = new JTextField(datosUsuario.getNombreUsuario());
//			textUsuario.setEditable(false);
//			textUsuario.setColumns(10);
//			textUsuario.setBounds(172, 216, 201, 20);
//			getContentPane().add(textUsuario);
//			
//			textMail = new JTextField(datosUsuario.getMail());
//			textMail.setColumns(10);
//			textMail.setBounds(172, 242, 201, 20);
//			getContentPane().add(textMail);
//			
//			JButton btnTarjeta_1 = new JButton("VOLVER");
//			btnTarjeta_1.setBackground(Color.RED);
//			btnTarjeta_1.setForeground(Color.WHITE);
//			btnTarjeta_1.setFont(new Font("Tahoma", Font.BOLD, 16));
//			btnTarjeta_1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//				}
//			});
//			btnTarjeta_1.addMouseListener(new MouseAdapter() {
//				
//			});
//			btnTarjeta_1.setBounds(0, 399, 257, 68);
//			getContentPane().add(btnTarjeta_1);
//			
//			
//		
//			JButton btnNewButton = new JButton("GUARDAR");
//			btnNewButton.setBackground(Color.RED);
//			btnNewButton.setForeground(Color.WHITE);
//			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
//			btnNewButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					DBManager con = new DBManager();
//					
//					try {
//						usuario = new Usuario();
//						usuario.setNombre(textNombre.getText());
//						usuario.setApellido(textApellido.getText());
//						usuario.setDireccion(textDireccion.getText());
//						usuario.setTelefono(textTel.getText());
//						usuario.setNombreUsuario(textUsuario.getText());
//						con.connect();
//						con.cambiarDatos(usuario);
//						con.disconnect();
//						
//						JOptionPane.showMessageDialog(null, "Datos editados correctamente", "Informacion", 1);
//						LogController.log ( Level.INFO, "Datos editados correctamente " + (new Date()),null);
//					} catch (DBException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				
//				}
//			});
//			btnNewButton.setBounds(255, 399, 252, 68);
//			getContentPane().add(btnNewButton);
//			
//			JButton botonCerrarSesion = new JButton("Cerrar Sesion");
//			botonCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
//			botonCerrarSesion.setForeground(Color.WHITE);
//			botonCerrarSesion.setBackground(Color.RED);
//			botonCerrarSesion.setBounds(336, 281, 134, 40);
//			getContentPane().add(botonCerrarSesion);
//			
//			final JLabel cambiarPass = new JLabel("¿Deseas cambiar tu contraseña? Pincha aquí.");
//			cambiarPass.setForeground(Color.GRAY);
//			cambiarPass.setBounds(36, 295, 273, 14);
//			getContentPane().add(cambiarPass);
//			
//			cambiarPass.addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					VentanaContrasenya sec = new VentanaContrasenya();
//					sec.setVisible(true);
//					dispose();
//				}
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					cambiarPass.setForeground(Color.WHITE);
//				}
//				@Override
//				public void mouseExited(MouseEvent e) {
//					cambiarPass.setForeground(Color.GRAY);
//				}
//			});
//			
//			
//			
//			botonCerrarSesion.addActionListener(new ActionListener() {	
//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					VentanaLogin login = new VentanaLogin();
//					login.setVisible(true);
//					dispose();
//					
//				}
//				
//			});
//			
//		}
//	}
//
