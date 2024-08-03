package com.project.todoapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.todoapplication.service.AuthenticationService;


@Controller
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String welocme(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(authenticationService.authenticateUser(name, password)){
			String userName = authenticationService.getUserName();
			model.put("name", userName);
			model.put("password", password);
			return "welcome";
		}
		model.put("errorMessage","Invalid Credentials");
		return "login";
	}

}
