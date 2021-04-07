package com.SPQ.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCorreo;
	JRadioButton rdbtnFacebook;
	JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaRegistro dialog = new VentanaRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaRegistro() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Registro");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBackground(Color.WHITE);
			lblCorreo.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblCorreo);
		}
		{
			tfCorreo = new JTextField();
			contentPanel.add(tfCorreo);
			tfCorreo.setColumns(30);
		}
		{
			JLabel lblSisAuto = new JLabel("Sistema de autorizaci\u00F3n:");
			lblSisAuto.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblSisAuto);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			rdbtnFacebook = new JRadioButton("Facebook");
			rdbtnFacebook.setBackground(Color.WHITE);
			contentPanel.add(panel);
			{

				rdbtnFacebook.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
				panel.add(rdbtnFacebook);
			}
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label);
		}
		{
			lblError = new JLabel("*debes rellenar todos los campos");
			lblError.setVisible(false);
			lblError.setHorizontalAlignment(SwingConstants.RIGHT);
			lblError.setForeground(Color.RED);
			lblError.setFont(new Font("Malgun Gothic", Font.BOLD, 10));
			contentPanel.add(lblError);
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if (rdbtnFacebook.isSelected() && tfCorreo.getText().length() >= 10) {
							JOptionPane.showMessageDialog(null, "Registro completado.", "", 1);
							lblError.setVisible(false);
							String correo = tfCorreo.getText();
							System.out.println(correo);
							System.out.println(rdbtnFacebook.getText());
							setVisible(false);
						} else {
							lblError.setVisible(true);
						}
					}
				});
				okButton.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
