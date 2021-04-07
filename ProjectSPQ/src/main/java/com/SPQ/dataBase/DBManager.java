package com.SPQ.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import com.SPQ.dataBase.DBException;

import com.SPQ.clasesBasicas.*;

public class DBManager {
private Connection conn = null; 

	//CREAR CONEXION CON BD

		public void connect() throws DBException { 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/database","root","");
			} catch (ClassNotFoundException e) {
				throw new DBException("Error cargando el driver de la BD", e);
			} catch (SQLException e) {
				throw new DBException("Error conectando a la BD", e);
			}
		}
		
		//CERRAR CONEXION CON BD
		public void disconnect() throws DBException {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
			}
		}
		
		//REGISTRAR NUEVO USUARIO
		public void registrarUsuario(Usuario usuario) throws DBException{
			
			String nombre = usuario.getNombre();
			String apellido = usuario.getApellido();
			String nombreUsuario = usuario.getNombreUsuario();
			String contrasena = usuario.getPass();
			String email= usuario.getMail();
			
			
			try (Statement s= conn.createStatement()) {
				//Añadimos en la base de datos los campos de infomacion introducidos en la ventana(recibido como objeto de la clase usuario)
				s.executeUpdate("INSERT INTO usuarios (username, email, contrasenya, nombre, apellido) VALUES ('" + nombreUsuario + "', '"+ email + "', '" + contrasena + "', '" + nombre + "', '"+ apellido +"')");
			} catch (SQLException e) {
				throw new DBException("No ha sido posible ejecutar la query");
			}
			
		}
		
		//LOGIN
		//LOGIN
	    public boolean loginUsuario (String nomUsuario, String contrasena) throws DBException{
	        boolean acceso = false;
	        try (PreparedStatement stmt = conn.prepareStatement("SELECT username,contrasenya FROM usuarios WHERE username = ?  AND contrasenya = ?;")) {
	                stmt.setString(1, nomUsuario);
	                stmt.setString(2, contrasena);

	                ResultSet rs = stmt.executeQuery();

	                if (rs.next()) {
	                    acceso = true;
	                }else {
	                    acceso = false;
	                }

	            } catch (SQLException e) {
	                throw new DBException("Error obteniendo datos de la query", e);
	            }


	        return acceso;
	    }

		
		
}
