package com.example.test2406.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "QUOTE")
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String tag;
	private String sentence;
	private int numberWords;
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
		
	public Quote() {
		super();
	}
	public Quote(int id, String sentence, int numberWords,Book book) {
		super();
		this.id = id;
		this.sentence = sentence;
		this.numberWords = numberWords;
		this.book = book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSentence() {
		return sentence;
	}
	
public String getTag() {
		return tag;
	}
	public void setSentence(String tag) {
		this.tag = tag;
	}
	public int getNumberWords() {
		return numberWords;
	}
	public void setNumberWords(int numberWords) {
		this.numberWords = numberWords;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", sentence=" + sentence + ", numberWords=" + numberWords + ", book=" + book + "]";
	}
}
