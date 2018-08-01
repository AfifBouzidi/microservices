package com.abouzidi.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author Afif Bouzidi
 *
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RatingBookEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7542605656887751607L;
	private final Long meanRating;
	private final Long bookId;
	
}
