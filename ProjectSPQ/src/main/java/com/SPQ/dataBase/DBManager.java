package com.SPQ.dataBase;


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
		
}