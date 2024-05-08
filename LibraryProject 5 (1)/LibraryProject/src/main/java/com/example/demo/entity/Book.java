package com.example.demo.entity;

public class Book {
	
	
	private int id;
	private String name;
	private String author;
	private String description;
	private int rating;
	
	public Book(int id, String name, String author, String description, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
		this.rating = rating;
	}
	public Book() {
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
