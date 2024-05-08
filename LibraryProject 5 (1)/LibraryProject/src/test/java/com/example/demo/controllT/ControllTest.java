package com.example.demo.controllT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.example.demo.controller.SampleController;
import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.entity.ResponseBean;
import com.example.demo.exception.BookException;
import com.example.demo.repository.BookR;
import com.example.demo.service.ServiceSample;


public class ControllTest {
	
	
	@Mock // Inject bookService using Spring
    private ServiceSample bookService;

    @InjectMocks // Inject mocks into bookController
    private SampleController bookController;

	    
	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this); // Initialize mocks
	    }
	    
	    @Test
	    void testAddBook_Success() {
	        // Arrange
	        Book book = new Book(1, "Kiran", "Richard", "best Book", 4);
	        Response response = new Response(1, "Kiran", "Richard", "best Book", 4);
	        ResponseBean<Response> successResponse = ResponseBean.of(response);
	        when(bookService.addBookDetails(book)).thenReturn(successResponse);

	        // Act
	        ResponseEntity<Response> result = bookController.addBook(book);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.OK, result.getStatusCode());
	        assertEquals(response, result.getBody());
	        verify(bookService, times(1)).addBookDetails(book);
	    }
	    @Test
	    void testAddBook_Failure() {
	        // Arrange
	        Book book = new Book(1, "Kiran", "Richard", "best Book", 4);
	       // Response response = new Response(1, "Kiran", "Richard", "best Book", 4);
	        ResponseBean<Response> failureResponse = ResponseBean.error("Error message", null);
	        when(bookService.addBookDetails(book)).thenReturn(failureResponse);

	        // Act
	        ResponseEntity<Response> result = bookController.addBook(book);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
	        verify(bookService, times(1)).addBookDetails(book);
	    }

	    @Test
	    void testGetBook_Success() {
	        // Arrange
	        int bookId = 1;
	        
	        Response response = new Response(1, "Srini", "Richa", "best Book", 4);
	        ResponseBean<Response> successResponse = ResponseBean.of(response);
	        when(bookService.getBookDetails(bookId)).thenReturn(successResponse);

	        // Act
	        ResponseEntity<?> result = bookController.getBook(bookId);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.OK, result.getStatusCode());
	        assertEquals(response, result.getBody());
	        verify(bookService, times(1)).getBookDetails(bookId);
	    }

	    @Test
	    void testGetBook_NotFound() {
	        // Arrange
	        int bookId = 1;
	        when(bookService.getBookDetails(bookId)).thenThrow(new BookException("Book not found"));

	        // Act
	        ResponseEntity<?> result = bookController.getBook(bookId);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
	        verify(bookService, times(1)).getBookDetails(bookId);
	    }
//	    @Test
//	    void testGetBook_InternalServerError() {
//	        // Arrange
//	        int bookId = 1;
//	        when(bookService.getBookDetails(bookId)).thenThrow(new RuntimeException("Internal Server Error"));
//
//	        // Act
//	        ResponseEntity<?> result = bookController.getBook(bookId);
//
//	        // Assert
//	        assertNotNull(result);
//	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
//	    }
	    


	    @Test
	    void testGetBook_HttpServerErrorInternalError() {
	        // Arrange
	        int bookId = 1;
	        when(bookService.getBookDetails(bookId)).thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

	        // Act
	        ResponseEntity<?> result = bookController.getBook(bookId);

	        // Assert
	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
	        assertEquals("Internal Server Error", result.getBody());
	    }
}
