/**
 * 
 */
package fr.hb.tpblogrecette.services;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.hb.tpblogrecette.model.Categorie;
import fr.hb.tpblogrecette.model.Commentaire;
import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.model.Tag;
import fr.hb.tpblogrecette.utils.HibernateUtil;
import net.bytebuddy.asm.Advice.This;




/**
 * @author HB
 *
 */
public class RecetteService {


	public RecetteService(){

	}

	public Recette createRecette(Recette recette){
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (recette != null) {
				session.save(recette);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return recette;

	}

	public Recette getRecetteFromId(int id){

		Transaction transaction = null;
		Recette recette = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			recette = session.get(Recette.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return recette;
	}

	public void updateRecette(Recette recette){

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (recette != null) {
				session.saveOrUpdate(recette);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void deleteRecette(Recette recette){

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (recette != null) {
				session.delete(recette);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
	}

	public List<Recette> getAllRecettes(){
		Transaction transaction = null;
		List <Recette> listOfRecette = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfRecette = session.createQuery("from Recette").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return listOfRecette;
	}






	public List<Recette> getRecetteByCategorie(int idCategorie){

		List<Recette> recettesByCategorie = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT recette from Recette recette join recette.categorie categorie WHERE categorie.id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", idCategorie);

			recettesByCategorie = (List<Recette>) query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}



		return recettesByCategorie;
	}

	public List<Recette> getRecetteByTag(int id){

		List<Recette> recettesByTag = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT recette from Recette recette join recette.tags tag WHERE tag.id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			recettesByTag = (List<Recette>) query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return recettesByTag;
	}

	public List getRecetteAndTagFromId(int idRecette ){

		Transaction transaction = null;
		List recette = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT recette, tag from Recette recette LEFT JOIN recette.tags tag WHERE recette.id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", idRecette);
			recette = (ArrayList) query.getResultList(); 

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return recette;
	}

	public void deleteTag(Recette recette, Tag tag) {

		Set<Tag> tags = recette.deleteTag(tag);

		// supprimer le tag de la liste et retourner la liste 

		// Réinitialiser les tags a null
		recette.setTags(new HashSet<Tag>());
		for (Tag tagCompare : tags) {
			if(tagCompare.getId() != tag.getId() ) {
				recette.addTag(tagCompare);
				//tagCompare.addRecette(recette);
			} else {
				recette.deleteTag(tag);
			}
		}
		
		// ajouter la liste modifiée _ 
		this.updateRecette(recette);

	}

}



