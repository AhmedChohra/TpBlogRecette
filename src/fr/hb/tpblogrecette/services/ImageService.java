package fr.hb.tpblogrecette.services;



import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import fr.hb.tpblogrecette.model.Image;
import fr.hb.tpblogrecette.utils.HibernateUtil;

public class ImageService {

	public Image createImage(Image image){
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (image != null) {
				session.save(image);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
		return image;
	}
	public void updateImage(Image image){
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (image != null) {
				session.update(image);
				session.flush();
			}
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	

	public Image getImagebyRecette(int idRecette){
		Image image=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String result = "SELECT I from Image I join I.recette R where R.id = :id";
			Query query = session.createQuery(result);
			query.setParameter("id", idRecette);
			image = (Image)query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}
