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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 725, 555);
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
			JLabel lblSisAuto = new JLabel("Nombre de usuario:");
			lblSisAuto.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblSisAuto);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Contraseña:");
			lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Confirmar contraseña:");
			lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Apellido:");
			lblNewLabel_3.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
			contentPanel.add(lblNewLabel_3);
		}
		{
			textField_4 = new JTextField();
			contentPanel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
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
