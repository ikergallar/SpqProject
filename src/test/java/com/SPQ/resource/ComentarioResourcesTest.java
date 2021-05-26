package com.SPQ.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.swing.DefaultListModel;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.PerfTest;

import com.SPQ.categories.IntegrationTest;
import com.SPQ.clasesBasicas.Comentario;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.main.Main;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

@Category(IntegrationTest.class)
public class ComentarioResourcesTest {

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	private HttpServer server;
	private WebTarget appTarget;
	private WebTarget comentarioTarget;
	private Client c;
	private Comentario c1;

	@Before
	public void setUp() throws Exception {

		server = Main.startServer();
		// create the client
		c = ClientBuilder.newClient();

		appTarget = c.target(Main.BASE_URI);
		comentarioTarget = appTarget.path("comentarios");

		c1 = new Comentario("Buen servicio", 4, "aidav13" , "12/05/2021 12:00:22");
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	@PerfTest(invocations = 1000, threads = 40)
	public void testCrearComentario() {

		WebTarget crearTarget = comentarioTarget.path("crear");
		crearTarget.request().post(Entity.entity(c1, MediaType.APPLICATION_JSON));

		WebTarget seleccionarTarget = comentarioTarget.path("comentario").queryParam("nombreusuario", "aidav13");
		GenericType<Comentario> genericType = new GenericType<Comentario>() {
		};
		Comentario comentario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		assertEquals(c1.getNombreUsuario(), comentario.getNombreUsuario());
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 40)
	public void testListarComentarios() {

		WebTarget listaComentariosTarget = comentarioTarget.path("listaComentarios");

		GenericType<List<Comentario>> genericType = new GenericType<List<Comentario>>() {
		};
		List<Comentario> comentarios = listaComentariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		assertEquals("aidav13", comentarios.get(0).getNombreUsuario());
	
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 40)
	public void testSeleccionarComentario() {

		WebTarget seleccionarTarget = comentarioTarget.path("comentario").queryParam("nombreusuario", "aidav13");

		GenericType<Comentario> genericType = new GenericType<Comentario>() {
		};
		Comentario comentario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		assertEquals("ramona", comentario.getNombreUsuario());
	}

	
}

