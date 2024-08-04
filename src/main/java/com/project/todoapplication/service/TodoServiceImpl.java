package com.project.todoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoapplication.dao.TodoRepository;
import com.project.todoapplication.entities.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAllTodos(String name){
		List<Todo> list = todoRepository.findByUserName(name);
		return list;
	}

	@Override
	public void addNewTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public void deleteTodo(int id) {
		Todo todo = todoRepository.findById(id).get();
		todoRepository.delete(todo);
	}

	@Override
	public Todo findTodoById(int id) {
		return todoRepository.findById(id).get();
	}

	@Override
	public void updateTodo(Todo todo) {
		Todo orginalTodo = todoRepository.findByUserName(todo.getUserName()).get(0);
		orginalTodo.setDescription(todo.getDescription());
		orginalTodo.setTargetDate(todo.getTargetDate());
		orginalTodo.setCompleted(todo.getCompleted());
		todoRepository.save(orginalTodo);
	}
	
	

}
