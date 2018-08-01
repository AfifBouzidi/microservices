package com.abouzidi.dto;

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
public class BookDTO {
	
	private Long id;

	private String isdn;

	private String title;
	
	private String authorFirstName;
	
	private String authorLastName;
	
	private Long ratings;

}
