package com.byporti.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.byporti.spring.web.dao.SurveysDao;
import com.byporti.spring.web.dao.UsersDao;
import com.byporti.spring.web.pojo.Survey;
import com.byporti.spring.web.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/byporti/spring/web/test/config/datasource.xml",
		"classpath:com/byporti/spring/web/config/dao-context.xml",
		"classpath:com/byporti/spring/web/config/security-context.xml" })
@ActiveProfiles("testProfile")
public class SurveysDaoTests {

	@Autowired
	private SurveysDao surveysDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbc;

	private User user1 = new User("byporti", "explatasdqwe123", "ROLE_USER", "Cihan Güllü", "Explat54@gmail.com", true);
	private User user2 = new User("putnam", "putnam123", "ROLE_USER", "Ahmet Almaz", "putnam12@gmail.com", true);
	private User user3 = new User("rapunzel", "rapunzel123", "ROLE_USER", "Yakup Yalçın", "ya--kup--@gmail.com", true);
	private User user4 = new User("rattata", "rattata123", "ROLE_USER", "Umut Yüksel", "umutyuksel@gmail.com", false);

	private Survey survey1 = new Survey(user1, "This is a test survey.", "aaa");
	private Survey survey2 = new Survey(user1, "This is another test survey.", "aaa");
	private Survey survey3 = new Survey(user2, "This is yet another test survey.", "aaa");
	private Survey survey4 = new Survey(user3, "This is a test survey once again.", "aaa");
	private Survey survey5 = new Survey(user3, "Here is an interesting survey of some kind.", "aaa");
	private Survey survey6 = new Survey(user3, "This is just a test survey.", "aaa");
	private Survey survey7 = new Survey(user4, "This is a test survey for a user that is not enabled.", "aaa");

	@Before
	public void init() {
		jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from surveys");
		jdbc.execute("delete from users");
	}

	@Test
	public void testSaveOrUpdate() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);

		surveysDao.saveOrUpdate(survey1);

		List<Survey> surveys1 = surveysDao.getSurveys();
		assertEquals("Toplamda eklenmiş 1 survey olmalı.", 1, surveys1.size());

		surveysDao.saveOrUpdate(survey2);
		surveysDao.saveOrUpdate(survey3);
		surveysDao.saveOrUpdate(survey4);
		surveysDao.saveOrUpdate(survey5);
		surveysDao.saveOrUpdate(survey6);
		surveysDao.saveOrUpdate(survey7);

		List<Survey> surveys2 = surveysDao.getSurveys();
		assertEquals("Enabled userların toplamda 6 survey'i olmalı.", 6, surveys2.size());
	}

	@Test
	public void testGetSurveysWithUsername() {

		usersDao.create(user2);
		usersDao.create(user3);

		surveysDao.saveOrUpdate(survey3);
		surveysDao.saveOrUpdate(survey4);
		surveysDao.saveOrUpdate(survey5);
		surveysDao.saveOrUpdate(survey6);

		List<Survey> surveys1 = surveysDao.getSurveys(user3.getUsername());
		assertEquals("Bu user(rapunzel) 3 survey'a sahip olmalı.", 3, surveys1.size());

		List<Survey> surveys2 = surveysDao.getSurveys("asdqwe123");
		assertEquals("Bu isme ait kullanıcının survey'i olmamalı.", 0, surveys2.size());

		List<Survey> surveys3 = surveysDao.getSurveys(user2.getUsername());
		assertEquals("Bu user(putnam) 1 survey'a sahip olmalı.", 1, surveys3.size());

	}

	@Test
	public void testGetSurveyWithId() {

		usersDao.create(user1);
		usersDao.create(user4);

		surveysDao.saveOrUpdate(survey1);
		surveysDao.saveOrUpdate(survey7);

		Survey retrieved1 = surveysDao.getSurvey(survey1.getId());
		assertEquals("Survey ile eşleşmeli.", survey1, retrieved1);

		// Boş değer dönmeli.
		Survey retrieved2 = surveysDao.getSurvey(survey7.getId());
		assertNull("Bu kullanıcıya erişim olmamalı.Çünkü disabled user.", retrieved2);
	}

	@Test
	public void testUpdate() {
		usersDao.create(user2);

		surveysDao.saveOrUpdate(survey3);

		survey3.setName("UPDATED SURVEY NAME");
		surveysDao.saveOrUpdate(survey3);

		Survey retrieved = surveysDao.getSurvey(survey3.getId());
		assertEquals("Retrieved survey update edilmiş olmalı.", survey3, retrieved);
	}

	@Test
	public void testDelete() {
		usersDao.create(user1);

		surveysDao.saveOrUpdate(survey2);

		Survey retrieved1 = surveysDao.getSurvey(survey2.getId());
		assertNotNull(retrieved1.getId() + " id değerine sahip survey olmalı.(Silinmemiş, Bulunan)", retrieved1);

		surveysDao.delete(survey2.getId());

		Survey retrieved2 = surveysDao.getSurvey(survey2.getId());
		assertNull(retrieved1.getId() + " id değerine sahip survey OLMAMALI!.(Silinmiş, Bulanamayan)", retrieved2);
	}

}
