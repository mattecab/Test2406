package com.example.test2406.spring.boot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "BOOK")
@NamedQueries({ @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b") })

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
            private List<Quote> quotes;

 Book() {}

public Book(Integer id, String name) {
		this.id = id;
		this.title = name;
	}

public Book(String name) {
		this.title = name;
	}

public Integer getId() {
		return id;
	}

public void setId(Integer id) {
		this.id = id;
	}







public String getTitle() {
		return title;
	}

public void setTitle(String name) {
		this.title = name;
	}
	
public List<Quote> getQuotes() {
		return quotes;
	}

public void addQuote(Quote quote) {
	quotes.add(quote);
	quote.setBook(this);
}

@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", quotes=" + quotes + "]";
}
	
	

	}





