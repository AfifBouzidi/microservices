package com.abouzidi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
public class CreateBookRatingDTO {

	@NotNull
	private Long bookId;

	@Min(1)
	@Max(5)
	private Integer mark;

}
