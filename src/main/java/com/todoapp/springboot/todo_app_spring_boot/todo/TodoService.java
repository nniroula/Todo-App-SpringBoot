package com.todoapp.springboot.todo_app_spring_boot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

// store todos in database - h2 and MySQL. For now, store in a list

@Service
public class TodoService {
	//private static List<Todo> todos;
	private static List<Todo> todos = new ArrayList<>(); // list to hold tods
	
	// variable to count todos
	private static int todosCount = 0;
	
	// to initialize a static variable, user static block
	static {
		todos.add(new Todo(++todosCount, "nabin", "Learn Java Full Stack", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "in28minutes", "Learn Accountancy", LocalDate.now().plusYears(3), false));
	}
	
	// given a user with username, return his todos
	public List<Todo> findByUsername(String username){
		// for now, return all todos
		return todos;
	}
	
	// add todo
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo); // now go to addNewTodo method in TodoController and add ModelMap
	}
	
	// delete by Id
	public void deleteById(int id) {
		Predicate<?super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
}
