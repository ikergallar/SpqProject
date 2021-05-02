package com.SPQ.resource;

import static org.junit.Assert.assertEquals;


import java.util.List;
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
import jakarta.ws.rs.core.MediaType;

@Category(IntegrationTest.class)
public class ServicioResourceTest {
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	private HttpServer server;
    private WebTarget appTarget;
    private Client c;
    private WebTarget anuncioTarget;
    private Anuncio a1;
    
    @Before
    public void setUp() throws Exception {
    	
    	server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        appTarget = c.target(Main.BASE_URI);
        anuncioTarget = appTarget.path("anuncios");

    }
    		

	
    
    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testSeleccionarAnuncio() {
    	
    	Usuario usuario = new  Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","�Como se llama mi gato?");
    	Anuncio anuncio= new Anuncio("asasas", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());

    	WebTarget servicioTarget = appTarget.path("servicios");
    	WebTarget seleccionarTarget = servicioTarget.path("servicio").queryParam("nombre","asasas");
    			   			
    	GenericType<Anuncio> genericType = new GenericType<Anuncio>() {};
    	Anuncio anuncio2 = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);   	
    	
        assertEquals("asasas", anuncio2.getNombre());
    }
    
//    @Test
//    @PerfTest(invocations = 1000, threads = 40)
//    public void testCrearAnuncio() {
//    	
//        Usuario usuario=new Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","�Como se llama mi gato?");
//		Anuncio anuncio= new Anuncio("Aitor", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//		
//    	WebTarget servicioTarget = appTarget.path("servicios");
//    	WebTarget listaUsuariosTarget = servicioTarget.path("crear");
//    	servicioTarget.request().post(Entity.entity(anuncio, MediaType.APPLICATION_JSON));
//    			   			
//    	WebTarget crearAnuncioTarget = servicioTarget.path("listaUsuarios");
//    	GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
//    	List<Usuario> usuarios = listaUsuariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//    	
//    	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
//    	listaUsuarios.add(usuario);
//    	
//        assertEquals(listaUsuarios.get(0).getNombreUsuario(), usuarios.get(4).getNombreUsuario());
//    }
    
//	  @Test
//	  @PerfTest(invocations = 1000, threads = 40)
//	  public void testListarAnuncios() {
//	  	
//	  	Usuario usuario = new  Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","�Como se llama mi gato?");
//	  	Anuncio anuncio= new Anuncio("asasas", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//	  	Anuncio anuncio2= new Anuncio("asasas", "Ofrezco servicio de fontaneria" ,60,"", Categoria.FONTANERO,true, usuario.getIdUsuario());
//	  	
//	  	WebTarget servicioTarget = appTarget.path("servicios");
//	  	WebTarget listaAnunciosTarget = servicioTarget.path("listaServicios");
//	  	
//	  	List<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
//	  	listaAnuncios.add(anuncio);
//	  	listaAnuncios.add(anuncio2);
//	  			   			
//	  	GenericType<List<Anuncio>> genericType = new GenericType<List<Anuncio>>() {};
//	  	List<Anuncio> anuncios = listaAnunciosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//	  	
//	    assertEquals("asasas", anuncios.get(0).getNombre());
//	    assertEquals("asasas", anuncios.get(1).getNombre());
//	  }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testUpdateAnuncio() {
    	
    	Anuncio a1 = new Anuncio();
    	a1.setNombre("asasas");
    	WebTarget servicioTarget = appTarget.path("servicios");
    	WebTarget updateTarget = servicioTarget.path("update");
    	
    	updateTarget.request().put(Entity.entity(a1, MediaType.APPLICATION_JSON));
    	
    	WebTarget seleccionarTarget = servicioTarget.path("servicio").queryParam("nombre", "asasas");			
        GenericType<Anuncio> genericType = new GenericType<Anuncio>() {};
        Anuncio anuncio = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType); 
        
       assertEquals("asasas",anuncio.getNombre());
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testCrearAnuncio() {
    	  
    	WebTarget crearTarget = anuncioTarget.path("servicios");
    	crearTarget.request().post(Entity.entity(a1, MediaType.APPLICATION_JSON));
    			   			
    	WebTarget seleccionarTarget = anuncioTarget.path("crear").queryParam("nombre", "johnny");			
        GenericType<Anuncio> genericType = new GenericType<Anuncio>() {};
        Anuncio anuncio = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    	
        assertEquals(a1.getNombre(), anuncio.getNombre());
    }
    
    

}
