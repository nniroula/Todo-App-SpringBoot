package com.todoapp.springboot.todo_app_spring_boot.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	// now return jsp file
	@RequestMapping("/login")
	public String gotoLoginPage() {
		return "login"; // login is a login.jsp file
	}
	
	// Query String in jsp
	// request url is http://localhost:8080/login?name=nabin
	@RequestMapping("/loginQuery")
	public String getLoginQueryString(@RequestParam String name) {
		System.out.println("############################################"); // never use sysout in production code
		System.out.println("******************* Request Param is " + name);
		
		// now use logger instead of sys out statements
		logger.debug("Request param is {}", name);
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
