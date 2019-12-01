/**
 * 
 */
package fr.hb.tpblogrecette.services;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.hb.tpblogrecette.model.Categorie;
import fr.hb.tpblogrecette.model.Commentaire;
import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.utils.HibernateUtil;

/**
 * @author HB
 *
 */
public class CommentaireService {
	



	public Commentaire createCommentaire(Commentaire commentaire){
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			
			
			transaction = session.beginTransaction();
			if (commentaire != null) {
				session.save(commentaire);
				session.flush();
			}
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		
		}

		return commentaire;

	}

	public void updateCommentaire(Commentaire commentaire){

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (commentaire != null) {
				session.update(commentaire);
				session.flush();
			}
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Commentaire getCommentaireFromId(int id){

		Transaction transaction = null;
		Commentaire commentaire = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			commentaire = session.get(Commentaire.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return commentaire;
	}
	
	public void deleteCommentaire(Commentaire commentaire){

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (commentaire != null) {
				session.delete(commentaire);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
	}

	public List<Commentaire> getAllCommentaires(){
		Transaction transaction = null;
		List <Commentaire> listOfCommentaire = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfCommentaire = session.createQuery("from Commentaire").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return listOfCommentaire;
	}
	
	public List<Commentaire> getCommentaireByRecette(int idRecet){
		List<Commentaire> commentairesByRecette = new ArrayList<>();
		
		Commentaire commentaireByRecette = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         // start a transaction
	        
	         // get an user object
	        String hql = "SELECT commentaire from Commentaire commentaire join commentaire.recette as recette WHERE recette.id = :id";
	        Query query = session.createQuery(hql);
	        query.setParameter("id", idRecet);
	        
	        commentairesByRecette = (List<Commentaire>) query.getResultList();
	         } catch (Exception e) {
	        
	         e.printStackTrace();
	         }
		
		return commentairesByRecette;
	}
public int getNoteAverageFromRecette(int idRecette){
		
	int noteAverage = 0;
		
		

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String avgHql = "SELECT floor(avg(note))  from Commentaire C where C.recette = :id";
			Query query = session.createQuery(avgHql);
			query.setInteger("id", idRecette);
			
			noteAverage = (int) query.getSingleResult();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return noteAverage;
		
		
	}
	
	
}
