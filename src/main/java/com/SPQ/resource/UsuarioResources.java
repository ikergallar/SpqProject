package com.SPQ.resource;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.SPQ.clasesBasicas.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("usuarios")
public class UsuarioResources {

	@GET
	@Path("listaUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Usuario> listarUsuarios() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL", "select * from usuario");
		query.setClass(Usuario.class);
		List<Usuario> results = query.executeList();

		tx.commit();
		pm.close();
		return results;

	}

	@POST
	@Path("registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrarUsuario(Usuario usuario) {

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

	@GET
	@Path("existeUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public static boolean existeUsuario(Usuario usuario) {

		boolean existe = false;
		List<Usuario> usuarios = listarUsuarios();

		for (Usuario user : usuarios) {
			if (user.getNombreUsuario().equals(usuario.getNombreUsuario())) {
				existe = true;
			}
		}

		return existe;

	}

	@GET
	@Path("user")
	@Produces(MediaType.APPLICATION_JSON)
	public static Usuario seleccionarUsuario(@QueryParam("nombreusuario") String nombreUsuario) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL",
				"SELECT * FROM usuario where nombreusuario='" + nombreUsuario + "'");
		query.setClass(Usuario.class);

		Usuario usuario = query.executeUnique();

		tx.commit();
		pm.close();
		return usuario;

	}

	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUsuario(Usuario usuario) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query query = pm.newQuery("javax.jdo.query.SQL",
				"UPDATE usuario SET nombre='" + usuario.getNombre() + "', apellido='" + usuario.getApellido()
						+ "', telefono='" + usuario.getTelefono() + "',direccion='" + usuario.getDireccion()
						+ "', mail='" + usuario.getMail() + "' WHERE nombreusuario ='" + usuario.getNombreUsuario()
						+ "'");
		query.setClass(Usuario.class);
		Long update = (Long) query.execute();

		tx.commit();
		pm.close();

	}

	@PUT
	@Path("contra")
	@Produces(MediaType.APPLICATION_JSON)
	public void cambiarContrasenya(Usuario usuario) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query query = pm.newQuery("javax.jdo.query.SQL", "UPDATE usuario SET pass='" + usuario.getPass()
				+ "' WHERE nombreusuario = '" + usuario.getNombreUsuario() + "'");
		query.setClass(Usuario.class);
		Long update = (Long) query.execute();

		tx.commit();
		pm.close();

	}
	
}
