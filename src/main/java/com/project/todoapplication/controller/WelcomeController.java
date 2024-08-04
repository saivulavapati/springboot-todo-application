package com.project.todoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.todoapplication.service.AuthenticatedUser;


@Controller
public class WelcomeController {
	
	@Autowired
	private AuthenticatedUser authenticatedUser;
	
	@RequestMapping("/")
	public String welcomePage(Model model) {
		model.addAttribute("userName", authenticatedUser.getUserName().toUpperCase());
		return "welcome";
	}

}
