package com.abouzidi.domain;

import javax.persistence.Embeddable;
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
@Embeddable
public class Author {

	private String firstName;

	private String lastName;

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
}
