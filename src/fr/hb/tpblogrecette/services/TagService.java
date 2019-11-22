package fr.hb.tpblogrecette.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Tag;
import fr.hb.tpblogrecette.utils.HibernateUtil;

public class TagService {

	
	public Tag createTag(Tag tag) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (tag != null) {
				session.save(tag);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return tag;

	}
	
	public Tag getTagFromId(int id) {

		Transaction transaction = null;
		Tag tag = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			tag = session.get(Tag.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return tag;
	}
	
	public void updateTag(Tag tag) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (tag != null) {
				session.update(tag);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void deleteTag(Tag tag){

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (tag != null) {
				session.delete(tag);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
	}
	
	public List<Tag> getAllTags(){
		Transaction transaction = null;
		List <Tag> listOfTag = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfTag = session.createQuery("from Tag").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return listOfTag;
	}
	
	public List<Tag> getTagbyRecette(int idRecette){


		List<Tag> tagsByRecette = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			

			// get an user object
			String hql = "SELECT t from Tag t join t.recettes r WHERE r.id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", idRecette);

			
			tagsByRecette = (List<Tag>) query.getResultList();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return tagsByRecette;
	}
	
	public Tag getTagFromNom(String nom) {

		Transaction transaction=null;
		Tag tag = new Tag();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			
			String hql = "FROM Tag T WHERE T.nom = :nom";
			Query query = session.createQuery(hql);
			query.setParameter("nom", nom);
			List list = query.getResultList();
            tag = (Tag)list.toArray()[0];
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return tag;
	}
}
