//package com.SPQ.resource;
//
//import static org.junit.Assert.assertEquals;
//
//import java.awt.List;
//import java.awt.PageAttributes.MediaType;
//import java.util.ArrayList;
//
//import javax.jdo.JDOHelper;
//import javax.jdo.PersistenceManager;
//import javax.jdo.PersistenceManagerFactory;
//import javax.jdo.Transaction;
//import javax.swing.JList;
//
//import org.databene.contiperf.PerfTest;
//import org.databene.contiperf.junit.ContiPerfRule;
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.experimental.categories.Category;
//
//import com.SPQ.categories.IntegrationTest;
//import com.SPQ.clasesBasicas.Anuncio;
//import com.SPQ.clasesBasicas.AnuncioGuardado;
//import com.SPQ.clasesBasicas.Categoria;
//import com.SPQ.clasesBasicas.Usuario;
//import com.SPQ.main.Main;
//
//import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.client.Client;
//import jakarta.ws.rs.client.ClientBuilder;
//import jakarta.ws.rs.client.Entity;
//import jakarta.ws.rs.client.WebTarget;
//import jakarta.ws.rs.core.GenericType;
//
//@Category(IntegrationTest.class)
//public class ServicioGuardadoResourceTest {
//	
//	@Rule public ContiPerfRule rule = new ContiPerfRule();
//	
//	private HttpServer server;
//    private WebTarget appTarget;
//    private Client c;
//    
//    @Before
//    public void setUp() throws Exception {
//    	
//    	server = Main.startServer();
//        // create the client
//        Client c = ClientBuilder.newClient();
//
//        appTarget = c.target(Main.BASE_URI);
//
//    }
//    @After
//    public void tearDown() throws Exception {
//        server.stop();
//    }
//    
//    @Test
//    @PerfTest(invocations = 1000, threads = 40)
//    public void testListarAnuncioGuardado() {
//    	
//		Anuncio a2 = new  Anuncio("Aitora", "Fontanero" , 21, "foto",Categoria.FONTANERO, true ,1);
//    	
//    	WebTarget servicioGuardadoTarget = appTarget.path("anuncios");
//    	WebTarget listaServicioGuardadoTarget = servicioGuardadoTarget.path("listaServicioGuardado");
//    	
//    	List<AnuncioGuardado> listaAnuncioGuardado = new ArrayList<AnuncioGuardado>();
//    	listaAnuncioGuardado.add(a1);
//    	listaAnuncioGuardado.add(a2);
//    			   			
//    	GenericType<List<AnuncioGuardado>> genericType = new GenericType<List<AnuncioGuardado>>() {};
//    	List<AnuncioGuardado> usuarios = listaServicioGuardadoTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//    	
//        assertEquals(listaAnuncioGuardado.get(0).getNombreUsuario(), usuarios.get(0).getNombreUsuario());
//        assertEquals(listaAnuncioGuardado.get(1).getNombreUsuario(), usuarios.get(1).getNombreUsuario());
//    }
//    
//    @POST
//	@Path("registro")
//	@Consumes(MediaType.APPLICATION_JSON)
//	 public void guardarServicioGuardado(AnuncioGuardado anuncioGuardado){
//			
//			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//			PersistenceManager pm = pmf.getPersistenceManager();
//			Transaction tx = pm.currentTransaction();
//			
//			try {
//				tx.begin();
//				
//				pm.makePersistent(anuncioGuardado);
//
//				tx.commit();
//				
//			} finally {
//				if (tx.isActive()) {
//					tx.rollback();
//				}
//				pm.close();
//			}
//	   }
//}