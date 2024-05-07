package com.library.book.Repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.library.book.Entity.Book;
import com.library.book.Entity.Response;
import com.library.book.Entity.ResponseBean;
import org.springframework.web.client.HttpClientErrorException;


import org.springframework.beans.factory.annotation.Value;

@Repository
public class LibraryRepo {
    @Value("${downstream_url}")
    private String url;

    RestTemplate restTemplate = new RestTemplate();

    public ResponseBean<Response> uploadBook(Book bookDetails) {
        HttpEntity<Book> request = new HttpEntity<>(bookDetails);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Response.class);
        if (responseEntity.getStatusCodeValue() == 200) {
        	Response savedResponse = responseEntity.getBody();

            return ResponseBean.of(savedResponse);
        } else {
            return ResponseBean.error("500", "Failed to save book");
        }
    }
    public ResponseBean<Response> getBookById(int id) throws Exception {
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url + "/" + id, HttpMethod.GET, null, Response.class);
        
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Response savedResponse = responseEntity.getBody();
            return ResponseBean.of(savedResponse);
        } else if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new Exception("Book not present");
        } else {
            throw new Exception("Unexpected status code: " + responseEntity.getStatusCode());
        }
    }
    
    }
