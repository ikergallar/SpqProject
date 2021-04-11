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
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 515, 676);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(0, 0, 509, 319);
		frmLogin.getContentPane().add(panelLogo);
		panelLogo.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(getClass().getResource("/imagenesEstaticas/hustleCompleto.png")));
		panelLogo.add(labelLogo);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(0, 499, 500, 210);
		frmLogin.getContentPane().add(panelLogin);
		panelLogin.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panelCorreo = new JPanel();
		panelCorreo.setBackground(UIManager.getColor("Button.background"));
		panelLogin.add(panelCorreo);
		FlowLayout fl_panelCorreo = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelCorreo.setLayout(fl_panelCorreo);

		final JLabel labelRegistro = new JLabel("\u00BFEres nuevo? Reg\u00EDstrate Aqu\u00ED");
		labelRegistro.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				labelRegistro.setForeground(Color.BLACK);
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
		labelRegistro.setForeground(Color.GRAY);
		panelCorreo.add(labelRegistro);

		JButton botonLogin = new JButton("Login");
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
		botonLogin.setBackground(Color.BLACK);
		botonLogin.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		panelLogin.add(botonLogin);
		
		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setBounds(36, 450, 293, 26);
		frmLogin.getContentPane().add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		JLabel labelCorreo = new JLabel("Usuario");
		labelCorreo.setBounds(36, 313, 52, 89);
		frmLogin.getContentPane().add(labelCorreo);
		labelCorreo.setForeground(Color.BLACK);
		labelCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(36, 376, 366, 26);
		frmLogin.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsuario.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		textFieldUsuario.setColumns(30);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 426, 111, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		final JCheckBox checkVerPass = new JCheckBox("Ver contraseña");
		checkVerPass.setBounds(335, 450, 137, 26);
		frmLogin.getContentPane().add(checkVerPass);
		
		JLabel lblNewLabel_1 = new JLabel("¿Se le ha olvidado la contraseña? Pulse aquí si desea recuperarla");
		lblNewLabel_1.setBounds(75, 481, 356, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
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
