package com.assignment.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.library.Model.Book;
import com.assignment.library.Service.bookService;

@RestController
@RequestMapping("/library")
public class bookController {
	@Autowired
	bookService BookService;
	
	@PostMapping("/uploadBooks")
	public Book addBook(@RequestBody Book book) {
		return BookService.addBook(book);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		return  BookService.getBookById(id);
	}
	
}
