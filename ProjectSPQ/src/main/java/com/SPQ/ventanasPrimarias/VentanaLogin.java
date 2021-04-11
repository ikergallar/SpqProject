package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import org.glassfish.grizzly.streams.AbstractStreamWriter.DisposeBufferCompletionHandler;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.dataBase.LogController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogin {

	private JFrame frmLogin;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(39, 45, 53));
		frmLogin.setResizable(false);
		frmLogin.setTitle("Hustle - Login");
		frmLogin.setBounds(100, 100, 513, 869);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(500, 0, 0, 500);
		frmLogin.getContentPane().add(panelLogo);
		panelLogo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(UIManager.getColor("Button.background"));
		panelLogin.setBounds(0, 724, 497, 108);
		frmLogin.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);

		JPanel panelCorreo = new JPanel();
		panelCorreo.setBounds(0, 0, 497, 36);
		panelCorreo.setBackground(new Color(39, 45, 53));
		panelLogin.add(panelCorreo);

		final JLabel labelRegistro = new JLabel("\u00BFEres nuevo? Reg\u00EDstrate Aqu\u00ED");
		labelRegistro.setBounds(173, 11, 233, 14);
		labelRegistro.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				labelRegistro.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelRegistro.setForeground(Color.GRAY);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Ventana para registro
				VentanaRegistro register = new VentanaRegistro();
				register.setVisible(true);

			}
		});
		panelCorreo.setLayout(null);
		labelRegistro.setForeground(Color.GRAY);
		panelCorreo.add(labelRegistro);

		JButton botonLogin = new JButton("LOGIN");
		botonLogin.setBounds(0, 35, 497, 73);
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nomUsuario = textFieldUsuario.getText();
                String contrasena = textFieldContrasena.getText();
                DBManager conexion = new DBManager();
                
                

                try {
                    conexion.connect();

                    if (conexion.loginUsuario(nomUsuario,contrasena) == true) {
                    	
                    	File archivo;
        				
        				FileWriter escribir;
        				PrintWriter linea;
        				
        				archivo = new File("usuario.txt");
        				if(!archivo.exists()) {
        					try {
        						archivo.createNewFile();
        					} catch (IOException e2) {
        						// TODO Auto-generated catch block
        						e2.printStackTrace();
        					}
        				}else {
        					try { 
        						escribir = new FileWriter(archivo,true);
        						linea = new PrintWriter(escribir);
        						linea.println(nomUsuario);
        						linea.close();
        						escribir.close();
        					} catch (FileNotFoundException | UnsupportedEncodingException e3) {
        						// TODO Auto-generated catch block
        						e3.printStackTrace();
        					} catch (IOException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        				}
        				LogController.log ( Level.INFO, "Sesion iniciada " + (new Date()),null);
        				VentanaPerfil perfil = new VentanaPerfil();
                    	perfil.setVisible(true);
                    	frmLogin.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
                		LogController.log ( Level.WARNING, "No se ha podido iniciar sesion " + (new Date()),null);
                        textFieldUsuario.setText("");
                        textFieldContrasena.setText("");
                    }

                    conexion.disconnect();

                } catch (DBException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

	
			}
		});
		botonLogin.setForeground(Color.WHITE);
		botonLogin.setBackground(new Color(255, 0, 0));
		botonLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelLogin.add(botonLogin);
		
		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setBounds(36, 630, 293, 26);
		frmLogin.getContentPane().add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		JLabel labelCorreo = new JLabel("Usuario");
		labelCorreo.setBackground(Color.WHITE);
		labelCorreo.setBounds(36, 499, 52, 89);
		frmLogin.getContentPane().add(labelCorreo);
		labelCorreo.setForeground(Color.WHITE);
		labelCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(36, 562, 398, 26);
		frmLogin.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsuario.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		textFieldUsuario.setColumns(30);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 599, 111, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		final JCheckBox checkVerPass = new JCheckBox("Ver contraseña");
		checkVerPass.setBackground(new Color(39, 45, 53));
		checkVerPass.setForeground(Color.WHITE);
		checkVerPass.setBounds(335, 630, 137, 26);
		frmLogin.getContentPane().add(checkVerPass);
		
		final JLabel textoRecuperacion = new JLabel("¿Se le ha olvidado la contraseña? Pulse aquí si desea recuperarla");
		textoRecuperacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoRecuperacion.setBackground(Color.WHITE);
		textoRecuperacion.setForeground(Color.GRAY);
		textoRecuperacion.setBounds(36, 667, 398, 14);
		frmLogin.getContentPane().add(textoRecuperacion);
		textoRecuperacion.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				textoRecuperacion.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textoRecuperacion.setForeground(Color.GRAY);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Ventana para registro
				VentanaRecuperacion recuperacionContra = new VentanaRecuperacion();
				recuperacionContra.setVisible(true);

			}
		});
		
				JLabel labelLogo = new JLabel("");
				labelLogo.setBounds(0, 0, 500, 500);
				frmLogin.getContentPane().add(labelLogo);
				labelLogo.setIcon(new ImageIcon(getClass().getResource("/imagenesEstaticas/hustle500.png")));
		checkVerPass.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkVerPass.isSelected()) {
					
					textFieldContrasena.setEchoChar((char)0);
					
				}else {
					
					textFieldContrasena.setEchoChar(('*'));
				}
				
			}
		});

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static int getUsuarioId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
