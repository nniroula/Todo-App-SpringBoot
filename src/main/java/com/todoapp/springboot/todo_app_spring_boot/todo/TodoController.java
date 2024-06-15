package com.todoapp.springboot.todo_app_spring_boot.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	//private TodoService todoService;
	private TodoService todoService = new TodoService();
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {  // ModelMap is needed to send data to jsp file
		// create a list of todos
		List<Todo> todos = todoService.findByUsername("in28minutes");
		model.addAttribute("todosData", todos);
		
		return "list-todos";  // it's a jsp file
	}
}
