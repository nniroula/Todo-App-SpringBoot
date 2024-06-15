package com.todoapp.springboot.todo_app_spring_boot.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	// use logger instead of system.out.println statements
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// need url
	@RequestMapping("/login-jsp")
	@ResponseBody
	public String login() {
		return "yet to log in";
	}

	/*
	// now return jsp file
	@RequestMapping("/login")
	public String gotoLoginPage() {
		return "login"; // login is a login.jsp file
	}
	*/
	
	// now use html form for user name and password
	// now return jsp file
	//@RequestMapping("/login")
	// tell that it handles only GET, not POST
	
	//1.
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login"; // login is a login.jsp file
	}
	
	//2.
	// for post request
	/*
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String gotoWelcomePage() {
		return "welcome"; // login is a login.jsp file
	}
	*/
	
	//3.
	//capture form data from login page and render it on welcome page
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String uname, @RequestParam String pass, ModelMap model) {
		model.put("uname", uname);
		model.put("pass", pass);
		return "welcome"; // login is a login.jsp file
	}
	
	// Query String in jsp
	// request url is http://localhost:8080/login?name=nabin
	@RequestMapping("/loginQuery")
	public String getLoginQueryString(@RequestParam String name) {
		System.out.println("############################################"); // never use sysout in production code
		System.out.println("******************* Request Param is " + name);
		
		// now use logger instead of sys out statements
		logger.debug("Request param from logger is {}", name);
		return "login"; // login is a login.jsp file
	}
	
	
	// pass the name value from query string to view(jsp file, that is to login.jsp file)
	@RequestMapping("/loginUsingModel")
	public String sendDataFromControllerToView(@RequestParam String name, ModelMap model) {
		// use model to place data(name in this case) on jsp page
		model.put("name", name);
		return "login"; // login is a login.jsp file
	}

}
