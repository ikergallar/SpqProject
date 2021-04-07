package com.SPQ.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.SPQ.dataBase.DBException;

public class DBManager {
private Connection conn = null; 

	//CREAR CONEXION CON BD

		public void connect() throws DBException { 
			try {
				Class.forName("com.mysql.JDBC.Driver");
				conn = DriverManager.getConnection("jdbc:mysql:data/usuarios");
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
}
