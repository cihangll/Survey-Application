package com.byporti.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byporti.spring.web.pojo.Survey;
import com.byporti.spring.web.service.SurveysService;

@Controller
public class HomeController {

	// private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private SurveysService surveysService;

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {

		List<Survey> surveys = surveysService.getSurveys();

		model.addAttribute("surveys", surveys);

		// Giriş yapan kişinin survey'i varmı yokmu kontrol
		boolean hassurvey = false;
		// giriş yapmış ise
		if (principal != null) {
			// o Kullanıcının teklifi varmı yokmu diye boolean değeri geri
			// aldık.
			hassurvey = surveysService.hasSurvey(principal.getName());
		}

		model.addAttribute("hassurvey", hassurvey);

		return "home";
	}
}
