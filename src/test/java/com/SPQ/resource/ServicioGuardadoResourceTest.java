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
import com.SPQ.main.Main;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;



import jakarta.ws.rs.core.MediaType;

@Category(IntegrationTest.class)
public class ServicioGuardadoResourceTest {
	
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
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testListarAnuncioGuardado() {
    	
    	try {
    		
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = "20-11-1999";
			Date date = sdf.parse(fecha);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			AnuncioGuardado anuncio = new AnuncioGuardado(gc,"John");
			
			WebTarget servicioGuardadoTarget = appTarget.path("anuncios");
	    	WebTarget listaServicioGuardadoTarget = servicioGuardadoTarget.path("listaServicioGuardado");
	    	
	    	List<AnuncioGuardado> listaAnuncioGuardado = new ArrayList<AnuncioGuardado>();
	    	listaAnuncioGuardado.add(anuncio);
	    			   			
	    	GenericType<List<AnuncioGuardado>> genericType = new GenericType<List<AnuncioGuardado>>() {};
	    	List<AnuncioGuardado> usuarios = listaServicioGuardadoTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	    	
	        assertEquals(listaAnuncioGuardado.get(0).getNombre(), usuarios.get(0).getNombre());
	        assertEquals(listaAnuncioGuardado.get(1).getNombre(), usuarios.get(1).getNombre());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    	
    }
    
     @Test
     @PerfTest(invocations = 1000, threads = 40)
	 public void guardarServicioGuardado(AnuncioGuardado anuncioGuardado){
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				pm.makePersistent(anuncioGuardado);

				tx.commit();
				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}
	   }
}