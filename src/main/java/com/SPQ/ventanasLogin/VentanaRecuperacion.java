package com.SPQ.ventanasLogin;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;

public class VentanaRecuperacion extends JDialog {

	private JPanel contentPane;
	private JPasswordField texto_contrasena;
	private JPasswordField texto_confPass;
	private JTextField texto_usuario;
	private JTextField textoRespuesta;
	private List<Usuario> usuarios;

	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget usuarioTarget = appTarget.path("usuarios");
	final WebTarget listarUsuarioTarget = usuarioTarget.path("listaUsuarios");
	final WebTarget cambiarContraTarget = usuarioTarget.path("contra");

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecuperacion frame = new VentanaRecuperacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRecuperacion() {
		setTitle("Hustle - Recuperación Contraseña");

		GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {
		};
		usuarios = listarUsuarioTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 45, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelContrasena = new JLabel("Nueva contraseña");
		labelContrasena.setForeground(Color.WHITE);
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelContrasena.setBounds(280, 37, 136, 17);
		contentPane.add(labelContrasena);

		texto_contrasena = new JPasswordField();
		texto_contrasena.setBounds(280, 76, 173, 19);
		contentPane.add(texto_contrasena);

		JLabel lblConfPass = new JLabel("Confirmar contraseña");
		lblConfPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfPass.setForeground(new Color(255, 255, 255));
		lblConfPass.setBounds(280, 125, 200, 14);
		contentPane.add(lblConfPass);

		texto_confPass = new JPasswordField();
		texto_confPass.setBounds(278, 165, 175, 20);
		contentPane.add(texto_confPass);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(31, 37, 70, 17);
		contentPane.add(labelUsuario);

		texto_usuario = new JTextField();
		texto_usuario.setColumns(10);
		texto_usuario.setBounds(31, 76, 175, 19);
		contentPane.add(texto_usuario);

		JButton btnRegistrar = new JButton("RECUPERAR");

		btnRegistrar.setBackground(new Color(255, 0, 0));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrar.setBounds(0, 308, 497, 72);
		contentPane.add(btnRegistrar);

		ImageIcon ico4 = new ImageIcon("imagenes/fondos.jpg");

		JLabel labelPregunta = new JLabel("Pregunta recuperación");
		labelPregunta.setForeground(Color.WHITE);
		labelPregunta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPregunta.setBounds(31, 124, 150, 17);
		contentPane.add(labelPregunta);

		final JComboBox comboPreguntas = new JComboBox();
		comboPreguntas.addItem("-");
		comboPreguntas.addItem("¿Nombre de tu madre?");
		comboPreguntas.addItem("¿Nombre de tu padre?");
		comboPreguntas.addItem("¿Ciudad natal?");
		comboPreguntas.addItem("¿Fecha especial?");
		comboPreguntas.addItem("¿Mascota de la infancia?");
		comboPreguntas.setBounds(31, 164, 175, 22);
		contentPane.add(comboPreguntas);

		JLabel labelRespuesta = new JLabel("Respuesta");
		labelRespuesta.setForeground(Color.WHITE);
		labelRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelRespuesta.setBounds(31, 212, 150, 17);
		contentPane.add(labelRespuesta);

		textoRespuesta = new JTextField();
		textoRespuesta.setColumns(10);
		textoRespuesta.setBounds(31, 246, 175, 19);
		contentPane.add(textoRespuesta);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomUsuario = texto_usuario.getText();
				String palabraRecuperacion = textoRespuesta.getText();
				String preguntaRecuperacion = comboPreguntas.getSelectedItem().toString();
				boolean comprobar = false;

				for (Usuario usuario : usuarios) {
					if (usuario.getNombreUsuario().equals(nomUsuario)
							&& usuario.getPalabraRecuperacion().equals(palabraRecuperacion)
							&& usuario.getPreguntaRecuperacion().equals(preguntaRecuperacion)) {
						if (texto_contrasena.getText().equals(texto_confPass.getText())) {

							usuario = new Usuario();
							usuario.setPass(texto_confPass.getText());
							usuario.setNombreUsuario(nomUsuario);
							comprobar = true;

							cambiarContraTarget.request().put(Entity.entity(usuario, MediaType.APPLICATION_JSON));
							JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
							break;

						}
					}

				}
				if (comprobar) {
					VentanaLogin perfil = new VentanaLogin();
					perfil.frmLogin.setVisible(true);
					dispose();

				}

				if (!comprobar) {
					JOptionPane.showMessageDialog(null, "Datos erroneos", "Error", 0);
				}

			}
		});

	}
}