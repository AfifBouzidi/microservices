package com.abouzidi.domain;

import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Afif Bouzidi
 *
 */
@RequiredArgsConstructor
@Getter
public class BookRatingResult {

	private long bookId;

	private Map<Integer, Long> ratingResult;

	public BookRatingResult(long bookId, Map<Integer, Long> ratingResult) {
		this.bookId = bookId;
		this.ratingResult = ratingResult;
	}

	public void initiateResult() {
		ratingResult.putIfAbsent(1, 0l);
		ratingResult.putIfAbsent(2, 0l);
		ratingResult.putIfAbsent(3, 0l);
		ratingResult.putIfAbsent(4, 0l);
		ratingResult.putIfAbsent(5, 0l);
	}

}
