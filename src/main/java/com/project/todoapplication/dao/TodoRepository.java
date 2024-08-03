package com.project.todoapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todoapplication.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	 List<Todo> findByUserName(String name);

}
