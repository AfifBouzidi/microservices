package com.abouzidi.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abouzidi.domain.Author;
import com.abouzidi.domain.Book;
import com.abouzidi.dto.BookDTO;
import com.abouzidi.dto.BookMapper;
import com.abouzidi.dto.CreateBookDTO;
import com.abouzidi.dto.UpdateBookDTO;
import com.abouzidi.exception.ResourceNotFoundException;
import com.abouzidi.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Afif Bouzidi
 *
 */
@Slf4j
@Service
public class DefaultBookService implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapper bookMapper;

	@Override
	public BookDTO createBook(CreateBookDTO createBookDTO) {
		Book newBook = new Book(createBookDTO.getIsdn(), createBookDTO.getTitle(), createBookDTO.getAuthorFirstName(),
				createBookDTO.getAuthorLastName());
		bookRepository.save(newBook);
		return bookMapper.asBookDTO(newBook);
	}

	@Override
	public void updateBook(UpdateBookDTO updateBookDTO) {
		Book book = bookRepository.findOne(updateBookDTO.getId());
		book.setAuthor(new Author(updateBookDTO.getAuthorFirstName(), updateBookDTO.getAuthorLastName()));
		book.setIsdn(updateBookDTO.getIsdn());
		book.setTitle(updateBookDTO.getTitle());
		bookRepository.save(book);
	}

	@Override
	public BookDTO findBookById(long bookId) {
		Book book = bookRepository.findOne(bookId);
		return bookMapper.asBookDTO(book);
	}

	@Override
	public Collection<BookDTO> findAllBooks() {
		return bookMapper.asBookCollectionDTO(bookRepository.findAllByOrderByRatingsDesc());
	}

	@Override
	public void deleteBookById(long bookId) {
		Book book = bookRepository.findOne(bookId);
		bookRepository.delete(book);
	}

}
