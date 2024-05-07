package com.library.book.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.Entity.Book;
import com.library.book.Entity.Response;
import com.library.book.Entity.ResponseBean;
import com.library.book.Repository.LibraryRepo;

@Service
public class LibraryService {
    @Autowired
    LibraryRepo libraryRepo;

    public ResponseBean<Response> uploadBookDetails(Book bookDetails) {
        
        ResponseBean<Response> response = libraryRepo.uploadBook(bookDetails);

        if (response.isSuccess()) {
        	
            return ResponseBean.of(response.getData());
        } else {
        
            return ResponseBean.error(response.getMessage(), "Failed to upload book");
        }
    }
    public ResponseBean<Response> getBookDetails(int id) throws Exception {
        ResponseBean<Response> response = libraryRepo.getBookById(id);

        if (response.isSuccess()) {
            return ResponseBean.of(response.getData());
        } else {
   
            throw new Exception("Book not found");
        }
    }
}
