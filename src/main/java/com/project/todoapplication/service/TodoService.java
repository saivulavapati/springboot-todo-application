package com.project.todoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoapplication.dao.TodoRepository;
import com.project.todoapplication.entities.Todo;

@Service
public class TodoService {
	
	private static int todosCount = 0;
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> getAllTodos(String name){
		List<Todo> list = todoRepository.findByUserName(name);
		return list;
	}

	public void addNewTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public void deleteTodo(int id) {
		Todo todo = todoRepository.findById(id).get();
		todoRepository.delete(todo);
	}

	public Todo findTodoById(int id) {
		return todoRepository.findById(id).get();
	}

	public void updateTodo(Todo todo) {
		Todo orginalTodo = todoRepository.findByUserName(todo.getUserName()).get(0);
		orginalTodo.setDescription(todo.getDescription());
		orginalTodo.setTargetDate(todo.getTargetDate());
		orginalTodo.setCompleted(todo.getCompleted());
		todoRepository.save(orginalTodo);
	}
	
	

}
