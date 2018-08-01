package com.abouzidi.controller;

import java.net.URI;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abouzidi.dto.BookDTO;
import com.abouzidi.dto.CreateBookDTO;
import com.abouzidi.dto.UpdateBookDTO;
import com.abouzidi.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Afif Bouzidi
 *
 */
@Slf4j
@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<?> createBook(@Valid @RequestBody CreateBookDTO book) {
		log.info("create Book "+book.toString());
		book.setCatalogId(1l);
		BookDTO dto = bookService.createBook(book);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newBookUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		responseHeaders.setLocation(newBookUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@Valid @RequestBody UpdateBookDTO book, @PathVariable Long bookId) {
		log.info("update Book "+book.toString());
		book.setId(bookId);
		bookService.updateBook(book);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
		log.info("delete Book "+bookId);
		bookService.deleteBookById(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<Collection<BookDTO>> getAllBooks() {
		log.info("get all Books");
		Collection<BookDTO> allBooks = bookService.findAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<?> getBook(@PathVariable Long bookId) {
		log.info("get Book for bookId "+bookId);
		BookDTO book = bookService.findBookById(bookId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

}
