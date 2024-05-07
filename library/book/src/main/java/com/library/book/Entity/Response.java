package com.library.book.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
@JsonProperty("id")
    private int id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("author")
    private String author;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("rating")
    private int rating;
    
    public Response() {
        super();
    }

    @Override
	public String toString() {
		return "Response [id=" + id + ", name=" + name + ", author=" + author + ", description=" + description
				+ ", rating=" + rating + "]";
	}

	public Response(int id, String name, String author, String description, int rating) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.rating = rating;
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
