package com.SPQ.ventanasPrimarias;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin {

	private JFrame frmLogin;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;

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
		frmLogin.setBounds(100, 100, 515, 748);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(0, 0, 500, 355);
		frmLogin.getContentPane().add(panelLogo);
		panelLogo.setLayout(new GridLayout(0, 1, 0, 0));

		//JLabel labelLogo = new JLabel("");
		//labelLogo.setIcon(new ImageIcon(getClass().getResource("/archivos/EasyBookingLogo2.gif")));
		//panelLogo.add(labelLogo);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(0, 499, 500, 210);
		frmLogin.getContentPane().add(panelLogin);
		panelLogin.setLayout(new GridLayout(3, 1, 0, 0));

		JLabel labelCorreo = new JLabel("Correo:");
		labelCorreo.setForeground(Color.BLACK);
		labelCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCorreo.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		panelLogin.add(labelCorreo);

		JPanel panelCorreo = new JPanel();
		panelCorreo.setBackground(Color.WHITE);
		panelLogin.add(panelCorreo);
		FlowLayout fl_panelCorreo = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelCorreo.setLayout(fl_panelCorreo);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsuario.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		panelCorreo.add(textFieldUsuario);
		textFieldUsuario.setColumns(30);

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

                       System.out.println("animo");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
                        textFieldUsuario.setText("");
                        textFieldContrasena.setText("");
                    }

                    conexion.disconnect();

                } catch (DBException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


				
				
				
				
				
				
				
				
				
			/*	String correo = "";
				correo = textFieldCorreo.getText();
				if (correo.length() >= 10) {
					System.out.println("Comprobando login para : " + correo);
					String[] correoCompleto = correo.split("@");
					String nomUsuario = correoCompleto[0];

					VentanaPrincipal.lanzar(nomUsuario);
					frmLogin.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Debes rellenar el campo del correo.", "", 0);
				}
*/
			}
		});
		botonLogin.setForeground(Color.WHITE);
		botonLogin.setBackground(Color.BLACK);
		botonLogin.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		panelLogin.add(botonLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 366, 46, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(22, 403, 86, 20);
		frmLogin.getContentPane().add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

	}
}
