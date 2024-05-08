package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.entity.ResponseBean;
import com.example.demo.exception.BookException;
import com.example.demo.repository.BookR;

@Service
public class ServiceSample {

    @Autowired
    BookR bookRepository;

    public ResponseBean<Response> addBookDetails(Book bookDetails) {
        
        ResponseBean<Response> response = bookRepository.saveBook(bookDetails);

        if (response.isSuccess()) {
        	
            return ResponseBean.of(response.getData());
        } else {
        
            return ResponseBean.error(response.getMessage(), "Failed to add book");
        }
    }

    public ResponseBean<Response> getBookDetails(int id) {
        ResponseBean<Response> response = bookRepository.getBookById(id);

        if (response.isSuccess()) {
            return ResponseBean.of(response.getData());
        } else {
   
            throw new BookException("Book not found");
        }
    }
}






