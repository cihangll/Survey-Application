package com.byporti.spring.web.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.byporti.spring.web.pojo.Survey;
import com.byporti.spring.web.service.SurveysService;

@Controller
public class SurveyPageController {

	private SurveysService surveysService;

	@Autowired
	public void setSurveysService(SurveysService surveysService) {
		this.surveysService = surveysService;
	}

	@RequestMapping("/surveyPage")
	public String showSurveyPage(Model model, Principal principal) {

		if (principal != null) {
			String surveyJsonVal = surveysService.getSurveyJsonValue(principal.getName());
			// System.out.println(surveyJsonVal);
			model.addAttribute("surveyJsonVal", surveyJsonVal);
		}
		return "surveyPage";
	}

	@RequestMapping(value = "/surveys/{id}", method = RequestMethod.GET)
	public String showSurvey(@PathVariable("id") int id, Model model, Principal principal) {

		Survey survey = surveysService.findbyid(id);
		if (principal != null) {
			String surveyJsonVal = survey.getJson();
			model.addAttribute("surveyJsonVal", surveyJsonVal);
		}

		return "surveyPage";

	}
}
