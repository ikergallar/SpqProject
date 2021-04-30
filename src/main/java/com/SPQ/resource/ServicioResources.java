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


import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("servicios")
public class ServicioResources {
	
	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
    public void crearAnuncio(Anuncio anuncio){
		
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
    @Path("listaServicios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> listarAnuncios(){
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
	@Path("ofertas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> filtroOfertas(){
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","Select * FROM anuncio WHERE oferta = '1'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	@GET
	@Path("categoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> filtroCategoria(@QueryParam("categoria") String categoria){
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
	public List<Anuncio> filtroPrecioMayor(){
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
	public List<Anuncio> filtroPrecioMenor(){
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
	@Path("misServicios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> misAnuncios(@QueryParam("idusuario") int idUsuario){
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","SELECT * FROM anuncio where idusuario='"+ idUsuario +"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	@GET
	@Path("usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> filtroUsuario(@QueryParam("idusuario") int idUsuario){
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Anuncio> query = pm.newQuery("javax.jdo.query.SQL","SELECT * FROM anuncio where idusuario='"+ idUsuario +"'");
		query.setClass(Anuncio.class);
		List<Anuncio> results = query.executeList();

		tx.commit();
		pm.close();
		return results;

	}
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	 public void  updateAnuncio(Anuncio anuncio){
	 		
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
	 public Anuncio seleccionarAnuncio(Anuncio anuncio){
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
	 	 
	 
	 @DELETE
	 @Path("eliminar")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Anuncio eliminarAnuncio(Anuncio anuncio){
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
