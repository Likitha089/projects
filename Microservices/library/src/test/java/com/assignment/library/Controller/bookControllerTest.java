package com.assignment.library.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.assignment.library.Model.Book;
import com.assignment.library.Service.bookService;
@WebMvcTest(bookController.class)
public class bookControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private bookService bookService;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testAddBook() throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setName("Sample Book");
        book.setAuthor("Sample Author");
        book.setDescription("This is a sample book description.");
        book.setRating(4.5);
 
        when(bookService.addBook(any())).thenReturn(book);
 
        mockMvc.perform(post("/library/uploadBooks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"1\", \"name\": \"Sample Book\", \"author\": \"Sample Author\", \"description\": \"This is a sample book description.\", \"rating\": 4.5 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sample Book"));
    }
 
    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setName("Sample Book");
        book.setAuthor("Sample Author");
        book.setDescription("This is a sample book description.");
        book.setRating(4.5);
 
        when(bookService.getBookById(1)).thenReturn(book);
 
        mockMvc.perform(get("/library/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sample Book"));
    }
}
 