package fr.hb.tpblogrecette.services;


import java.sql.SQLException;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.utils.HibernateUtil;




public class MembreService {


	public MembreService(){




	}

	public Membre createMembre(Membre membre){
		Transaction transaction = null;



		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (membre != null) {
				session.save(membre);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return membre;


	}

	public Membre getMembreFromId(int id) {

		Transaction transaction = null;
		Membre membre = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			membre = session.get(Membre.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return membre;
	}

	public void updateMembre(Membre membre){

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			if (membre != null) {
				session.update(membre);
				session.flush();
			}
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void deleteMembre(Membre membre){
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (membre != null) {
				session.delete(membre);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 

	} 

	public List<Membre> getAllMembres(){
		Transaction transaction = null;
		List <Membre> listOfMembre = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			listOfMembre = session.createQuery("from Membre").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return listOfMembre;
	}

	public Membre getMembreFromPseudoAndPsw(String pseudoEmail, String mdp){
		
		Transaction transaction=null;
		
        Membre membre = new Membre();
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			String hql = "from Membre m where  (m.pseudo = :pseudo or m.email = :email) and m.mdp = :mdp";
			Query query = session.createQuery(hql);
			query.setParameter("pseudo", pseudoEmail);
			query.setParameter("email", pseudoEmail);
			query.setParameter("mdp", mdp);
			
			
            List list = query.getResultList();
            membre = (Membre)list.toArray()[0];
            transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return membre;
	}






/*public Membre getMembreFromPseudoAndPsw(String PseudoEmail, String mdp) throws SQLException {

		Membre membre = null;
		String query = "SELECT * from membre WHERE (pseudo = ? or email = ?) AND mdp = ?";

		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, PseudoEmail);
		ps.setString(2, PseudoEmail);
		ps.setString(3, mdp);

		ResultSet rSet = ps.executeQuery();

		if (rSet.next()) {
			membre = new Membre();

			membre.setId(rSet.getInt("id"));
			membre.setId(rSet.getInt("id"));
			membre.setNom(rSet.getString("nom"));
			membre.setPseudo(rSet.getString("pseudo"));
			membre.setMdp(rSet.getString("mdp"));
			membre.setEmail(rSet.getString("email"));
			membre.setDateInscription(rSet.getDate("dateInscription"));
		}

		return membre;
	}*/

}


