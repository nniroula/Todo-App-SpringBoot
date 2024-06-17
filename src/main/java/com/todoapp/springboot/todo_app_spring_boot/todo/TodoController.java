package com.todoapp.springboot.todo_app_spring_boot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	/*
	// add todo - GET method
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage() {  
		return "todo";  // it's a jsp file
	}
	*/
	// add new attribute to use form tag library 
	// add todo - GET method
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {  
		String username = (String) model.get("uname");
		Todo todo = new Todo(0, username, " ", LocalDate.now().plusYears(1), false); // hard coded values
		// putting todo bean into model binds whatever is value here to the jsp file form "todo" attribute
		model.put("todoinjsp", todo); // first todo is from jsp file form
		return "todo";  	
	}
	
	/*
	// add todo - POST method
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model) {  
		String username = (String) model.get("uname");
		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
		// once added a todo, redirect to list-todos page
		return "redirect:list-todos";  
	}
	*/
	
	// instead of above logic, directly bind description to the todo bean
	// OR, instead of binding to model map, bind description directly to todo bean
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		// use result
		if(result.hasErrors()) {
			// fix the error to return todo.jsp - Neither BindingResult nor plain target object for bean name 'todoinjsp' available as request attribute
			//model.put("todoinjsp", new Todo(0, "", "default description", LocalDate.now().plusYears(1), false));
			return "todo";
			//return "list-todos";
		}
		
		String username = (String) model.get("uname");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		// once added a todo, redirect to list-todos page
		return "redirect:list-todos";  
	}
	
	// delete todo - get link from jsp file to use with RequestMapping
	@RequestMapping("delete-todo") //delete-todo?id from list-todos.jsp
	public String deleteTodo(@RequestParam int id) { // request param to grab id frim the query string
		//delete todo and redirect back to list of todos
		
		//redirect to list-todos jsp page
		return "redirect:list-todos";
		
	}
	
	
}
