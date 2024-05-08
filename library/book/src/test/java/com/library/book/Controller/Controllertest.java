package com.library.book.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.library.book.Entity.Book;
import com.library.book.Entity.Response;
import com.library.book.Entity.ResponseBean;
import com.library.book.Service.LibraryService;

public class Controllertest {
@Mock // Inject bookService using Spring
    private LibraryService service;

    @InjectMocks // Inject mocks into bookController
    private LibraryController bookController;

	    
	    @SuppressWarnings("deprecation")
        @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this); // Initialize mocks
	    }
	    
	    @Test
	    void testUploadBook_Success() {
	        // Arrange
	        Book book = new Book(1, "And there were None", "Agatha Christie", "Suspense thriller", 4);
	        Response response = new Response(1, "And there were None", "Agatha Christie", "Suspense thriller", 4);
	        ResponseBean<Response> successResponse = ResponseBean.of(response);
	        when(service.uploadBookDetails(book)).thenReturn(successResponse);

	        // Act
	        ResponseEntity<Response> result = bookController.addBook(book);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.OK, result.getStatusCode());
	        assertEquals(response, result.getBody());
	        verify(service, times(1)).uploadBookDetails(book);
	    }
        @Test
	    void testAddBook_Failure() {
	        // Arrange
	        Book book = new Book(1, "And there were None", "Agatha Christie", "Suspense thriller", 4);
	       // Response response = new Response(1, "Kiran", "Richard", "best Book", 4);
	        ResponseBean<Response> failureResponse = ResponseBean.error("Error message", null);
	        when(service.uploadBookDetails(book)).thenReturn(failureResponse);

	        // Act
	        ResponseEntity<Response> result = bookController.addBook(book);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
	        verify(service, times(1)).uploadBookDetails(book);
	    }
        @Test
	    void testGetBook_Success() throws Exception {
	        // Arrange
	        int bookId = 1;
	        
	        Response response = new Response(1, "Angels and Demons", "Dan Browm", "best Book", 4);
	        ResponseBean<Response> successResponse = ResponseBean.of(response);
	        when(service.getBookDetails(bookId)).thenReturn(successResponse);

	        // Act
	        ResponseEntity<?> result = bookController.getBook(bookId);

	        // Assert
	        assertNotNull(result);
	        assertEquals(HttpStatus.OK, result.getStatusCode());
	        assertEquals(response, result.getBody());
	        verify(service, times(1)).getBookDetails(bookId);
	    }
}
