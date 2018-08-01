package com.abouzidi.dto;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Afif Bouzidi
 *
 */
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookRatingDTO {

	private Long id;

	private long bookId;

	private int mark;
	
	private Date RatingDate;

}
