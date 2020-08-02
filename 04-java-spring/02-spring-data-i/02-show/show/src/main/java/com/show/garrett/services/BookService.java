package com.show.garrett.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.show.garrett.models.Book;
import com.show.garrett.repositories.BookRepositories;

@Service
public class BookService {
	private final BookRepositories bookRepository;
	
	public BookService(BookRepositories bookRepository) {
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

}
