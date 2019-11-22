package fr.hb.tpblogrecette.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.hb.tpblogrecette.model.Tag;
import fr.hb.tpblogrecette.services.TagService;
import fr.hb.tpblogrecette.utils.HibernateUtil;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.util.Date;
import java.util.List;

public class TestTagService extends TestCase{


	private static SessionFactory sessionFactory = null;
	private static TagService tagService = null;
	private static Tag tagTest = null;

	public TestTagService() throws Exception {

	}

	public TestTagService(String testName){
		super(testName);



	}

	@Before
	public void setUp() throws Exception {

		sessionFactory = HibernateUtil.getSessionFactory();
		tagService = new TagService();

		if (tagTest == null) {
			tagTest = new Tag("épicé");
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateTag() throws Exception {

		// action
		tagTest = tagService.createTag(tagTest);
		Tag tagCree = tagService.getTagFromId(tagTest.getId());

		// assert
		assertNotEquals(0, tagTest.getId());

		assertEquals(tagTest.getNom(), tagCree.getNom());

	}

	@Test
	public void testGetTagFromId() throws Exception {

		// action

		Tag tagFromId = tagService.getTagFromId(tagTest.getId());

		// assert

		assertEquals(tagFromId.getNom(), tagTest.getNom());

	}

	@Test
	public void testGetAllTags() throws Exception {

		// action
		List <Tag> tags = tagService.getAllTags();

		// assert
		assertEquals(tags.size(), 1);

	}

	@Test
	public void testUpdateTag() throws Exception {

		//Creer un jeu de tests (arrange)
		Date newDate = new Date("2019/11/04");



		tagTest.setNom("delicieux");


		// action
		tagService.updateTag(tagTest);
		Tag tagUpdate = tagService.getTagFromId(tagTest.getId());

		// assert

		assertEquals(tagUpdate.getNom(), tagTest.getNom());

	}

	@Test
	public void testDeleteTag() throws Exception {

		//Creer un jeu de tests (arrange)
		tagService.deleteTag(tagTest);
		tagTest = tagService.getTagFromId(tagTest.getId());

		// assert
		assertNull(tagTest);

	}

	public static junit.framework.Test suite() throws Exception {

		TestSuite suite = new TestSuite("Suite TestTagService");

		suite.addTest(new TestTagService("testCreateTag"));
		suite.addTest(new TestTagService("testGetTagFromId"));	
		suite.addTest(new TestTagService("testUpdateTag"));	
		suite.addTest(new TestTagService("testGetAllTags"));
		suite.addTest(new TestTagService("testDeleteTag"));

		return suite;
	}
}
