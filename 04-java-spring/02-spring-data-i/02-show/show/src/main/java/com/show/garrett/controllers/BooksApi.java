package com.show.garrett.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.show.garrett.models.Book;
import com.show.garrett.services.BookService;

@RestController
public class BooksApi {
	
	private final BookService bookServices;
	
	public BooksApi(BookService bookServices) {
		this.bookServices = bookServices;
	}
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookServices.allBooks();
	}
	@RequestMapping (value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages){
		Book book = new Book(title, desc, lang, numOfPages);
		return bookServices.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show (@PathVariable("id") Long id) {
		Book book = bookServices.findBook(id);
		return book;
	}
}
