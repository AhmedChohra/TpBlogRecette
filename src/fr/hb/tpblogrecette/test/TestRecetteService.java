package fr.hb.tpblogrecette.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.services.RecetteService;
import fr.hb.tpblogrecette.utils.HibernateUtil;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.util.Date;
import java.util.List;

public class TestRecetteService extends TestCase {
	
	private static SessionFactory sessionFactory = null;
	private static RecetteService recetteService = null;
	private static Recette recetteTest = null;
	
	public TestRecetteService(){
		
	}
	
	public TestRecetteService(String testName){
		super(testName);
		

		
	}
	
	@Before
	public void setUp() throws Exception {
		
		sessionFactory = HibernateUtil.getSessionFactory();
		recetteService = new RecetteService();
		
		if (recetteTest == null) {
		recetteTest = new Recette("poulet basquaise", "recette de poulet basquaise", "photo.jpg", new Date());
		}
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testCreateRecette() throws Exception {

		// action
		recetteTest = recetteService.createRecette(recetteTest);
		Recette recetteCree = recetteService.getRecetteFromId(recetteTest.getId());
				
		// assert
		assertNotEquals(0, recetteTest.getId());

		assertEquals(recetteTest.getTitre(), recetteCree.getTitre());
		assertEquals(recetteTest.getDescription(), recetteCree.getDescription());
		assertEquals(recetteTest.getPhoto(), recetteCree.getPhoto());
		assertEquals(recetteTest.getDateCreation().getDate(), recetteCree.getDateCreation().getDate());
		
	}
	
	@Test
	public void testGetRecetteFromId() throws Exception {

		// action
		
		Recette recetteFromId = recetteService.getRecetteFromId(recetteTest.getId());
				
		// assert

		assertEquals(recetteFromId.getTitre(), recetteTest.getTitre());
		assertEquals(recetteFromId.getDescription(), recetteTest.getDescription());
		assertEquals(recetteFromId.getPhoto(), recetteTest.getPhoto());
		assertEquals(recetteFromId.getDateCreation().getDate(), recetteTest.getDateCreation().getDate());
		
	}
	
	@Test
	public void testGetAllRecettes() throws Exception {

		// action
		List <Recette> recettes = recetteService.getAllRecettes();
				
		// assert
		assertEquals(recettes.size(), 1);
		
	}
	
	
	@Test
	public void testUpdateRecette() throws Exception {
		
		//Creer un jeu de tests (arrange)
		Date newDate = new Date("2019/11/04");
		
		

		recetteTest.setTitre("pbasquaise");
		recetteTest.setDescription("pbasquaise_desc");
		recetteTest.setPhoto("photo_update");
		recetteTest.setDateCreation(newDate);
		
		// action
		recetteService.updateRecette(recetteTest);
		Recette recetteUpdate = recetteService.getRecetteFromId(recetteTest.getId());
		
		// assert

		assertEquals(recetteUpdate.getTitre(), recetteTest.getTitre());
		assertEquals(recetteUpdate.getDescription(), recetteTest.getDescription());
		assertEquals(recetteUpdate.getPhoto(), recetteTest.getPhoto());
		assertEquals(recetteUpdate.getDateCreation().getDate(), recetteTest.getDateCreation().getDate());
	}
	
	@Test
	public void testDeleteRecette() throws Exception {
		
		//Creer un jeu de tests (arrange)
		recetteService.deleteRecette(recetteTest);
		recetteTest = recetteService.getRecetteFromId(recetteTest.getId());
		
		// assert
		assertNull(recetteTest);
		
	}
	
	public static junit.framework.Test suite() throws Exception {
		
		TestSuite suite = new TestSuite("Suite TestRecetteService");
		
		suite.addTest(new TestRecetteService("testCreateRecette"));
		suite.addTest(new TestRecetteService("testGetRecetteFromId"));	
		suite.addTest(new TestRecetteService("testUpdateRecette"));	
		suite.addTest(new TestRecetteService("testGetAllRecettes"));
		suite.addTest(new TestRecetteService("testDeleteRecette"));
		
		return suite;
	}

}