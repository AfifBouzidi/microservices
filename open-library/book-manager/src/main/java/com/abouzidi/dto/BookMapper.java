package com.abouzidi.dto;

import java.util.List;
import com.abouzidi.domain.Book;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

/**
 * @author Afif Bouzidi
 *
 */
@Mapper(withIgnoreMissing = IgnoreMissing.ALL, withCustomFields = { @Field({ "author.firstName", "authorFirstName" }),
		@Field({ "author.lastName", "authorLastName" }) })
public interface BookMapper {

	public BookDTO asBookDTO(Book book);

	public Book asBook(BookDTO bookDto);

	public List<BookDTO> asBookCollectionDTO(List<Book> books);

}
