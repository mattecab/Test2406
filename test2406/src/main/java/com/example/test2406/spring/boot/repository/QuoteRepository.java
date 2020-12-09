package com.example.test2406.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.test2406.spring.boot.model.Quote;

public interface  QuoteRepository extends CrudRepository<Quote, Integer> {

	Quote findById(int id);
}