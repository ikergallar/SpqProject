package com.SPQ.dataBase;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String palabraRecuperacion = usuario.getPalabraRecuperacion();
			String preguntaRecuperacion = usuario.getPreguntaRecuperacion();
			
			
			try (Statement s= conn.createStatement()) {
				//Añadimos en la base de datos los campos de infomacion introducidos en la ventana(recibido como objeto de la clase usuarios)
				s.executeUpdate("INSERT INTO usuarios (username, email, contrasenya, nombre, apellido, palabraRecuperacion, preguntaRecuperacion) VALUES ('" + nombreUsuario + "', '"+ email + "', '" + contrasena + "', '" + nombre + "', '"+ apellido + "', '" + palabraRecuperacion + "', '" + preguntaRecuperacion +"')");
			} catch (SQLException e) {
				throw new DBException("No ha sido posible ejecutar la query");
			}
			
		}
		
	
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
	    
	    
		//CAMBIAR CONTRASENYA 
	    
		public void cambiarContrsenya (Usuario user) throws DBException{
				String sentSQL = "UPDATE usuarios SET contrasenya='"+ user.getPass() +"' WHERE username = '" + user.getNombreUsuario() +"';" ;
				try{
					Statement st = conn.createStatement();
					st.executeUpdate(sentSQL);
					st.close();
					
					
				}catch (SQLException e) {
					throw new DBException("No ha sido posible cambiar la contraseña");
				}
		}
		
		//BUSCAR USUARIO POR LA ID
		public Usuario buscarUsuarioId(int id) throws DBException {
			try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo, nombre, apellidos, ubicacion, direccionIP FROM usuarios WHERE id = ?")) {
				stmt.setInt(1, id);
				
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setUsuario(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setNombreUsuario(rs.getString("nomUsuario"));
					usuario.setPass(rs.getString("contraseña"));
					usuario.setMail(rs.getString("correo"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setDescripcion(rs.getString("descripcion"));
					return usuario;
					
				} else {
					return new Usuario();
				}
			} catch (SQLException e) {
				throw new DBException("Error obteniendo el usuario con id " + id, e);
			}
		}
		
		public Usuario seleccionarDatos(String nombreUsuario) throws DBException {
			String sentSQL = "SELECT * FROM usuarios WHERE username ='"+ nombreUsuario + "';";
			try{
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);

				Usuario usuario = new Usuario();
				while(rs.next()) {
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setTelefono(rs.getString("telefono"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setNombreUsuario(rs.getString("username"));
					usuario.setPass(rs.getString("contrasenya"));
					usuario.setMail(rs.getString("email"));
				}
				rs.close();
				st.close();
				return usuario;
					
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo el usuario", e);
			}
		}
		
		public void cambiarDatos(Usuario usuario) throws DBException {
			String sentSQL = "UPDATE usuarios SET nombre='"+ usuario.getNombre() +"', apellido='"+usuario.getApellido() +"', telefono='"+usuario.getTelefono()+"',direccion='"+usuario.getDireccion()+ "', email='"+usuario.getMail() + "' WHERE username ='"+ usuario.getNombreUsuario() + "'" ;
			try{
				Statement st = conn.createStatement();
				st.executeUpdate(sentSQL);
				st.close();
				
				
			}catch (SQLException e) {
				throw new DBException("No ha sido posible cambiar los datos de la BD");
			}
			
		}

		public boolean existeUsuario(String username) throws DBException {
			String sentSQL = "SELECT * FROM usuarios WHERE username='"+username+"'";
			boolean existe = false;
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);
				if(rs.next())
					existe = true;
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DBException("No se ha podido acceder a la tabla usuarios");
			}
			return existe;
		}
		
		public boolean comprobarContrasenya(Usuario usuario) throws DBException{
			String sentSQL = "SELECT * FROM usuarios WHERE username='"+ usuario.getNombreUsuario() +"' AND contrasenya='" +usuario.getPass()+"';";
			boolean coincide = false;
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);
				if(rs.next())
					coincide = true;
				rs.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DBException("No se ha podido acceder a la tabla usuarios");
			}
			
			return coincide;	
		}
		public boolean recuperarContrasenya (String nomUsuario, String palabraRecuperacion, String preguntaRecuperacion) throws DBException{
            boolean acceso = false;
            try (PreparedStatement stmt = conn.prepareStatement("SELECT username, palabraRecuperacion, preguntaRecuperacion FROM usuarios WHERE username = ? AND palabraRecuperacion = ? AND preguntaRecuperacion = ?;")) {
                    stmt.setString(1, nomUsuario);
                    stmt.setString(2, palabraRecuperacion);
                    stmt.setString(3, preguntaRecuperacion);

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
