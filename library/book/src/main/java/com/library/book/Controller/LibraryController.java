package com.library.book.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.Entity.Book;
import com.library.book.Entity.Response;
import com.library.book.Entity.ResponseBean;
import com.library.book.Service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    
    @PostMapping("/upload")
    public ResponseEntity<Response> addBook(@RequestBody Book bookDetails) {
        ResponseBean<Response> response = libraryService.uploadBookDetails(bookDetails);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
  
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") int id) throws Exception {
            ResponseBean<Response> response = libraryService.getBookDetails(id);
            if (response.isSuccess()) {
                return ResponseEntity.ok(response.getData());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
}
