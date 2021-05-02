package com.SPQ.util;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.SPQ.clasesBasicas.Anuncio;
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
					"Calle Ave del Paraiso 9, Barcelona", "", "Dua", "¿Como se llama mi gato?");
			pm.makePersistent(usuario);
			Usuario usuario1 = new Usuario("Aitora", "Davilaa", "aidav13a", "passa123", "aidav@gamail.com", "68392848",
					"Callse Ave del Paraiso 9, Barcselona", "", "Dusa", "¿Comso se llama mi gato?");
			pm.makePersistent(usuario1);
			Usuario usuario2 = new Usuario("Aitsor", "Davilaada", "aidavsfa13", "pass1dsf23", "aidav@fsgmail.com",
					"68392833948", "Calle Ave del Pafaraiso 9, Barcafelona", "", "Dua", "¿Como se llamsa mi gato?");
			pm.makePersistent(usuario2);
			Usuario usuario3 = new Usuario("Aitofr", "Davilfa", "aidsfav13", "passfs123", "aidav@gmail.com", "68393948",
					"Calle Ave del Pfaaraiso 9, Barcelafona", "", "Dua", "¿Como se llamsfa mi gato?");
			pm.makePersistent(usuario3);

			Anuncio anuncio = new Anuncio("Aitor", "Ofrdaezco servicio de fontaneria", 60, "", Categoria.ALBAYIL, true,
					usuario.getIdUsuario());
			pm.makePersistent(anuncio);
			Anuncio anuncio1 = new Anuncio("Aiadtor", "Ofrezco servicio de fontaneria", 40, "", Categoria.ALBAYIL,
					false, usuario1.getIdUsuario());
			pm.makePersistent(anuncio1);
			Anuncio anuncio2 = new Anuncio("sitor", "Ofrezdco servicio de fontaneria", 20, "", Categoria.ALBAYIL, true,
					usuario2.getIdUsuario());
			pm.makePersistent(anuncio2);
			Anuncio anuncio3 = new Anuncio("Aitoddr", "Ofrezco saaervicio de fontaneria", 90, "", Categoria.ALBAYIL,
					true, usuario3.getIdUsuario());
			pm.makePersistent(anuncio3);

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
