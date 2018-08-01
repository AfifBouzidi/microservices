package com.abouzidi.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abouzidi.domain.BookRating;

/**
 * @author Afif Bouzidi
 *
 */
@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Long> {

	@Query(" select e from BookRating e where e.bookId = :bookId ")
	Collection<BookRating> findAllBookRatingsByBookId(@Param("bookId") Long bookId);
}
