package com.project.todoapplication.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	private String userName;
	
	@Size(min = 5,message = "Enter atleast 5 Characters")
	private String description;
	private LocalDate targetDate;
	private boolean completed;

	public Todo() {

	}

	
	
	public Todo(int id, String userName, @Size(min = 5, message = "Enter atleast 5 Characters") String description,
			LocalDate targetDate, boolean completed) {
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.targetDate = targetDate;
		this.completed = completed;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}



	@Override
	public String toString() {
		return "Todo [id=" + id + ", userName=" + userName + ", description=" + description + ", targetDate="
				+ targetDate + ", completed=" + completed + "]";
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

	

}
