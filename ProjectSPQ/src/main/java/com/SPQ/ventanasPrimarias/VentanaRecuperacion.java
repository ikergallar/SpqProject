package com.SPQ.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;
import com.SPQ.dataBase.LogController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class VentanaRecuperacion extends JDialog {


	private JPanel contentPane;
	private JPasswordField texto_contrasena;
	private JPasswordField texto_confPass;
	private JTextField textNumero;
	private JTextField texto_usuario;
	private JTextField texto_direccion;
	private ButtonGroup sexo = new ButtonGroup();
	private JTextField textoRespuesta;
	private Usuario usuario;

	public static void main(String[] args) {
		
		LogController.log ( Level.INFO, "Recuperacion contraseña " + (new Date()),null);
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
                DBManager conexion = new DBManager();
                
                try {
                    conexion.connect();
                    
                    if (conexion.recuperarContrasenya(nomUsuario,palabraRecuperacion,preguntaRecuperacion) == true) {
                    	
                    	if(texto_contrasena.getText().equals(texto_confPass.getText())) {
							try {
							
								usuario = new Usuario();
								usuario.setPass(texto_confPass.getText());
								usuario.setNombreUsuario(nomUsuario);

								
								conexion.cambiarContrsenya(usuario);
								JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
								LogController.log ( Level.INFO, "Contraseña editada correctamente " + (new Date()),null);

							} catch (DBException e1) {
								e1.printStackTrace();
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", 0);
							LogController.log ( Level.WARNING, "Las contraseñas no coinciden " + (new Date()),null);
							texto_contrasena.setText("");
							texto_confPass.setText("");
						}
                    	
                    }else {
                        JOptionPane.showMessageDialog(null, "Datos erroneos", "Error", 0);
                		LogController.log ( Level.WARNING, "Datos erroneos " + (new Date()),null);
                    }	

                    conexion.disconnect();
                    

                } catch (DBException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

	
			}
		});
		
	}
	}