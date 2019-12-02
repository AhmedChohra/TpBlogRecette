/**
 * 
 */
package fr.hb.tpblogrecette.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;



class TestHibernate {

	protected Session session;
	protected SessionFactory sessionFactory;

	public static void main(String args[]) throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = sf;
		@SuppressWarnings("unused")
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