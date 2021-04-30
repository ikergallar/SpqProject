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
import com.SPQ.clasesBasicas.AnuncioGuardado;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("serviciosGuardados")
public class ServicioGuardadoResources {
	
	@GET
	@Path("guardados")
	@Produces(MediaType.APPLICATION_JSON)
   	public List<AnuncioGuardado> listarAnunciosGuardados(){
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
	
	
	 @POST
	 @Path("comprar")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void guardarAnuncio(Anuncio anuncio){
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

}
