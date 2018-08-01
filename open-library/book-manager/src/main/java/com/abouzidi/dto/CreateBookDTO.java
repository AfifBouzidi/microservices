package com.abouzidi.dto;


import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Afif Bouzidi
 *
 */
@Getter
@Setter
@ToString
public class CreateBookDTO {
	
	private long catalogId;
	
	@NotEmpty
	private String isdn;

	@NotEmpty
	private String title;
	
	@NotEmpty
	private String authorFirstName;

	@NotEmpty
	private String authorLastName;

}
