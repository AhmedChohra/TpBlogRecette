package fr.hb.tpblogrecette.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.hb.tpblogrecette.model.Categorie;
import fr.hb.tpblogrecette.model.Commentaire;
import fr.hb.tpblogrecette.model.Ingredient;
import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Recette;


public class TestAjoutMembre {

	protected Session session;
	protected SessionFactory sessionFactory;

	public static void main(String args[]) throws Exception{

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = sf;
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			//ajout dans bdd
			/*tx = session.beginTransaction();
			Membre membre = new Membre("ahmed", "ska", "12345", "ska@gmail.com", new Date());
			session.save(membre);
			session.flush();
			tx.commit();
			
			tx = session.beginTransaction();
			Commentaire commentaire = new Commentaire(1, "ska", "trop bon", 5, new Date());
			session.save(commentaire);
			session.flush();
			tx.commit();
			
			tx = session.beginTransaction();
			Ingredient ingredient = new Ingredient(1, "tomates", 3, "u");
			session.save(ingredient);
			session.flush();
			tx.commit();
			
			tx = session.beginTransaction();
			Recette recette = new Recette(1, 1, "tartiflette", "tartiflette", "tartiflette.jpg", new Date());
			session.save(recette);
			session.flush();
			tx.commit();
			
			tx = session.beginTransaction();
			Categorie categorie = new Categorie("Plat principal");
			session.save(categorie);
			session.flush();
			tx.commit();*/
			
			//select all
			
			/*String hql = "FROM Membre M";
			Query query = session.createQuery(hql);
			List results = query.getResultList();
			System.out.println(results);*/
		
			//select from 
			
			/*String hql = "FROM Membre M Where M.id = 1";
			Query query = session.createQuery(hql);
			List list = query.getResultList();
			Membre membre = (Membre) list.toArray()[0];
			System.out.println(list);*/
			
			/*String hql = "FROM Membre M Where M.dateInscription = :date";
			Query query = session.createQuery(hql)
				.setParameter("date", new Date(1970/01/01));
			List results = query.getResultList();
			System.out.println(results);*/
			
			//delete all
			/*tx = session.beginTransaction();
			String hql = "FROM Membre M";
			Query query = session.createQuery(hql);
			List avantSuppression = query.getResultList();
			System.out.println(avantSuppression);
			
			//delete membre from id
			Membre membre = (Membre)session.load(Membre.class, 1);
			session.delete(membre);
			session.flush();
			
			Query query2 = session.createQuery(hql);
			List apresSuppression = query2.getResultList();
			System.out.println(apresSuppression);
			tx.commit();*/
			
			
			//delete tout avant "10/11/2019"
			
			/*tx = session.beginTransaction();
			String sDate1="10/11/2019";
			Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			System.out.println(sDate1+"\t"+date);
			
			String hqlDelete = "DELETE FROM Membre M where M.dateInscription <= :date";
			Query deleteQuery = session.createQuery(hqlDelete).setParameter("date", date);
			deleteQuery.executeUpdate();
			tx.commit();*/
			
			
			//Update
			
			/*tx = session.beginTransaction();
			Membre membre = (Membre) session.load(Membre.class, 5);
			membre.setNom("Contenu mis à jour");
			tx.commit();*/

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

		sessionFactory.close();
	}


}


