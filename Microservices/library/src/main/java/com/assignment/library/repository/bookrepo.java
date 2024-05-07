package com.assignment.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.library.Model.Book;

public interface bookrepo extends JpaRepository<Book, Integer>{

}
