package com.example.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.entity.ResponseBean;
import com.example.demo.exception.BookException;

public class BookRTest {

	
	@Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BookR bookRepository;

    @Value("${down_stream_URL}")
    private String url;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(bookRepository, "url", url);
    }

    @Test
    void testGetBookById_Success() {
        // Arrange
        int bookId = 1;
        Response expectedResponse = new Response(1, "Person", "author", "best Book", 4);
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(expectedResponse, HttpStatus.OK);
        when(restTemplate.exchange(url + "/book/" + bookId, HttpMethod.GET, null, Response.class))
                .thenReturn(responseEntity);

        // Act
        ResponseBean<Response> result = bookRepository.getBookById(bookId);

        // Assert
        assertTrue(result.isSuccess());
        assertEquals(expectedResponse, result.getData());
    }

//    @Test
//    public void testGetBookById_NotFound() {
//        // Arrange
//        int bookId = 1;
//       // String url = "http://your-api-base-url"; // Replace with your actual base URL
//
//        // Mock the external call to throw a BookNotFoundException directly
//        Mockito.when(restTemplate.exchange(url + "/book/" + bookId, HttpMethod.GET, null, Response.class))
//                .thenThrow(new BookNotFoundException("Book not found"));
//
//        // Act & Assert (expect BookNotFoundException to be thrown directly)
//        assertThrows(BookNotFoundException.class, () -> bookRepository.getBookById(bookId));
//    }

//    @Test
//    void testGetBookById_InternalServerError() {
//        // Arrange
//        int bookId = 1;
//        when(restTemplate.exchange(url + "/book/" + bookId, HttpMethod.GET, null, Response.class))
//                .thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
//
//        // Act & Assert
//        assertThrows(RuntimeException.class, () -> bookRepository.getBookById(bookId));
//    }

    @Test
    void testSaveBook_Success() {
        // Arrange
        Book book = new Book(1, "Person", "author", "best Book", 4);
        Response expectedResponse = new Response(1, "Person", "author", "best Book", 4);
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(expectedResponse, HttpStatus.OK);
        when(restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(book), Response.class))
                .thenReturn(responseEntity);

        // Act
        ResponseBean<Response> result = bookRepository.saveBook(book);

        // Assert
        assertTrue(result.isSuccess());
        assertEquals(expectedResponse, result.getData());
    }

//    @Test
//    void testSaveBook_InternalServerError() {
//        // Arrange
//        Book book = new Book(1, "Person", "author", "best Book", 4);
//        when(restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(book), Response.class))
//                .thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
//
//        // Act
//        ResponseBean<Response> result = bookRepository.saveBook(book);
//
//        // Assert
//        assertFalse(result.isSuccess());
//        assertEquals("500", result.getCode());
//        assertEquals("Failed to save book", result.getMessage());
//    }
}
