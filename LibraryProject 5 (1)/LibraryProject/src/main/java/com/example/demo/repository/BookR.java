package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;
import com.example.demo.entity.Response;
import com.example.demo.entity.ResponseBean;
import com.example.demo.exception.BookException;

@Repository
public class BookR {
    
//	@Autowired
//	RestTemplate restTemplate;
     RestTemplate restTemplate = new RestTemplate();
    
    @Value("${down_stream_URL}")
    private String url;
    
    public ResponseBean<Response> getBookById(int id) {
        try {
            ResponseEntity<Response> responseEntity = restTemplate.exchange(url + "/book/" + id, HttpMethod.GET, null, Response.class);
            if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
                Response savedResponse = responseEntity.getBody();
                return ResponseBean.of(savedResponse);
            } else {
                throw new BookException("Book not present");
            } 
        } catch (HttpClientErrorException.NotFound  ex) {
            throw new BookException("Book not present");
        } catch (HttpServerErrorException.InternalServerError ex) {
            ex.printStackTrace(); // Just printing the stack trace for demonstration
            throw new RuntimeException("Internal Server Error");
        } catch (Exception ex) {
            ex.printStackTrace(); // Just printing the stack trace for demonstration
            throw new RuntimeException("Internal Server Error");
        }
    }

    
    public ResponseBean<Response> saveBook(Book bookDetails) {
        HttpEntity<Book> request = new HttpEntity<>(bookDetails);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Response.class);
        if (responseEntity.getStatusCodeValue() == 200) {
        	Response savedResponse = responseEntity.getBody();

            return ResponseBean.of(savedResponse);
        } else {
            return ResponseBean.error("500", "Failed to save book");
        }
    }
    
}
