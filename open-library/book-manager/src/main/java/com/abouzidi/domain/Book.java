package com.abouzidi.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
public class Book {

	@SequenceGenerator(name="book_gen",sequenceName="book_seq")
	@Id
	@GeneratedValue(generator="book_gen")
	private Long id;

	private String isdn;

	private String title;

	private Long ratings;

	@Embedded
	private Author author;

	public Book(String isdn, String title, String authorFirstName, String authorLastName) {
		this.isdn = isdn;
		this.title = title;
		this.author = new Author(authorFirstName, authorLastName);
	}

}
