package com.todoapp.springboot.todo_app_spring_boot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	// url = say-hello and message displayed = Hello! What are you learning today
	
	@RequestMapping("/say-hello")  		// url is http://localhost:8080/say-hello
	@ResponseBody					// this helps to render return statement to browser
	public String sayHello() { 
		return "Hello! What are you learning today";
	}
	
	// render html page
	@RequestMapping("/say-hello-html")  		// url is http://localhost:8080/say-hello-html
	@ResponseBody					// this helps to render return statement to browser
	public String sayHelloHtml() { 
		// return html page
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("My first HTML page in JAVA");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first HTML page using Spring boot");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	
	}
	
	// return html as string is very tedious. So, use view technology called jsp to render html page
	
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello"; // sayHello is a sayHello.jsp file
	}
}
