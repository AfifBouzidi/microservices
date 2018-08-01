package com.abouzidi.service;

import java.util.Collection;
import com.abouzidi.dto.BookDTO;
import com.abouzidi.dto.CreateBookDTO;
import com.abouzidi.dto.UpdateBookDTO;

/**
 * @author Afif Bouzidi
 *
 */
public interface BookService {

	public BookDTO createBook(CreateBookDTO createBookDTO);

	public void updateBook(UpdateBookDTO updateBookDTO);

	public BookDTO findBookById(long bookId);

	public Collection<BookDTO> findAllBooks();

	public void deleteBookById(long bookId);
}
