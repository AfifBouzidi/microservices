package com.abouzidi.dto;

import java.util.Collection;

import com.abouzidi.domain.BookRating;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

/**
 * @author Afif Bouzidi
 *
 */
@Mapper(withIgnoreMissing = IgnoreMissing.ALL, withCustomFields = { @Field({ "mark.mark", "mark" }) })
public interface RatingMapper {

	BookRatingDTO asBookRatingDTO(BookRating bookRating);

	Collection<BookRatingDTO> asBookRatingDTOCollection(Collection<BookRating> bookRatings);

}
