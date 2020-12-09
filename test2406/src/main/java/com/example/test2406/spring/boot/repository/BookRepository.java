package com.example.test2406.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.test2406.spring.boot.model.Book;

public interface BookRepository extends CrudRepository <Book, Integer> {

	Book findById(int id);
}