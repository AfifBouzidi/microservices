package com.abouzidi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Entity
public class BookRating {

	@SequenceGenerator(name="rating_gen",sequenceName="rating_seq")
	@Id
	@GeneratedValue(generator="rating_gen")
	private Long id;

	private long bookId;

	@Enumerated(EnumType.ORDINAL)
	private Mark mark;

	@Temporal(TemporalType.TIMESTAMP)
	private Date RatingDate;

	public BookRating(Long bookId, Mark mark) {
		this.bookId = bookId;
		this.mark = mark;
		RatingDate = new Date();
	}

}
