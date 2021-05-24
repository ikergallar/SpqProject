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
	@Path("comprar")
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
	public Anuncio seleccionarAnuncioGuardado(@QueryParam("nombre") String nombre) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<AnuncioGuardado> query = pm.newQuery("javax.jdo.query.SQL",
				"SELECT * FROM anuncioguardado where nombre='" + nombre + "'");
		query.setClass(AnuncioGuardado.class);

		AnuncioGuardado anuncio = query.executeUnique();

		tx.commit();
		pm.close();
		return anuncio;

	}

}
