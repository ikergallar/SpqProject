//package com.SPQ.ventanasSecundarias;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Date;
//import java.util.logging.Level;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//
//import com.SPQ.clasesBasicas.Usuario;
//import com.SPQ.dataBase.DBException;
//import com.SPQ.dataBase.DBManager;
//import com.SPQ.dataBase.LogController;
//import com.SPQ.ventanasPrimarias.VentanaLogin;
//import com.SPQ.ventanasPrimarias.VentanaPerfil;
//import javax.swing.JCheckBox;
//
//
//
//public class VentanaContrasenya extends JFrame{
//	int a = VentanaLogin.getUsuarioId();
//		
//	private JPasswordField contrasenyaActual;
//	private JPasswordField nuevaContrasenya;
//	private JPasswordField confirmarContrasenya;
//	private String nombreUsuario;
//	private Usuario datosUsuario;
//	private Usuario usuario;
//		
//	public VentanaContrasenya() {
//		
//		setTitle("Hustle - Seguridad");
//		setBounds(100, 100, 513, 496);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//			getContentPane().setBackground(new Color(39, 45, 53));
//			getContentPane().setLayout(null);
//			
//			JLabel lblCambiarContrasea = new JLabel("CAMBIAR CONTRASEÑA");
//			lblCambiarContrasea.setForeground(Color.WHITE);
//			lblCambiarContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
//			lblCambiarContrasea.setBounds(133, 24, 223, 20);
//			getContentPane().add(lblCambiarContrasea);
//			
//			JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a actual");
//			lblContraseaAntigua.setForeground(Color.WHITE);
//			lblContraseaAntigua.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblContraseaAntigua.setBounds(32, 74, 160, 20);
//			getContentPane().add(lblContraseaAntigua);
//			
//			contrasenyaActual = new JPasswordField();
//			contrasenyaActual.setBounds(32, 107, 398, 26);
//			getContentPane().add(contrasenyaActual);
//			
//			JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
//			lblNuevaContrasea.setForeground(Color.WHITE);
//			lblNuevaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblNuevaContrasea.setBounds(32, 158, 160, 20);
//			getContentPane().add(lblNuevaContrasea);
//			
//			nuevaContrasenya = new JPasswordField();
//			nuevaContrasenya.setBounds(32, 189, 398, 26);
//			getContentPane().add(nuevaContrasenya);
//			
//			JLabel lblConfirmarContrasea = new JLabel("Confirmar contraseña");
//			lblConfirmarContrasea.setForeground(Color.WHITE);
//			lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			lblConfirmarContrasea.setBounds(32, 243, 160, 20);
//			getContentPane().add(lblConfirmarContrasea);
//			
//			confirmarContrasenya = new JPasswordField();
//			confirmarContrasenya.setBounds(32, 274, 398, 26);
//			getContentPane().add(confirmarContrasenya);
//			
//			JButton btnAtras = new JButton("VOLVER");
//			btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
//			btnAtras.setBackground(Color.RED);
//			btnAtras.setForeground(Color.WHITE);
//			btnAtras.setBounds(0, 398, 248, 59);
//			getContentPane().add(btnAtras);
//			
//			JButton btnCambiar = new JButton("CAMBIAR");
//			btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 16));
//			btnCambiar.setForeground(Color.WHITE);
//			btnCambiar.setBackground(Color.RED);
//			btnCambiar.setBounds(247, 398, 250, 59);
//			getContentPane().add(btnCambiar);
//			
//			final JCheckBox checkVerPass = new JCheckBox("Visualizar contraseñas");
//			checkVerPass.setForeground(Color.WHITE);
//			checkVerPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
//			checkVerPass.setBackground(new Color(39, 45, 53));
//			checkVerPass.setBounds(32, 318, 182, 23);
//			getContentPane().add(checkVerPass);
//			checkVerPass.addActionListener(new ActionListener() {	
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					if(checkVerPass.isSelected()) {
//						contrasenyaActual.setEchoChar((char)0);
//						nuevaContrasenya.setEchoChar((char)0);
//						confirmarContrasenya.setEchoChar((char)0);
//						
//					}else {
//						contrasenyaActual.setEchoChar(('*'));
//						nuevaContrasenya.setEchoChar(('*'));
//						confirmarContrasenya.setEchoChar(('*'));
//
//					}
//					
//				}
//			});
//			
//			btnAtras.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					VentanaLogin va = new VentanaLogin();
//					va.setVisible(true);
//					setVisible(false);
//					
//				}
//			});
//			
//			File f = new File("usuario.txt");
//	    	try {
//				BufferedReader br = new BufferedReader(new FileReader(f));
//				String linea;
//				while((linea = br.readLine()) != null) {
//					nombreUsuario = linea;
//				}
//				br.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    	
//	    DBManager con = new DBManager();
//	    
//	    try {
//	    	con.connect();
//			datosUsuario = con.seleccionarDatos(nombreUsuario);
//			
//			con.disconnect();
//		} catch (DBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//			btnCambiar.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) { 
//					DBManager dbm = new DBManager();
//					try {
//						Usuario usuario1 = new Usuario();
//						usuario1.setNombreUsuario(nombreUsuario);
//						usuario1.setPass(contrasenyaActual.getText());
//						dbm.connect();
//							if(dbm.comprobarContrasenya(usuario1)== true) {
//								if(nuevaContrasenya.getText().equals(confirmarContrasenya.getText())) {
//									try {
//									
//										usuario = new Usuario();
//										usuario.setPass(confirmarContrasenya.getText());
//										usuario.setNombreUsuario(nombreUsuario);
//										
//										dbm.cambiarContrsenya(usuario);
//									dbm.disconnect();
//										JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
//										LogController.log ( Level.INFO, "Contraseña editada correctamente " + (new Date()),null);
//
//									} catch (DBException e1) {
//										e1.printStackTrace();
//									}
//									
//									VentanaPerfil perf = new VentanaPerfil();
//									perf.setVisible(true);
//									dispose();
//								
//								}else {
//									JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", 0);
//									LogController.log ( Level.WARNING, "Las contraseñas no coinciden " + (new Date()),null);
//									contrasenyaActual.setText("");
//									nuevaContrasenya.setText("");
//									confirmarContrasenya.setText("");
//								}
//							}else {
//								JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta", "Error", 0);
//								LogController.log ( Level.WARNING, "Contraseña actual incorrecta " + (new Date()),null);
//								contrasenyaActual.setText("");
//								nuevaContrasenya.setText("");
//								confirmarContrasenya.setText("");
//							}
//						} catch (HeadlessException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (DBException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					
//					
//					
//				}
//			});
//		}
//}
