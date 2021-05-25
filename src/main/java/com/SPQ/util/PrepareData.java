package com.SPQ.util;

import java.io.IOException;

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
			Anuncio anuncio1 = new Anuncio("Maderas a tutiplen", "El mejor puliendo madera que podras encontrar", 40, "", Categoria.FONTANERO,false, usuario1.getIdUsuario());
			pm.makePersistent(anuncio1);
			Anuncio anuncio2 = new Anuncio("Tu PC no Skaapara de mi", "Desde formatear el PC hasta instarlarte los drivers", 20, "", Categoria.INFORMATICO, true,usuario2.getIdUsuario());
			pm.makePersistent(anuncio2);
			Anuncio anuncio3 = new Anuncio("Tu persiana necesita que la enrolle", "Arreglo de persianas", 90, "", Categoria.PERSIANERO,true, usuario3.getIdUsuario());
			pm.makePersistent(anuncio3);
			
			AnuncioGuardado anuncioGuardado = new AnuncioGuardado(null, 0, anuncio.getIdAnuncio());
			pm.makePersistent(anuncioGuardado);
			AnuncioGuardado anuncioGuardado1 = new AnuncioGuardado(null, 1, anuncio1.getIdAnuncio());
			pm.makePersistent(anuncioGuardado1);
			AnuncioGuardado anuncioGuardado2 = new AnuncioGuardado(null, 0, anuncio2.getIdAnuncio());
			pm.makePersistent(anuncioGuardado2);
			AnuncioGuardado anuncioGuardado3 = new AnuncioGuardado(null, 0, anuncio3.getIdAnuncio());
			pm.makePersistent(anuncioGuardado3);

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
