package fr.hb.tpblogrecette.services;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;




import fr.hb.tpblogrecette.model.Categorie;

import fr.hb.tpblogrecette.utils.HibernateUtil;



public class CategorieService {

	public CategorieService() {

	}

	public Categorie createCategorie(Categorie categorie){

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (categorie != null) {
				session.save(categorie);
				session.flush();
			}
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return categorie;

	}

	public void updateCategorie(Categorie categorie){
		
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (categorie != null) {
				session.update(categorie);
				session.flush();
			}
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		


	}



	public Categorie getCategorieFromId(int id){

		Transaction transaction = null;
		Categorie categorie = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			categorie = session.get(Categorie.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return categorie;
	}

	public void deleteCategorie(Categorie categorie){

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (categorie != null) {
				session.delete(categorie);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 


	}

	
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategories(){

		Transaction transaction = null;
		List < Categorie > listOfCategorie = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfCategorie = session.createQuery("from Categorie").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return listOfCategorie;
	}
}




