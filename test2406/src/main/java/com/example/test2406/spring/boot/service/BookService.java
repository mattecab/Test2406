package com.example.test2406.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test2406.spring.boot.model.Book;
import com.example.test2406.spring.boot.model.Quote;
import com.example.test2406.spring.boot.repository.BookRepository;

@Service
public class BookService {
	

		@Autowired
		BookRepository repository;


		public Iterable<Book> findAll() {

			return repository.findAll();
		}

		public Optional<Book> findById (Integer id) {

			return repository.findById(id);
	}
		public void insertBook (Book book) {

			repository.save(book);		
}}