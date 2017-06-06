package com.byporti.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.byporti.spring.web.dao.SurveysDao;
import com.byporti.spring.web.pojo.Survey;

@Service("surveysService")
public class SurveysService {

	private SurveysDao surveysDao;

	@Autowired
	public void setSurveysDao(SurveysDao surveysDao) {
		this.surveysDao = surveysDao;
	}

	public String getSurveyJsonValue(String username) {
		return getSurvey(username).getJson();
	}

	public List<Survey> getSurveys() {
		return surveysDao.getSurveys();
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Survey survey) {
		surveysDao.saveOrUpdate(survey);
	}

	public boolean hasSurvey(String name) {

		if (name == null) {
			return false;
		}

		List<Survey> surveys = surveysDao.getSurveys(name);
		if (surveys.size() == 0) {
			return false;
		}
		return true;
	}

	public Survey findbyid(int id) {
		return surveysDao.getSurvey(id);
	}

	public Survey getSurvey(String username) {

		if (username == null) {
			return null;
		}
		List<Survey> surveys = surveysDao.getSurveys(username);
		if (surveys.size() == 0) {
			return null;
		}

		return surveys.get(0);
	}

	public void saveOrUpdate(Survey survey) {
		surveysDao.saveOrUpdate(survey);
	}

	public void delete(int id) {
		surveysDao.delete(id);
	}
}
