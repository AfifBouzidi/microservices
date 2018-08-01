package com.abouzidi.service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.abouzidi.domain.BookRating;
import com.abouzidi.domain.BookRatingResult;
import com.abouzidi.domain.Mark;
import com.abouzidi.dto.BookDTO;
import com.abouzidi.dto.BookRatingDTO;
import com.abouzidi.dto.CreateBookRatingDTO;
import com.abouzidi.dto.RatingMapper;
import com.abouzidi.event.EventDispatcher;
import com.abouzidi.event.RatingBookEvent;
import com.abouzidi.repository.BookRatingRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Afif Bouzidi
 *
 */
@Slf4j
@Service
public class DefaultBookRatingService implements BookRatingService {

	@Autowired
	private BookRatingRepository bookRatingRepository;

	@Autowired
	private RatingMapper ratingMapper;

	@Autowired
	private EventDispatcher eventDispatcher;

	@Autowired
	RestTemplate restTemplate;

	@Value("${bookManagerHost}")
	private String bookManagerHost;

	@Override
	public BookRatingDTO createBookRating(CreateBookRatingDTO createBookRatingDTO) {
		BookRating bookRating = new BookRating(createBookRatingDTO.getBookId(),
				Mark.getMark(createBookRatingDTO.getMark()));
		log.info("ID " + createBookRatingDTO.getBookId());
		bookRatingRepository.save(bookRating);
		RatingBookEvent ratingBookEvent = this.generateEvent(createBookRatingDTO.getBookId());
		log.info("send RatingBookEvent: " + ratingBookEvent.toString());
		eventDispatcher.send(ratingBookEvent);
		return ratingMapper.asBookRatingDTO(bookRating);
	}

	@Override
	public Collection<BookRatingDTO> findAllBookRatingsByBookId(long bookId) {
		Collection<BookRating> bookRatings = bookRatingRepository.findAllBookRatingsByBookId(bookId);
		return ratingMapper.asBookRatingDTOCollection(bookRatings);
	}

	@Override
	public BookRatingResult computeBookRatingResult(long bookId) {
		Collection<BookRating> bookRatings = bookRatingRepository.findAllBookRatingsByBookId(bookId);
		Map<Integer, Long> map = StreamSupport.stream(bookRatings.spliterator(), false)
				.filter((BookRating r) -> r.getMark().getMark() > 0)
				.collect(Collectors.groupingBy((BookRating r) -> r.getMark().getMark(), Collectors.counting()));
		BookRatingResult bookRatingResult = new BookRatingResult(bookId, map);
		bookRatingResult.initiateResult();
		return bookRatingResult;
	}

	private RatingBookEvent generateEvent(long bookId) {
		BookRatingResult bookRatingResult = this.computeBookRatingResult(bookId);
		Map<Integer, Long> ratingResult = bookRatingResult.getRatingResult();
		long sumRating = 0;
		long allRating = 0;
		for (int i = 1; i < 6; ++i) {
			sumRating = ratingResult.get(i) * i + sumRating;
			allRating = ratingResult.get(i) + allRating;
		}
		return new RatingBookEvent(Math.floorDiv(sumRating, allRating), bookId);
	}

	@HystrixCommand(fallbackMethod = "defaultBookCheck")
	@Override
	public boolean checkBookAvailability(long bookId) {
		try {
			BookDTO bookDTO = restTemplate.getForObject(bookManagerHost + "/books/" + bookId, BookDTO.class);
			return bookDTO != null ? true : false;
		} catch (RestClientException e) {
			log.error("vailability problem", e);
			return false;
		}
	}

	private boolean defaultBookCheck(long bookId) {
		return true;
	}

}
