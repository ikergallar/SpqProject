/**
 *  @package VentanasLogin
 */
package com.SPQ.ventanasLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import javax.swing.JCheckBox;

public class VentanaContrasenya extends JFrame {
	//int a = VentanaLogin.getUsuarioId();
	private JPasswordField nuevaContrasenya;
	private JPasswordField confirmarContrasenya;
	private String nombreUsuario;


	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget usuarioTarget = appTarget.path("usuarios");
	final WebTarget contrasenyaTarget = usuarioTarget.path("contra");

	
	/**
	 * Create the frame.
	 *  
	 */
	public VentanaContrasenya(Usuario usuario) {

		setTitle("Hustle - Seguridad");
		setBounds(100, 100, 513, 409);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(new Color(39, 45, 53));
		getContentPane().setLayout(null);

		JLabel lblCambiarContrasea = new JLabel("CAMBIAR CONTRASEÑA");
		lblCambiarContrasea.setForeground(Color.WHITE);
		lblCambiarContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCambiarContrasea.setBounds(133, 24, 223, 20);
		getContentPane().add(lblCambiarContrasea);

		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setForeground(Color.WHITE);
		lblNuevaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNuevaContrasea.setBounds(32, 84, 160, 20);
		getContentPane().add(lblNuevaContrasea);

		nuevaContrasenya = new JPasswordField();
		nuevaContrasenya.setBounds(32, 115, 398, 26);
		getContentPane().add(nuevaContrasenya);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar contraseña");
		lblConfirmarContrasea.setForeground(Color.WHITE);
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirmarContrasea.setBounds(32, 152, 160, 20);
		getContentPane().add(lblConfirmarContrasea);

		confirmarContrasenya = new JPasswordField();
		confirmarContrasenya.setBounds(32, 183, 398, 26);
		getContentPane().add(confirmarContrasenya);

		JButton btnAtras = new JButton("VOLVER");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBackground(Color.RED);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBounds(0, 311, 248, 59);
		getContentPane().add(btnAtras);

		JButton btnCambiar = new JButton("CAMBIAR");
		btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCambiar.setForeground(Color.WHITE);
		btnCambiar.setBackground(Color.RED);
		btnCambiar.setBounds(247, 311, 250, 59);
		getContentPane().add(btnCambiar);

		final JCheckBox checkVerPass = new JCheckBox("Visualizar contraseñas");
		checkVerPass.setForeground(Color.WHITE);
		checkVerPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkVerPass.setBackground(new Color(39, 45, 53));
		checkVerPass.setBounds(32, 216, 182, 23);
		getContentPane().add(checkVerPass);

		/**
		 * CheckBox para visualizar la contraseña.
		 *  
		 */
		checkVerPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkVerPass.isSelected()) {

					nuevaContrasenya.setEchoChar((char) 0);
					confirmarContrasenya.setEchoChar((char) 0);

				} else {

					nuevaContrasenya.setEchoChar(('*'));
					confirmarContrasenya.setEchoChar(('*'));

				}

			}
		});

		/**
		 * boton para ir hacia atras.
		 *  
		 */
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogin va = new VentanaLogin();
				va.setVisible(true);
				setVisible(false);

			}
		});

		/**
		 * Boton para realizar el cambio de contraseña.
		 *  
		 */
		btnCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (nuevaContrasenya.getText().equals(confirmarContrasenya.getText())) {

						usuario.setPass(confirmarContrasenya.getText());
						contrasenyaTarget.request().put(Entity.entity(usuario, MediaType.APPLICATION_JSON));
						JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);

						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", 0);
						nuevaContrasenya.setText("");
						confirmarContrasenya.setText("");
					}

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
