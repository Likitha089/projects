package com.example.demo.serviceT;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.entity.ResponseBean;
import com.example.demo.exception.BookException;
import com.example.demo.repository.BookR;
import com.example.demo.service.ServiceSample;

public class ServiceTest {
	
	
	@Mock
	BookR bookrepository;
	
	@InjectMocks
	ServiceSample bookservice	;
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }
	
	 @Test
	    public void testAddBook_Success() {
	        // Arrange
	        Book book = new Book(1, "Person", "author", "best Book", 4);
	        Response response = new Response(1, "Person", "author", "best Book", 4);
	        ResponseBean<Response> successResponse = ResponseBean.of(response);
	        when(bookrepository.saveBook(book)).thenReturn(successResponse);
	        
	        // Act
	        ResponseBean<Response> result = bookservice.addBookDetails(book);
	        
	        // Assert
	        assertTrue(result.isSuccess());
	        assertEquals(response, result.getData());
	        verify(bookrepository, times(1)).saveBook(book);
	    }
	 


	 @Test
	    public void testAddBook_Failure() {
	        // Arrange
		 Book book = new Book(1, "Person", "author", "best Book", 4);
	        Response response = new Response(1, "Person", "author", "best Book", 4);
	        String errorMessage = "Failed to add book";
	        ResponseBean<Response> failureResponse = ResponseBean.error(errorMessage, null);
	        when(bookrepository.saveBook(any())).thenReturn(failureResponse);
	        
	        // Act
	        ResponseBean<Response> result = bookservice.addBookDetails(book);
	        
	        // Assert
	        assertFalse(result.isSuccess());
	        assertEquals(errorMessage, result.getMessage());
	        verify(bookrepository, times(1)).saveBook(any());
	    }
	    
	    @Test
	    public void testGetBookDetails_Success() {
	        // Arrange
	        int bookId = 1;
	        Book book = new Book(1, "Person", "author", "best Book", 4);
	        Response response = new Response(1, "Person", "author", "best Book", 4);
	        ResponseBean<Response> successResponse = ResponseBean.of(response);
	        when(bookrepository.getBookById(bookId)).thenReturn(successResponse);
	        
	        // Act
	        ResponseBean<Response> result = bookservice.getBookDetails(bookId);
	        
	        // Assert
	        assertTrue(result.isSuccess());
	        assertEquals(response, result.getData());
	        verify(bookrepository, times(1)).getBookById(bookId);
	    }
	    
	    @Test
	    public void testGetBookDetails_Failure() {
	        // Arrange
	        int bookId = 1;
	        String errorMessage = "Book not found";
	        ResponseBean<Response> failureResponse = ResponseBean.error(errorMessage, null);
	        when(bookrepository.getBookById(bookId)).thenReturn(failureResponse);
	        
	        // Act & Assert
	        assertThrows(BookException.class, () -> bookservice.getBookDetails(bookId));
	        verify(bookrepository, times(1)).getBookById(bookId);
	    }
	    @Test
	    public void testAddBook_MissingDetails() {
	        // Arrange
	        Book bookDetails = new Book(1, null, "Author Name", "Great Book", 4); 
	        String errorMessage = "Failed to add book"; 
	        ResponseBean<Response> failureResponse = ResponseBean.error(errorMessage, null);
	        when(bookrepository.saveBook(bookDetails)).thenReturn(failureResponse);

	        // Act
	        ResponseBean<Response> result = bookservice.addBookDetails(bookDetails);

	        // Assert
	        assertFalse(result.isSuccess());
	        assertEquals(errorMessage, result.getMessage());
	        verify(bookrepository, times(1)).saveBook(bookDetails);
	    }

}

