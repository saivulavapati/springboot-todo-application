package com.project.todoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.todoapplication.entities.Todo;
import com.project.todoapplication.service.AuthenticationService;
import com.project.todoapplication.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value="/todos",method = RequestMethod.GET)
	public String todos(Model model) {
		List<Todo> allTodos = todoService.getAllTodos(authenticationService.getUserName());
		model.addAttribute("todosList",allTodos);
		model.addAttribute("userName",authenticationService.getUserName());
		return "todos";
	}
	
	@RequestMapping("/addTodo")
	public String addNewTodo(Todo todo,Model model) {
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="/addTodo", method = RequestMethod.POST)
	public String showTodos(@Valid Todo todo, BindingResult br,Model model) {
		if(br.hasErrors()) {
			return  "todo";
		}
		todo.setUserName(authenticationService.getUserName());
		todoService.addNewTodo(todo);
		todo.setUserName(authenticationService.getUserName());
		model.addAttribute(todo);
		return "redirect:todos";
	}
	
	@RequestMapping("deleteTodo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todos";
	}
	
	@RequestMapping("updateTodo")
	public String updateTodo(@RequestParam int id, Model model) {
		Todo todoById = todoService.findTodoById(id);
		model.addAttribute("todo", todoById);
		return "todo";
	}
	
	
	@RequestMapping(value="/updateTodo", method = RequestMethod.POST)
	public String showUpdateTodos(@Valid Todo todo, BindingResult br) {
		if(br.hasErrors()) {
			return  "todo";
		}
		todoService.updateTodo(todo);
		return "redirect:todos";
	}
	
	
	
	
}
