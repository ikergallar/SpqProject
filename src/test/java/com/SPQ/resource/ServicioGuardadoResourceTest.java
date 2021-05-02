package com.SPQ.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
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
import com.SPQ.clasesBasicas.AnuncioGuardado;
import com.SPQ.clasesBasicas.Usuario;
import com.SPQ.main.Main;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;



import jakarta.ws.rs.core.MediaType;

@Category(IntegrationTest.class)
public class ServicioGuardadoResourceTest {
	
	private AnuncioGuardado a1;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	String fecha = "20-11-1999";
	GregorianCalendar gc = new GregorianCalendar();
	

	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	private HttpServer server;
    private WebTarget appTarget;
    private Client c;
    
    @Before
    public void setUp() throws Exception {
    	Date date = sdf.parse(fecha);
    	gc.setTimeInMillis(date.getTime());
    	
    	a1 = new AnuncioGuardado(gc,"Johnny");
    	
    	
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
    public void testListarAnuncioGuardado() {
    	
    	  		
    		WebTarget anuncioTarget = appTarget.path("serviciosGuardados");
        	WebTarget listaAnuncioGuardadoTarget = anuncioTarget.path("guardados");
    		
			
				    	
	    	List<AnuncioGuardado> listaAnuncioGuardado = new ArrayList<AnuncioGuardado>();
	    	listaAnuncioGuardado.add(a1);
	    			   			
	    	GenericType<List<AnuncioGuardado>> genericType = new GenericType<List<AnuncioGuardado>>() {};
	    	List<AnuncioGuardado> anuncio1 = listaAnuncioGuardadoTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	    	
	        assertEquals(listaAnuncioGuardado.get(0).getNombre(), anuncio1.get(0).getNombre());
	        assertEquals(listaAnuncioGuardado.get(1).getNombre(), anuncio1.get(1).getNombre());
				
    	
    }
    
     @Test
     @PerfTest(invocations = 1000, threads = 40)
	 public void guardarServicioGuardado(){
    	      
    	WebTarget anuncioTarget = appTarget.path("serviciosGuardados");
     	WebTarget guardarTarget = anuncioTarget.path("comprar");
     	guardarTarget.request().post(Entity.entity(a1, MediaType.APPLICATION_JSON));
     			   			
     	WebTarget seleccionarTarget = anuncioTarget.path("anuncioGuardado").queryParam("11-12-2011", "aidav13");
     	GenericType<AnuncioGuardado> genericType = new GenericType<AnuncioGuardado>() {};
     	AnuncioGuardado anuncioGuardado = seleccionarTarget.request(MediaType.APPLICATION_JSON).get(genericType);
     	
         assertEquals("aidav13", anuncioGuardado.getNombre());
     }         
}