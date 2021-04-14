package com.SPQ.dataBase;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.jdo.*;


import com.SPQ.clasesBasicas.*;
import com.mysql.cj.xdevapi.Statement;



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
   
 //LISTAR USUARIOS DE BD
	public List<Usuario> listarUsuarios() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL","select * from " + "usuario");
		query.setClass(Usuario.class);
		List<Usuario> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
 	public boolean existeUsuario(Usuario usuario) throws DBException{
 		
 		boolean existe = false;
 		List<Usuario> usuarios = listarUsuarios();
 		
 		for (Usuario user : usuarios) {
 			if (user.getNombreUsuario().equals(usuario.getNombreUsuario())) {
 				existe = true;
 			}
 		}

 		return existe;

 	}
 	
 	public Usuario seleccionarUsuario(String nombreUsuario) throws DBException{
 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
 		PersistenceManager pm = pmf.getPersistenceManager();
 		Transaction tx = pm.currentTransaction();
 		
 		tx.begin();
 		
 		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL", "SELECT * FROM usuario where nombreusuario='"+nombreUsuario+"'");
 		query.setClass(Usuario.class);

 		Usuario usuario = query.executeUnique();
 		
 		tx.commit();
 		pm.close();
 		return usuario;
 		
 	}
 
 	
 	public void  editarUsuario(Usuario usuario) throws DBException{
 		
 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
 		PersistenceManager pm = pmf.getPersistenceManager();
 		Transaction tx = pm.currentTransaction();
 		
 		try {
			tx.begin();
			
			pm.deletePersistent(usuario);

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
 		
        registrarUsuario(usuario);


 		
 		
 	}
 	
    public void  updateUsuario(Usuario usuario) throws DBException{
 		
 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
 		PersistenceManager pm = pmf.getPersistenceManager();
 		Transaction tx = pm.currentTransaction();
 		
        tx.begin();
 		
 		Query query = pm.newQuery("javax.jdo.query.SQL", "UPDATE usuario SET nombre='"+ usuario.getNombre() +"', apellido='"+usuario.getApellido() +"', telefono='"+usuario.getTelefono()+"',direccion='"+usuario.getDireccion()+ "', mail='"+usuario.getMail() + "' WHERE nombreusuario ='"+ usuario.getNombreUsuario() + "'") ;
 		query.setClass(Usuario.class);
 		Long update = (Long)query.execute();
 		
 		tx.commit();
 		pm.close();
			 		
 		
 	}
    
   public void  cambiarContrasenya(Usuario usuario) throws DBException{
 		
 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
 		PersistenceManager pm = pmf.getPersistenceManager();
 		Transaction tx = pm.currentTransaction();
 		
        tx.begin();
 		
 		Query query = pm.newQuery("javax.jdo.query.SQL", "UPDATE usuario SET pass='"+ usuario.getPass() +"' WHERE nombreusuario = '" + usuario.getNombreUsuario() +"'") ;
 		query.setClass(Usuario.class);
 		Long update = (Long)query.execute();
 		
 		tx.commit();
 		pm.close();
			
 	}
 	

 	

		
}