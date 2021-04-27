package com.SPQ.dataBase;


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
			Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","Buena zona",null,"Dua","¿Como se llama mi gato?", null);
			pm.makePersistent(usuario);
			Usuario usuario1=new Usuario("Aitora", "Davilaa" , "aidav13a", "passa123","aidav@gamail.com" , "68392848" ,"Callse Ave del Paraiso 9, Barcselona","Buensa zona",null,"Dusa","¿Comso se llama mi gato?", null);
			pm.makePersistent(usuario1);
			Usuario usuario2=new Usuario("Aitsor", "Davilaada" , "aidavsfa13", "pass1dsf23","aidav@fsgmail.com" , "68392833948" ,"Calle Ave del Pafaraiso 9, Barcafelona","Buena zfona",null,"Dua","¿Como se llamsa mi gato?", null);
			pm.makePersistent(usuario2);
			Usuario usuario3=new Usuario("Aitofr", "Davilfa" , "aidsfav13", "passfs123","aidav@gmail.com" , "68393948" ,"Calle Ave del Pfaaraiso 9, Barcelafona","Bsduena zona",null,"Dua","¿Como se llamsfa mi gato?", null);
			pm.makePersistent(usuario3);
			
			Anuncio anuncio=new Anuncio("Aitor", "Ofrdaezco servicio de fontaneria" ,60,"", Categoria.ALBAYIL,true, "peter");
			pm.makePersistent(anuncio);
			Anuncio anuncio1=new Anuncio("Aiadtor", "Ofrezco servicio de fontaneria" ,40,"", Categoria.ALBAYIL,false,"peter");
			pm.makePersistent(anuncio1);
			Anuncio anuncio2=new Anuncio("sitor", "Ofrezdco servicio de fontaneria" ,20,"", Categoria.ALBAYIL,true,"peter");
			pm.makePersistent(anuncio2);
			Anuncio anuncio3=new Anuncio("Aitoddr", "Ofrezco saaervicio de fontaneria" ,90,"", Categoria.ALBAYIL,true,"peter");
			pm.makePersistent(anuncio3);
			

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
   
   public void crearAnuncio(Anuncio anuncio) throws DBException{
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			pm.makePersistent(anuncio);

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
		
		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL","select * from usuario");
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
   
   public List<Anuncio> listarAnuncios() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","select * from anuncio");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
   
   public List<Anuncio> filtroOfertas() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","Select * FROM anuncio WHERE oferta = 'true'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
   
   	public List<AnuncioGuardado> listarAnunciosGuardados() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<AnuncioGuardado> query = pm.newQuery("javax.jdo.query.SQL","Select * FROM anuncioguardado");
		query.setClass(AnuncioGuardado.class);
		List<AnuncioGuardado> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
   	
   	public List<Anuncio> filtroCategoria(Categoria categoria) throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","select * from anuncio where categoria='" + categoria +"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
   	
	public List<Anuncio> filtroPrecioMayor() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","select * from anuncio order by precio desc");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	public List<Anuncio> filtroPrecioMenor() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","select * from anuncio order by precio asc");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	public List<Anuncio> misAnuncios(String nomUsuario) throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","SELECT * FROM anuncio where nombreusuario='"+nomUsuario+"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	public List<Anuncio> filtroUsuario(String nomUsuario) throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","SELECT * FROM anuncio where nombreusuario='"+ nomUsuario +"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();

		tx.commit();
		pm.close();
		return results;

	}
	
	 public void  updateAnuncio(Anuncio anuncio) throws DBException{
	 		
	 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	        tx.begin();
	 		
	 		Query query = pm.newQuery("javax.jdo.query.SQL", "UPDATE anuncio SET nombre='"+ anuncio.getNombre() +"', descripcion='"+anuncio.getDescripcion() +"', categoria='"+anuncio.getCategoria()+"',precio='"+anuncio.getPrecio()+ "'") ;
	 		query.setClass(Anuncio.class);
	 		Long update = (Long)query.execute();
	 		
	 		tx.commit();
	 		pm.close();
				 		
	 		
	 }
	 
	 public Anuncio seleccionarAnuncio(Anuncio anuncio) throws DBException{
	 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	 		tx.begin();
	 		
	 		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL", "SELECT * FROM anuncio where nombre='"+anuncio.getNombre()+"'");
	 		query.setClass(Anuncio.class);

	 		anuncio = query.executeUnique();
	 		
	 		tx.commit();
	 		pm.close();
	 		return anuncio;
	 		
	 	}
	 public void guardarAnuncio(Anuncio anuncio) throws DBException{
		 	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	 		tx.begin();
	 		
	 		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL", "INSERT INTO anuncioguardado VALUES ");
	 		query.setClass(Anuncio.class);

	 		anuncio = query.executeUnique();
	 		
	 		tx.commit();
	 		pm.close();
	 }
	 
	 public Anuncio eliminarAnuncio(Anuncio anuncio) throws DBException{
	 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	 		tx.begin();
	 		
	 		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL", "DELETE  FROM anuncio where nombre='"+anuncio.getNombre()+"'");
	 		query.setClass(Anuncio.class);
	 		Long delete = (Long)query.execute();
	 		
	 		tx.commit();
	 		pm.close();
	 		return anuncio;
	 		
	 	}
   
  
		
}