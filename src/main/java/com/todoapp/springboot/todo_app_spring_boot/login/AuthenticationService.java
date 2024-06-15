package com.todoapp.springboot.todo_app_spring_boot.login;

import org.springframework.stereotype.Service;

// authenticate a user. Use this authentication service in LoginController class
@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		//hard coded username and password
		String uName = "in28minutes";
		String passPhrase = "dummy";
		
		//logic 
		boolean isValidUserName = username.equalsIgnoreCase(uName);
		boolean isValidPassword = password.equalsIgnoreCase(passPhrase);
		
		return isValidUserName && isValidPassword;
	}
}
