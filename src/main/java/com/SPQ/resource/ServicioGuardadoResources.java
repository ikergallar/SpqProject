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
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("serviciosGuardados")
public class ServicioGuardadoResources {

	@GET
	@Path("guardados")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AnuncioGuardado> listarAnunciosGuardados() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<AnuncioGuardado> query = pm.newQuery("javax.jdo.query.SQL", "Select * FROM anuncioguardado");
		query.setClass(AnuncioGuardado.class);
		List<AnuncioGuardado> results = query.executeList();

		tx.commit();
		pm.close();
		return results;

	}

	@POST
	@Path("contratar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarAnuncio(AnuncioGuardado anuncio) {
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
	@Path("servicio")
	@Produces(MediaType.APPLICATION_JSON)
	public AnuncioGuardado seleccionarAnuncioGuardado(@QueryParam("idAnuncio") int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<AnuncioGuardado> query = pm.newQuery("javax.jdo.query.SQL",
				"SELECT * FROM anuncioguardado where idAnuncio='" + id + "'");
		query.setClass(AnuncioGuardado.class);

		AnuncioGuardado anuncio = query.executeUnique();

		tx.commit();
		pm.close();
		return anuncio;

	}
	
	@PUT
	@Path("report")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateAnuncio(AnuncioGuardado anuncio) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query query = pm.newQuery("javax.jdo.query.SQL",
				"UPDATE anuncioGuardado SET reportes='" + anuncio.getReportes()	+ "' WHERE idanuncio ='" + anuncio.getIdAnuncio() + "'");
		query.setClass(Anuncio.class);
		Long update = (Long) query.execute();

		tx.commit();
		pm.close();

	}

}
