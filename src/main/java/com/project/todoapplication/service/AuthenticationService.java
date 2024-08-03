package com.project.todoapplication.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticateUser(String name, String password) {
		boolean isNameAuthenticated = name.equalsIgnoreCase("sai");
		boolean isPasswordAuthenticated = password.equalsIgnoreCase("password");

		return isNameAuthenticated && isPasswordAuthenticated;
	}
	
	public String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
