package com.abouzidi.service;

import java.util.Collection;

import com.abouzidi.domain.BookRatingResult;
import com.abouzidi.dto.BookRatingDTO;
import com.abouzidi.dto.CreateBookRatingDTO;

/**
 * @author Afif Bouzidi
 *
 */
public interface BookRatingService {
	
	BookRatingDTO createBookRating(CreateBookRatingDTO createBookRatingDTO);
	
	Collection<BookRatingDTO> findAllBookRatingsByBookId(long bookId);
	
	BookRatingResult computeBookRatingResult(long bookId);
	
	boolean checkBookAvailability(long bookId);
}
