package com.byporti.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.byporti.spring.web.pojo.Survey;

@Repository
@Transactional
@Component("surveysDao")
public class SurveysDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	public Survey getSurvey(int id) {

		Criteria crit = session().createCriteria(Survey.class);

		crit.createAlias("user", "u");

		crit.add(Restrictions.idEq(id));
		crit.add(Restrictions.eq("u.enabled", true));
		return (Survey) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Survey> getSurveys() {

		Criteria crit = session().createCriteria(Survey.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Survey> getSurveys(String username) {
		Criteria crit = session().createCriteria(Survey.class);

		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	public void saveOrUpdate(Survey survey) {
		session().saveOrUpdate(survey);
	}

	public boolean delete(int id) {
		Query query = session().createQuery("delete from Survey where id=:id");
		query.setLong("id", id);

		return query.executeUpdate() == 1;
	}

}