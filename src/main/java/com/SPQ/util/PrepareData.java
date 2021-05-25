package com.SPQ.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.SPQ.clasesBasicas.Anuncio;
import com.SPQ.clasesBasicas.AnuncioGuardado;
import com.SPQ.clasesBasicas.Categoria;
import com.SPQ.clasesBasicas.Usuario;

public class PrepareData {

	public static void main(String[] args) throws IOException {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Usuario usuario = new Usuario("Aitor", "Davila", "aidav13", "pass123", "aidav@gmail.com", "6839283948",
					"Calle Ave del Paraiso 9, Barcelona", "", "Dua", "¿Como se llama mi gato?", "Trabajando en el sector desde hace 30 años.");
			pm.makePersistent(usuario);
			Usuario usuario1 = new Usuario("Jhon", "Gutierrez", "jhonny2", "anims", "jhonny@gamail.com", "624245265",
					"Calle Bailen 23, Plencia", "", "Batman", "¿Como se llama mi gato?", "He trabajado en grandes empresas, pero ahora soy autonomo");
			pm.makePersistent(usuario1);
			Usuario usuario2 = new Usuario("Gaizka", "Chavarria", "dnkay", "txababaile", "gaizkendi@fsgmail.com",
					"68392394", "Calle de las Algortas 4, Barakaldo", "", "Inma", "¿Como se llama mi gato?", "Una persona con la que puedes chatear mientras te formateo el PC");
			pm.makePersistent(usuario2);
			Usuario usuario3 = new Usuario("Aticus", "Garcia", "xabster", "micho", "paticus@gmail.com", "61239948",
					"Calle de gallarta 23, Cadiz", "", "Vandal", "¿Como se llama mi gato?", "Me gusta trabjar en silencio. No muy hablador");
			pm.makePersistent(usuario3);

			Anuncio anuncio = new Anuncio("EL Mejor Fontanero", "Servicio de fontaneria, los mejores arreglos de retretes", 60, "", Categoria.FONTANERO, true, usuario.getIdUsuario());
			pm.makePersistent(anuncio);
			Anuncio anuncio1 = new Anuncio("Maderas a tutiplen", "El mejor puliendo madera que podras encontrar", 40, "", Categoria.ALBAYIL,false, usuario1.getIdUsuario());
			pm.makePersistent(anuncio1);
			Anuncio anuncio2 = new Anuncio("Tu PC no Skaapara de mi", "Desde formatear el PC hasta instarlarte los drivers", 20, "", Categoria.INFORMATICO, true,usuario2.getIdUsuario());
			pm.makePersistent(anuncio2);
			Anuncio anuncio3 = new Anuncio("Tu persiana necesita que la enrolle", "Arreglo de persianas", 90, "", Categoria.PERSIANERO,true, usuario3.getIdUsuario());
			pm.makePersistent(anuncio3);
			
//			try {
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				String fecha = "11-11-2001";
//				Date date = sdf.parse(fecha);
//				GregorianCalendar gc = new GregorianCalendar();
//				gc.setTimeInMillis(date.getTime());
//				AnuncioGuardado anuncioGuardado = new AnuncioGuardado(gc, 0, anuncio.getIdAnuncio());
//				pm.makePersistent(anuncioGuardado);
//		
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//			
//			try {
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				String fecha = "11-01-2021";
//				Date date = sdf.parse(fecha);
//				GregorianCalendar gc = new GregorianCalendar();
//				gc.setTimeInMillis(date.getTime());
//				AnuncioGuardado anuncioGuardado1 = new AnuncioGuardado(gc, 1, anuncio1.getIdAnuncio());
//				pm.makePersistent(anuncioGuardado1);
//		
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//			
//			try {
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				String fecha = "21-08-2021";
//				Date date = sdf.parse(fecha);
//				GregorianCalendar gc = new GregorianCalendar();
//				gc.setTimeInMillis(date.getTime());
//				AnuncioGuardado anuncioGuardado2 = new AnuncioGuardado(gc, 0, anuncio2.getIdAnuncio());
//				pm.makePersistent(anuncioGuardado2);
//		
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//			
//			try {
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				String fecha = "11-03-2020";
//				Date date = sdf.parse(fecha);
//				GregorianCalendar gc = new GregorianCalendar();
//				gc.setTimeInMillis(date.getTime());
//				AnuncioGuardado anuncioGuardado3 = new AnuncioGuardado(gc, 0, anuncio3.getIdAnuncio());
//				pm.makePersistent(anuncioGuardado3);
//		
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
