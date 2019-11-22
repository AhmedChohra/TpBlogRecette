package fr.hb.tpblogrecette.services;


import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.hb.tpblogrecette.model.*;
import fr.hb.tpblogrecette.utils.HibernateUtil;




public class IngredientService {




	public IngredientService(){

	}

	public Ingredient createIngredient(Ingredient ingredient){


		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (ingredient != null) {
				session.save(ingredient);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ingredient;

	}

	public void updateIngredient(Ingredient ingredient) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (ingredient != null) {
				session.update(ingredient);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Ingredient getIngredientFromId(int id){

		Transaction transaction = null;
		Ingredient ingredient = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ingredient = session.get(Ingredient.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return ingredient;

	}

	public void deleteIngredient(Ingredient ingredient){

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (ingredient != null) {
				session.delete(ingredient);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
	}

	public List<Ingredient> getAllIngredients(){
		Transaction transaction = null;
		List <Ingredient> listOfIngredient = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfIngredient = session.createQuery("from Ingredient").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return listOfIngredient;
	}


	public List<Ingredient> getIngredientFromRecette(int idRecette){


		List<Ingredient> listIngredients = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			

			// get an user object
			String hql = "SELECT ingredient from Ingredient  ingredient join ingredient.recette as recette WHERE recette.id = :idRecette";
			Query query = session.createQuery(hql);
			query.setParameter("idRecette", idRecette);

			Object listOfIngredients = query.getResultList();
			listIngredients = (List<Ingredient>) listOfIngredients;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listIngredients;
	}
}
