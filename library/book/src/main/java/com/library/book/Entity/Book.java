package com.library.book.Entity;

import lombok.Data;

@Data
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
}
