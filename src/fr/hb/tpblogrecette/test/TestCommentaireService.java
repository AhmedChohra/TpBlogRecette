package fr.hb.tpblogrecette.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.hb.tpblogrecette.model.Commentaire;

import fr.hb.tpblogrecette.services.CommentaireService;

import fr.hb.tpblogrecette.utils.HibernateUtil;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Date;
import java.util.List;

public class TestCommentaireService extends TestCase {
	
	@SuppressWarnings("unused")
	private static SessionFactory sessionFactory = null;
	private static CommentaireService commentaireService = null;
	private static Commentaire commentaireTest = null;
	
	public TestCommentaireService(){
		
	}
	
	public TestCommentaireService(String testName){
		super(testName);
		

		
	}
	
	@Before
	public void setUp() throws Exception {
		
		sessionFactory = HibernateUtil.getSessionFactory();
		commentaireService = new CommentaireService();
		
		if (commentaireTest == null) {
		commentaireTest = new Commentaire("jean-michel", "trés bon",5, new Date());
		}
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCreateCommentaire() throws Exception {

		// action
		commentaireTest = commentaireService.createCommentaire(commentaireTest);
		Commentaire commentaireCree = commentaireService.getCommentaireFromId(commentaireTest.getId());
				
		// assert
		assertNotEquals(0, commentaireTest.getId());
		
		assertEquals(commentaireTest.getAuteur(), commentaireCree.getAuteur());
		assertEquals(commentaireTest.getContenu(), commentaireCree.getContenu());
		assertEquals(commentaireTest.getNote(), commentaireCree.getNote());
		assertEquals(commentaireTest.getDateCreation().getDate(), commentaireCree.getDateCreation().getDate());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCommentaireFromId() throws Exception {

		// action
		
		Commentaire commentaireFromId = commentaireService.getCommentaireFromId(commentaireTest.getId());
				
		// assert
		
		assertEquals(commentaireFromId.getAuteur(), commentaireTest.getAuteur());
		assertEquals(commentaireFromId.getContenu(), commentaireTest.getContenu());
		assertEquals(commentaireFromId.getNote(), commentaireTest.getNote());
		assertEquals(commentaireFromId.getDateCreation().getDate(), commentaireTest.getDateCreation().getDate());
		
	}
	
	@Test
	public void testGetAllCommentaires() throws Exception {

		// action
		List <Commentaire> commentaires = commentaireService.getAllCommentaires();
				
		// assert
		assertEquals(commentaires.size(), 1);
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateCommentaire() throws Exception{
		
		//Creer un jeu de tests (arrange)
		Date newDate = new Date("2019/11/04");
		
		
		
		commentaireTest.setAuteur("bob");
		commentaireTest.setContenu("mauvais");
		commentaireTest.setNote(1);
		commentaireTest.setDateCreation(newDate);
		
		// action
		commentaireService.updateCommentaire(commentaireTest);
		Commentaire commentaireUpdate = commentaireService.getCommentaireFromId(commentaireTest.getId());
		
		// assert
		
		assertEquals(commentaireUpdate.getAuteur(), commentaireTest.getAuteur());
		assertEquals(commentaireUpdate.getContenu(), commentaireTest.getContenu());
		assertEquals(commentaireUpdate.getNote(), commentaireTest.getNote());
		assertEquals(commentaireUpdate.getDateCreation().getDate(), commentaireTest.getDateCreation().getDate());
	}
	
	@Test
	public void testDeleteCommentaire() throws Exception {
		
		//Creer un jeu de tests (arrange)
		commentaireService.deleteCommentaire(commentaireTest);
		commentaireTest = commentaireService.getCommentaireFromId(commentaireTest.getId());
		
		// assert
		assertNull(commentaireTest);
		
	}
	
	public static junit.framework.Test suite() {
		
		TestSuite suite = new TestSuite("Suite TestCommentaireService");
		
		suite.addTest(new TestCommentaireService("testCreateCommentaire"));
		suite.addTest(new TestCommentaireService("testGetCommentaireFromId"));	
		suite.addTest(new TestCommentaireService("testUpdateCommentaire"));	
		suite.addTest(new TestCommentaireService("testGetAllCommentaires"));
		suite.addTest(new TestCommentaireService("testDeleteCommentaire"));
		
		return suite;
	}

}
