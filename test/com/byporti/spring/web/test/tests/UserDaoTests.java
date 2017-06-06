package com.byporti.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

import com.byporti.spring.web.dao.UsersDao;
import com.byporti.spring.web.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/byporti/spring/web/test/config/datasource.xml",
		"classpath:com/byporti/spring/web/config/dao-context.xml",
		"classpath:com/byporti/spring/web/config/security-context.xml" })
@ActiveProfiles("testProfile")
public class UserDaoTests {

	private JdbcTemplate jdbc;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource datasource;

	private User user1 = new User("byporti", "explatasdqwe123", "ROLE_USER", "Cihan Güllü", "Explat54@gmail.com", true);
	private User user2 = new User("putnam", "putnam123", "ROLE_USER", "Ahmet Almaz", "putnam12@gmail.com", true);
	private User user3 = new User("rapunzel", "rapunzel123", "ROLE_USER", "Yakup Yalçın", "ya--kup--@gmail.com", true);
	private User user4 = new User("rattata", "rattata123", "ROLE_USER", "Umut Yüksel", "umutyuksel@gmail.com", false);

	@Before
	public void init() {
		jdbc = new JdbcTemplate(datasource);

		// Her testten önce temiz bir database e sahip olalım.
		jdbc.execute("delete from offers");
		jdbc.execute("delete from messages");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateRetrieve() {
		usersDao.create(user1);

		List<User> users1 = usersDao.getAllUsers();
		assertEquals("Toplamda 1 User alınmış olmalı.", 1, users1.size());

		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);

		List<User> users2 = usersDao.getAllUsers();
		assertEquals("Toplamda 4 User alınmış olmalı.", 4, users2.size());
	}

	@Test
	public void testExists() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);

		assertTrue("putnam adında user olmalı.", usersDao.exists(user2.getUsername()));
		assertFalse("asdqwe123 adında user olmamalı.", usersDao.exists("asdqwe123"));
	}

}
