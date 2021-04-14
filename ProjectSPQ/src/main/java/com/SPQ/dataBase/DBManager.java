package com.SPQ.dataBase;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.jdo.*;


import com.SPQ.clasesBasicas.*;



public class DBManager {
	private static DBManager instance = null;
    private PersistenceManagerFactory pmf = null;
    private PersistenceManager pm = null;
    private Transaction tx = null;

    public DBManager() {
        pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        
    }

    public static DBManager getInstance() throws DBException {
        if (instance == null) {
            instance = new DBManager();
            instance.initializeData();
        }

        return instance;
    }

   public void initializeData () throws DBException{
		
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		
		try {
			tx.begin();
			Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona","",null,"Dua","¿Como se llama mi gato?");
			pm.makePersistent(usuario);
			

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
   
   public void registrarUsuario(Usuario usuario) throws DBException{
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			pm.makePersistent(usuario);

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
   }
   
   public Boolean validarUsuario(Usuario usuarioPendiente) {
	   PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	   PersistenceManager pm = pmf.getPersistenceManager();
	   Transaction tx = pm.currentTransaction();
       Boolean retornar = null;
       String consulta = "SELECT u FROM Usuario u WHERE u.nombre = :pNombre AND u.password = :pPassword AND u.habilitado = 1";
       Query qConsulta = pm.newQuery(consulta, Usuario.class);
       qConsulta.setParameters("pNombre", usuarioPendiente.getNombre());
       qConsulta.setParameters("pPassword", usuarioPendiente.getPass());
       if (qConsulta.) {
           retornar = Boolean.FALSE;
       } else {
           retornar = Boolean.TRUE;
       }
       return retornar;
   }
   
//   public boolean loginUsuario (String nomUsuario, String contrasena) throws DBException{
//       boolean acceso = false;
//       try (PreparedStatement stmt = conn.prepareStatement("SELECT username,contrasenya FROM usuarios WHERE username = ?  AND contrasenya = ?;")) {
//               stmt.setString(1, nomUsuario);
//               stmt.setString(2, contrasena);
//
//               ResultSet rs = stmt.executeQuery();
//
//               if (rs.next()) {
//                   acceso = true;
//               }else {
//                   acceso = false;
//               }
//
//           } catch (SQLException e) {
//               throw new DBException("Error obteniendo datos de la query", e);
//           }
//
//
//       return acceso;
//   }

		
}