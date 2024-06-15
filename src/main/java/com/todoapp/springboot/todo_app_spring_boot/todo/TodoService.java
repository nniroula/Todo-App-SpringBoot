package com.todoapp.springboot.todo_app_spring_boot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

// store todos in database - h2 and MySQL. For now, store in a list

@Service
public class TodoService {
	//private static List<Todo> todos;
	private static List<Todo> todos = new ArrayList<>(); // list to hold tods
	
	// to initialize a static variable, user static block
	static {
		todos.add(new Todo(1, "nabin", "Learn Java Full Stack", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "in28minutes", "Learn Accountancy", LocalDate.now().plusYears(3), false));
	}
	
	// given a user with username, return his todos
	public List<Todo> findByUsername(String username){
		// for now, return all todos
		return todos;
	}
}
