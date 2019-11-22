/**
 * 
 */
package fr.hb.tpblogrecette.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import fr.hb.tpblogrecette.model.Categorie;
import fr.hb.tpblogrecette.model.Commentaire;
import fr.hb.tpblogrecette.model.Ingredient;
import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Recette;

class TestHibernate {

	protected Session session;
	protected SessionFactory sessionFactory;

	public static void main(String args[]) throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = sf;
		Session session = sessionFactory.openSession();
		
		
		/*CarteIdentite carteIdentite = new CarteIdentite(123132131);
		session.save(carteIdentite);
		
		Membre membre = new Membre();
		membre.setCarteIdentite(carteIdentite);
		session.save(membre);
		
		Commentaire commentaire = new Commentaire();
		commentaire.setMembre(membre);
		session.save(commentaire);*/
		
		/*Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Membre membre = (Membre)session.load(Membre.class, 1);
			session.delete(membre);
			session.flush();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		
		
		
		
		
		sessionFactory.close();
	}

}