package com.SPQ.resource;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.AnuncioGuardado;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.dataBase.DBException;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("servicios")
public class ServicioResources {
	
	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
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
	
	@GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("guardados")
	@Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("ofertas")
	@Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("categoria")
	@Produces(MediaType.APPLICATION_JSON)
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
   	
	@GET
	@Path("caro")
	@Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("barato")
	@Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("misservicios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> misAnuncios(int IdUsuario) throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","SELECT * FROM anuncio where idusuario='"+IdUsuario+"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	@GET
	@Path("usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> filtroUsuario(Usuario usuario) throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","SELECT * FROM anuncio where idusuario='"+ usuario.getIdUsuario() +"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();

		tx.commit();
		pm.close();
		return results;

	}
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	 public void  updateAnuncio(Anuncio anuncio) throws DBException{
	 		
	 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	        tx.begin();
	 		
	 		Query query = pm.newQuery("javax.jdo.query.SQL", "UPDATE anuncio SET nombre='"+ anuncio.getNombre() +"', descripcion='"+anuncio.getDescripcion() +"', categoria='"+anuncio.getCategoria()+"',precio='"+anuncio.getPrecio()+ "' WHERE idanuncio ='"+ anuncio.getIdAnuncio() + "'") ;
	 		query.setClass(Anuncio.class);
	 		Long update = (Long)query.execute();
	 		
	 		tx.commit();
	 		pm.close();
				 		
	 		
	 }
	 
	 @GET
	 @Path("servicio")
	 @Produces(MediaType.APPLICATION_JSON)
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
	 
	 @POST
	 @Path("comprar")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void guardarAnuncio(Anuncio anuncio) throws DBException{
		 	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	 		tx.begin();
	 		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	 		Date date = new Date(0);
	 		
	 		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL", "INSERT INTO anuncioguardado(fecha, nombre) VALUES ('"+ dateFormat.format(date) +"','"+anuncio.getNombre()+"')");
	 		query.setClass(Anuncio.class);

	 		Long delete = (Long)query.execute();
	 		
	 		tx.commit();
	 		pm.close();
	 }
	 
	 @DELETE
	 @Path("eliminar")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Anuncio eliminarAnuncio(Anuncio anuncio) throws DBException{
	 		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	 		PersistenceManager pm = pmf.getPersistenceManager();
	 		Transaction tx = pm.currentTransaction();
	 		
	 		tx.begin();
	 		
	 		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL", "DELETE  FROM anuncio where idanuncio='"+anuncio.getIdAnuncio()+ "'");
	 		query.setClass(Anuncio.class);
	 		Long delete = (Long)query.execute();
	 		
	 		tx.commit();
	 		pm.close();
	 		return anuncio;
	 		
	 	}
   

}
