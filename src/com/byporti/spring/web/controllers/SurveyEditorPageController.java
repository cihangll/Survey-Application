package com.byporti.spring.web.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyEditorPageController {

	@RequestMapping("/surveyEditorPage")
	public String showSurveyPage(Model model, Principal principal) {

		return "surveyEditorPage";
	}
}
