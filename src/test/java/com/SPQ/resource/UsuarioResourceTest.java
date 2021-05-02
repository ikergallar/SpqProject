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

	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	private HttpServer server;
    private WebTarget appTarget;
    private WebTarget usuarioTarget;
    private Client c;
	private Usuario u1;
   
    @Before
    public void setUp() throws Exception {
    	
    	server = Main.startServer();
        // create the client
        c = ClientBuilder.newClient();

        appTarget = c.target(Main.BASE_URI);
    	usuarioTarget = appTarget.path("usuarios");
    	
    	u1 = new  Usuario("Jose", "fer" , "ramona", "pass123","pedro@gmail.com" , "6839283948" ,"Calle koparta","","Kos	","¿Como se llama mi gato?");
    }
    
    @After
    public void tearDown() throws Exception {
        server.stop();
    }  
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testRegistrarUsuario() {
    	  
    	WebTarget registrarTarget = usuarioTarget.path("registro");
    	registrarTarget.request().post(Entity.entity(u1, MediaType.APPLICATION_JSON));
    			   			
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "ramona");			
        GenericType<Usuario> genericType = new GenericType<Usuario>() {};
        Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    	
        assertEquals(u1.getNombreUsuario(), usuario.getNombreUsuario());
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testListarUsuarios() {
    	    	
    	WebTarget listaUsuariosTarget = usuarioTarget.path("listaUsuarios");
    			   			
    	GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
    	List<Usuario> usuarios = listaUsuariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    	
        assertEquals("aidav13", usuarios.get(0).getNombreUsuario());
        assertEquals("aidav13a", usuarios.get(1).getNombreUsuario());
        assertEquals("aidavsfa13", usuarios.get(2).getNombreUsuario());
        assertEquals("aidsfav13", usuarios.get(3).getNombreUsuario());
        assertEquals("ramona", usuarios.get(4).getNombreUsuario());

   }
   
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testSeleccionarUsuario() {
    	    	
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "ramona");
    			   			
    	GenericType<Usuario> genericType = new GenericType<Usuario>() {};
    	Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);   	
    	
        assertEquals("ramona", usuario.getNombreUsuario());
    }  
   
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testCambiarContrasenya() {
    	u1.setPass("123");
    	WebTarget updateTarget = usuarioTarget.path("contra");
    	
    	updateTarget.request().put(Entity.entity(u1, MediaType.APPLICATION_JSON));
    	
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "ramona");			
        GenericType<Usuario> genericType = new GenericType<Usuario>() {};
        Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType); 
        
        assertEquals(u1.getPass(),usuario.getPass());
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testUpdateUsuario() {
    			
    	u1.setNombre("Morena");
    	u1.setApellido("Jorge");
    	u1.setTelefono("699222822");
    	u1.setDireccion("Calle la pantomima");
    	u1.setMail("mail@Email.com");
    	
    	WebTarget updateTarget = usuarioTarget.path("update");
    	
    	updateTarget.request().put(Entity.entity(u1, MediaType.APPLICATION_JSON));
    	
    	WebTarget seleccionarTarget = usuarioTarget.path("user").queryParam("nombreusuario", "ramona");			
        GenericType<Usuario> genericType = new GenericType<Usuario>() {};
        Usuario usuario = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType); 
        
        assertEquals(u1.getNombre(),usuario.getNombre());
        assertEquals(u1.getApellido(),usuario.getApellido());
        assertEquals(u1.getTelefono(),usuario.getTelefono());
        assertEquals(u1.getDireccion(),usuario.getDireccion());
        assertEquals(u1.getMail(),usuario.getMail());
    }   
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testFiltrarUsuario() {
    	
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testExisteUsuario() {
    	
    }
    
    
}