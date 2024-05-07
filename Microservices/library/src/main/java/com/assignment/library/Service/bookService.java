package com.assignment.library.Service;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.library.Model.Book;
import com.assignment.library.repository.bookrepo;

@Service
public class bookService {

    @Autowired
    bookrepo BookRepo;
    @Autowired
	private RestTemplate restTemplate;
	private String downStreamURL;
	
    public bookService(RestTemplate restTemplate,@Value("${downstream.url}") String downStreamURL) {
		super();
		this.restTemplate = restTemplate;
		this.downStreamURL = downStreamURL;
	}

    public Book addBook(Book book) {
		ResponseEntity<Book> response = restTemplate.postForEntity(downStreamURL, book, Book.class);
		return response.getBody();
	}

    public Book getBookById(int id) {
		String url = downStreamURL + "/" + id; 
	    ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);
	    List<Book> list = Arrays.asList(response.getBody());
	    for (Book book : list) {
			if(book.getId()==id) {
				return  book;
			}
		}
		return null;
	 
	}
}
