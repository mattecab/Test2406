package com.example.test2406.spring.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test2406.spring.boot.model.Book;

import com.example.test2406.spring.boot.model.Quote;
import com.example.test2406.spring.boot.service.BookService;
import com.example.test2406.spring.boot.service.QuoteService;

@Controller
@RequestMapping("/library")
public class HomeController {

	@Autowired
	QuoteService quoteservice;
	//@Autowired
	@Autowired
	BookService bookservice;

	@RequestMapping("/show")
	public String showQuote (Model model) {

		model.addAttribute("quotes", quoteservice.findAll());
		
		return "library/index.html";
	}
	
	
	@RequestMapping("/addQuote")
	public String addQuote(Model model) {
		
		model.addAttribute("books",  bookservice.findAll());
		
		return "library/addQuote.html";
	}

	
	@RequestMapping(value = "/insertQuote", method = RequestMethod.POST)
	public String insertQuote(Quote quote, Model model,
			 @RequestParam("idBook") Integer id) {
		
		System.out.println(id);
		
		Optional<Book> foundBook = bookservice.findById(id);
	

		// Search for a book with an invalid ID
		
		quote.setBook(foundBook.get());
		
		
		quoteservice.insertQuote(quote);
		
		
		model.addAttribute("quotes", quoteservice.findAll());
		return "library/index.html";
	}
}