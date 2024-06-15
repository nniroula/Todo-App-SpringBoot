package com.todoapp.springboot.todo_app_spring_boot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("uname")  // uname comes from html form input attribute -> name="uname"
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
	
	// add todo - GET method
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage() {  
		return "todo";  // it's a jsp file
	}
	
	// add todo - POST method
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model) {  
		String username = (String) model.get("uname");
		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
		// once added a todo, redirect to list-todos page
		return "redirect:list-todos";  
	}
}
