package fr.hb.tpblogrecette.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.hb.tpblogrecette.model.Ingredient;

import fr.hb.tpblogrecette.services.IngredientService;

import fr.hb.tpblogrecette.utils.HibernateUtil;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Date;
import java.util.List;

public class TestIngredientService extends TestCase {
	
	@SuppressWarnings("unused")
	private static SessionFactory sessionFactory = null;
	private static IngredientService ingredientService = null;
	private static Ingredient ingredientTest = null;
	
	public TestIngredientService(){
		
	}
	
	public TestIngredientService(String testName){
		super(testName);
		

		
	}
	
	@Before
	public void setUp() throws Exception {
		
		sessionFactory = HibernateUtil.getSessionFactory();
		ingredientService = new IngredientService();
		
		if (ingredientTest == null) {
		ingredientTest = new Ingredient("sel", 1, "g" );
		}
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testCreateIngredient() throws Exception {

		// action
		ingredientTest = ingredientService.createIngredient(ingredientTest);
		Ingredient ingredientCree = ingredientService.getIngredientFromId(ingredientTest.getId());
				
		// assert
		assertNotEquals(0, ingredientTest.getId());
		assertEquals(ingredientTest.getNom(),ingredientCree.getNom());
		assertEquals(ingredientTest.getQuantite(), ingredientCree.getQuantite());
		assertEquals(ingredientTest.getUnit(), ingredientCree.getUnit());

		
	}
	
	@Test
	public void testGetIngredientFromId() throws Exception {

		// action
		
		Ingredient ingredientFromId = ingredientService.getIngredientFromId(ingredientTest.getId());
				
		// assert
		
		assertEquals(ingredientFromId.getNom(), ingredientTest.getNom());
		assertEquals(ingredientFromId.getQuantite(), ingredientTest.getQuantite());
		assertEquals(ingredientFromId.getUnit(), ingredientTest.getUnit());

		
	}
	
	@Test
	public void testGetAllIngredients() throws Exception {

		// action
		List <Ingredient> ingredients = ingredientService.getAllIngredients();
				
		// assert
		assertEquals(ingredients.size(), 1);
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateIngredient() throws Exception{
		
		//Creer un jeu de tests (arrange)
		@SuppressWarnings("unused")
		Date newDate = new Date("2019/11/04");
		
		
		
		ingredientTest.setNom("poivre");
		ingredientTest.setQuantite(2);
		ingredientTest.setUnit("cc");
		
		
		// action
		ingredientService.updateIngredient(ingredientTest);
		Ingredient ingredientUpdate = ingredientService.getIngredientFromId(ingredientTest.getId());
		
		// assert
		
		assertEquals(ingredientUpdate.getNom(), ingredientTest.getNom());
		assertEquals(ingredientUpdate.getQuantite(), ingredientTest.getQuantite());
		assertEquals(ingredientUpdate.getUnit(), ingredientTest.getUnit());

	}
	
	@Test
	public void testDeleteIngredient() throws Exception {
		
		//Creer un jeu de tests (arrange)
		ingredientService.deleteIngredient(ingredientTest);
		ingredientTest = ingredientService.getIngredientFromId(ingredientTest.getId());
		
		// assert
		assertNull(ingredientTest);
		
	}
	
	public static junit.framework.Test suite() {
		
		TestSuite suite = new TestSuite("Suite TestIngredientService");
		
		suite.addTest(new TestIngredientService("testCreateIngredient"));
		suite.addTest(new TestIngredientService("testGetIngredientFromId"));	
		suite.addTest(new TestIngredientService("testUpdateIngredient"));	
		suite.addTest(new TestIngredientService("testGetAllIngredients"));
		suite.addTest(new TestIngredientService("testDeleteIngredient"));
		
		return suite;
	}

}
