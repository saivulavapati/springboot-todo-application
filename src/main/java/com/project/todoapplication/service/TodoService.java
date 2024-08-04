package com.project.todoapplication.service;

import java.util.List;

import com.project.todoapplication.entities.Todo;

public interface TodoService {

	public List<Todo> getAllTodos(String name);

	public void addNewTodo(Todo todo);

	public void deleteTodo(int id);

	public Todo findTodoById(int id);

	public void updateTodo(Todo todo);

}