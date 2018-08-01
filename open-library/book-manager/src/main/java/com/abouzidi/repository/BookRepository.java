package com.abouzidi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abouzidi.domain.Book;

/**
 * @author Afif Bouzidi
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAllByOrderByRatingsDesc();
}
