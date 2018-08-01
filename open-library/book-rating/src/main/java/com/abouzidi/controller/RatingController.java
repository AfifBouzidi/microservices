package com.abouzidi.controller;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abouzidi.domain.BookRatingResult;
import com.abouzidi.dto.BookRatingDTO;
import com.abouzidi.dto.CreateBookRatingDTO;
import com.abouzidi.exception.ResourceNotFoundException;
import com.abouzidi.service.BookRatingService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Afif Bouzidi
 *
 */
@Slf4j
@RestController
public class RatingController {

	@Autowired
	private BookRatingService bookRatingService;

	@RequestMapping(value = "/ratings", method = RequestMethod.POST)
	public ResponseEntity<?> createBook(@Valid @RequestBody CreateBookRatingDTO bookRating) {
		if (!bookRatingService.checkBookAvailability(bookRating.getBookId())) {
             throw new ResourceNotFoundException("Book Not found");
		}
		log.info("create Book Rating" + bookRating.toString());
		bookRatingService.createBookRating(bookRating);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/ratings/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<Collection<BookRatingDTO>> getAllBookRatings(@PathVariable Long bookId) {
		log.info("get all Book Ratings for bookId " + bookId);
		Collection<BookRatingDTO> allBookRatings = bookRatingService.findAllBookRatingsByBookId(bookId);
		return new ResponseEntity<>(allBookRatings, HttpStatus.OK);
	}

	@RequestMapping(value = "/ratings/result/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<BookRatingResult> computeBookRatingResult(@PathVariable Long bookId) {
		BookRatingResult bookRatingResult = bookRatingService.computeBookRatingResult(bookId);
		return new ResponseEntity<>(bookRatingResult, HttpStatus.OK);
	}

}
