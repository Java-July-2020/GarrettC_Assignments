package com.updateAndDelete.garrett.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.updateAndDelete.garrett.models.Book;
import com.updateAndDelete.garrett.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	public Book updateBook(Long id,Book updatedBook) {
		return this.bookRepository.save(updatedBook);
	}
	
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
	}

}
