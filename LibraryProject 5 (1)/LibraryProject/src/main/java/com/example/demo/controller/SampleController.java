package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.entity.ResponseBean;
import com.example.demo.exception.BookException;
import com.example.demo.repository.BookR;
import com.example.demo.service.ServiceSample;

@RestController
@RequestMapping("/api")
public class SampleController {
	
	@Autowired
	private ServiceSample bookService;

  
 
    @PostMapping("/books")
    public ResponseEntity<Response> addBook(@RequestBody Book bookDetails) {
        ResponseBean<Response> response = bookService.addBookDetails(bookDetails);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") int id) {
        try {
            ResponseBean<Response> response = bookService.getBookDetails(id);
            if (response.isSuccess()) {
                return ResponseEntity.ok(response.getData());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (BookException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found");
        }  catch (Exception ex) {
            ex.printStackTrace(); // Log or handle the exception appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


@ExceptionHandler(BookException.class)
public ResponseEntity<String> handleBookNotFoundException(BookException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}

}