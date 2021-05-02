package com.SPQ.resource;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.PerfTest;

import com.SPQ.categories.IntegrationTest;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.main.Main;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

@Category(IntegrationTest.class)
public class UsuarioResourceTest {
	private Usuario u1;
	private Usuario u2;

	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	private HttpServer server;
    private WebTarget appTarget;
    private Client c;
    
    @Before
    public void setUp() throws Exception {
    	
    	u1 = new  Usuario("Aitor", "Davila" , "aidav13", "pass123","aidav@gmail.com" , "6839283948" ,"Calle Ave del Paraiso 9, Barcelona","","Dua","¿Como se llama mi gato?");
		u2 = new  Usuario("Jose", "fernan" , "ramona", "passa123","polaoa@gmail.com" , "6245525255" ,"Callse Ave del Paraiso 9, Barcselona","","Dusa","¿Comso se llama mi gato?");

    	server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        appTarget = c.target(Main.BASE_URI);
    }
    
    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testListarUsuarios() {
    	    	
    	WebTarget usuarioTarget = appTarget.path("usuarios");
    	WebTarget listaUsuariosTarget = usuarioTarget.path("listaUsuarios");
    	
    	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    	listaUsuarios.add(u1);
    	listaUsuarios.add(u2);
    			   			
    	GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
    	List<Usuario> usuarios = listaUsuariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    	
        assertEquals("aidav13", usuarios.get(0).getNombreUsuario());
        assertEquals("ramona", usuarios.get(1).getNombreUsuario());
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testRegistrarUsuario() {
    	  
    	WebTarget usuarioTarget = appTarget.path("usuarios");
    	WebTarget registrarTarget = usuarioTarget.path("registro");
    	registrarTarget.request().post(Entity.entity(u1, MediaType.APPLICATION_JSON));
    			   			
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "aidav13");
    	GenericType<Usuario> genericType = new GenericType<Usuario>() {};
    	Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    	
        assertEquals("aidav13", usuario.getNombreUsuario());
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testExisteUsuario() {
    	
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testSeleccionarUsuario() {
    	    	
    	WebTarget usuarioTarget = appTarget.path("usuarios");
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "aidav13");
    			   			
    	GenericType<Usuario> genericType = new GenericType<Usuario>() {};
    	Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);   	
    	
        assertEquals(u1.getNombreUsuario(), usuario.getNombreUsuario());
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testUpdateUsuario() {
    	
    	u1.setDireccion("Calle la pantomima");
    	WebTarget usuarioTarget = appTarget.path("usuarios");
    	WebTarget updateTarget = usuarioTarget.path("update");
    	
    	updateTarget.request().put(Entity.entity(u1, MediaType.APPLICATION_JSON));
    	
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "aidav13");			
        GenericType<Usuario> genericType = new GenericType<Usuario>() {};
        Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType); 
        
       assertEquals(usuario.getDireccion(), "Calle la pantomima");
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testCambiarContrasenya() {
    	u1.setPass("123");
    	WebTarget usuarioTarget = appTarget.path("usuarios");
    	WebTarget updateTarget = usuarioTarget.path("contra");
    	
    	updateTarget.request().put(Entity.entity(u1, MediaType.APPLICATION_JSON));
    	
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "aidav13");			
        GenericType<Usuario> genericType = new GenericType<Usuario>() {};
        Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType); 
        
        assertEquals(usuario.getPass(), "123");
    }
    

}
