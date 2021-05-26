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
import com.SPQ.clasesBasicas.Comentario;
import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("comentarios")
public class ComentarioResources {

	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearComentario(Comentario comentario) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			pm.makePersistent(comentario);

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	@GET
	@Path("listaComentarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comentario> listarComentarios() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Comentario> query = pm.newQuery("javax.jdo.query.SQL", "select * from comentario");
		query.setClass(Comentario.class);
		List<Comentario> results = query.executeList();

		tx.commit();
		pm.close();
		return results;

	}
	
	@GET
	@Path("comentario")
	@Produces(MediaType.APPLICATION_JSON)
	public Comentario seleccionarComentario(@QueryParam("nombreUsuario") String nomUsuario) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Comentario> query = pm.newQuery("javax.jdo.query.SQL",
				"SELECT * FROM comentario where nombreUsuario='" + nomUsuario + "'");
		query.setClass(Comentario.class);

		Comentario comentario = query.executeUnique();

		tx.commit();
		pm.close();
		return comentario;

	}
}