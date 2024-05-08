package com.example.demo.exception;

public class BookException extends RuntimeException{

	
	private static final long serialVersionUID = 1;

	public BookException(String message) {
        super(message);
    }
}
