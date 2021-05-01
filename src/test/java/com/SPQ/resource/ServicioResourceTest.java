package com.SPQ.resource;

import static org.junit.Assert.assertEquals;

import java.awt.List;
import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;

import javax.swing.JList;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.SPQ.categories.IntegrationTest;
import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.main.Main;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;

@Category(IntegrationTest.class)
public class ServicioResourceTest {
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	private HttpServer server;
    private WebTarget appTarget;
    private Client c;
    
    @Before
    public void setUp() throws Exception {
    	
    	server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        appTarget = c.target(Main.BASE_URI);

    }
    		

	
    
    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    
//    @Test
//    @PerfTest(invocations = 1000, threads = 40)
//    public void testSeleccionarAnuncio() {
//    	
//    	Usuario usuario = new  Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
//    	Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//
//    	WebTarget servicioTarget = appTarget.path("servicios");
//    	WebTarget seleccionarTarget = servicioTarget.path("servicio").queryParam("Ofrezco servicio de fontaneria");
//    			   			
//    	GenericType<Anuncio> genericType = new GenericType<Anuncio>() {};
//    	Usuario anuncio2 = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);   	
//    	
//        assertEquals(anuncio.getNombre(), anuncio2.getNombre());
//    }
    
//    @Test
//    @PerfTest(invocations = 1000, threads = 40)
//    public void testCrearAnuncio() {
//    	
//        Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
//		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//		
//    	WebTarget servicioTarget = appTarget.path("servicios");
//    	WebTarget listaUsuariosTarget = servicioTarget.path("crear");
//    	servicioTarget.request().post(Entity.entity(anuncio, MediaType.APPLICATION_JSON));
//    			   			
//    	WebTarget crearAnuncioTarget = usuarioTarget.path("listaUsuarios");
//    	GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
//    	List<Usuario> usuarios = listaUsuariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//    	
//    	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
//    	listaUsuarios.add(u1);
//    	
//        assertEquals(listaUsuarios.get(0).getNombreUsuario(), usuarios.get(4).getNombreUsuario());
//    }
    
//	  @Test
//	  @PerfTest(invocations = 1000, threads = 40)
//	  public void testListarAnuncios() {
//	  	
//	  	Usuario usuario = new  Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
//	  	Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//	  	Anuncio anuncio2= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//	  	
//	  	WebTarget servicioTarget = appTarget.path("servicios");
//	  	WebTarget listaAnunciosTarget = servicioTarget.path("listaAnuncios");
//	  	
//	  	List<Anuncio> listaAnuncios = new List<Anuncio>();
//	  	listaAnuncios.add(anuncio);
//	  	listaAnuncios.add(anuncio2);
//	  			   			
//	  	GenericType<List<Anuncio>> genericType = new GenericType<List<Anuncio>>() {};
//	  	List<Anuncio> anuncios = listaAnunciosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//	  	
//	    assertEquals(listaAnuncios.get(0).getNombre(), anuncios.get(0).getNombre());
//	    assertEquals(listaAnuncios.get(1).getNombre(), anuncios.get(1).getNombre());
//	  }
//    
//    @Test
//    @PerfTest(invocations = 1000, threads = 40)
//    public void testUpdateAnuncio() {
//    	
//    	Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
//		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//	
//    	
//    	WebTarget servicioTarget = appTarget.path("servicios");
//    	WebTarget updateTarget = servicioTarget.path("update");
//    			   			
//    	GenericType<Anuncio> genericType = new GenericType<Anuncio>() {};
//    	Anuncio anuncio2 = updateTarget.request(MediaType.APPLICATION_JSON).get(genericType);   	
//    	
//        assertEquals(anuncio.getNombre(), anuncio2.getNombre());
//    }
    
    

}
