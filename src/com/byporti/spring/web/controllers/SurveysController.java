package com.byporti.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.byporti.spring.web.pojo.Survey;
import com.byporti.spring.web.service.SurveysService;
import com.byporti.spring.web.validation.FormValidationGroup;

@Controller
public class SurveysController {

	private SurveysService surveysService;

	@Autowired
	public void setSurveysService(SurveysService surveysService) {
		this.surveysService = surveysService;
	}

	@RequestMapping("/createsurvey")
	public String createSurvey(Model model, Principal principal) {

		Survey survey = null;

		if (principal != null) {
			String username = principal.getName();

			survey = surveysService.getSurvey(username);
		}

		if (survey == null) {
			survey = new Survey();
		}

		model.addAttribute("survey", survey);
		return "createsurvey";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Validated(FormValidationGroup.class) Survey survey, BindingResult result,
			Principal principal, @RequestParam(value = "delete", required = false) String delete) {

		if (result.hasErrors()) {
			return "createsurvey";
		}

		if (delete == null) {
			String username = principal.getName();
			survey.getUser().setUsername(username);

			surveysService.saveOrUpdate(survey);

			return "surveycreated";
		} else {
			surveysService.delete(survey.getId());
			return "surveydeleted";
		}

	}
}
