package com.nathan.web.jdbc;

public class Todo {
	private int id;
	public String description;
	
	
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


	
	
	public Todo(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Todo( String description) {
		
		this.description = description;
	}
	


	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + "]";
	}
	
	

}
