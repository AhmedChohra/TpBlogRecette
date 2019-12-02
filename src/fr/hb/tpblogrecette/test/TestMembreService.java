package fr.hb.tpblogrecette.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.hb.tpblogrecette.model.Membre;

import fr.hb.tpblogrecette.services.MembreService;

import fr.hb.tpblogrecette.utils.HibernateUtil;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.util.Date;
import java.util.List;

public class TestMembreService extends TestCase {
	
	@SuppressWarnings("unused")
	private static SessionFactory sessionFactory = null;
	private static MembreService membreService = null;
	private static Membre membreTest = null;
	
	public TestMembreService(){
		
	}
	
	public TestMembreService(String testName){
		super(testName);
		

		
	}
	
	@Before
	public void setUp() throws Exception {
		
		sessionFactory = HibernateUtil.getSessionFactory();
		membreService = new MembreService();
		
		if (membreTest == null) {
		membreTest = new Membre("membretest", "mtest", "12345", "mtest@gmail.com", new Date());
		}
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCreateMembre() throws Exception {
		
		//Creer un jeu de tests (arrange)
		//Membre membre = new Membre("Test membre", "tmembre", "12345", "test@test.fr", new Date());
		
		// action
		membreTest = membreService.createMembre(membreTest);
		Membre membreCree = membreService.getMembreFromId(membreTest.getId());
				
		// assert
		assertNotEquals(0, membreTest.getId());
		
		assertEquals(membreTest.getNom(), membreCree.getNom());
		assertEquals(membreTest.getPseudo(), membreCree.getPseudo());
		assertEquals(membreTest.getMdp(), membreCree.getMdp());
		assertEquals(membreTest.getEmail(), membreCree.getEmail());
		assertEquals(membreTest.getDateInscription().getDate(), membreCree.getDateInscription().getDate());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetMembreFromId() throws Exception {

		// action
		
		Membre membreFromId = membreService.getMembreFromId(membreTest.getId());
				
		// assert
		assertEquals(membreFromId.getNom(), membreTest.getNom());
		assertEquals(membreFromId.getPseudo(), membreTest.getPseudo());
		assertEquals(membreFromId.getMdp(), membreTest.getMdp());
		assertEquals(membreFromId.getEmail(), membreTest.getEmail());
		assertEquals(membreFromId.getDateInscription().getDate(), membreTest.getDateInscription().getDate());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateMembre() throws Exception{
		
		//Creer un jeu de tests (arrange)
		
		Date newDate = new Date("2019/11/04");
		//Membre membre = new Membre("membre apres update", "tupdate", "5623", "test_u@test.fr", newDate);
		//membre.setId(4);
		membreTest.setNom("membre test update");
		membreTest.setPseudo("membre_test_update");
		membreTest.setMdp("7894");
		membreTest.setEmail("update@olk.com");
		membreTest.setDateInscription(newDate);
		
		// action
		membreService.updateMembre(membreTest);
		Membre membreUpdate = membreService.getMembreFromId(membreTest.getId());
		
		// assert
		assertEquals(membreUpdate.getNom(), membreTest.getNom());
		assertEquals(membreUpdate.getPseudo(), membreTest.getPseudo());
		assertEquals(membreUpdate.getMdp(), membreTest.getMdp());
		assertEquals(membreUpdate.getEmail(), membreTest.getEmail());
		assertEquals(membreUpdate.getDateInscription().getDate(), membreTest.getDateInscription().getDate());
	}
	
	@Test
	public void testGetAllMembres() throws Exception {

		// action
		List <Membre> membres = membreService.getAllMembres();
				
		// assert
		assertEquals(membres.size(), 3);
		
	}
	@Test
	public void testDeleteMember() throws Exception {
		
		//Creer un jeu de tests (arrange)
		//int id = 3;
		//Membre membre = null;
		
		// action
		//membre = membreService.getMembreFromId(id);
		membreService.deleteMembre(membreTest);
		membreTest = membreService.getMembreFromId(membreTest.getId());
		
		// assert
		assertNull(membreTest);
		
	}
	
	public static junit.framework.Test suite() {
		
		TestSuite suite = new TestSuite("Suite TestMemberService");
		
		suite.addTest(new TestMembreService("testCreateMembre"));
		suite.addTest(new TestMembreService("testGetMembreFromId"));
		suite.addTest(new TestMembreService("testUpdateMembre"));	
		suite.addTest(new TestMembreService("testGetAllMembres"));	
		suite.addTest(new TestMembreService("testDeleteMember"));
		
		return suite;
	}

}
