package com.abouzidi.event;

import lombok.extern.slf4j.Slf4j;
import java.util.Optional;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.abouzidi.domain.Book;
import com.abouzidi.repository.BookRepository;

/**
 * @author Afif Bouzidi
 *
 */
@Slf4j
@Component
class EventHandler {

	@Autowired
	BookRepository rookRepository;

	@RabbitListener(queues = "${bookrating.queue}")
	void handleMultiplicationSolved(final RatingBookEvent event) {
		log.info("RatingBookEvent Event received: {}", event.toString());
		try {
			Book book = rookRepository.findOne(event.getBookId());
			book.setRatings(event.getMeanRating());
			rookRepository.save(book);

		} catch (Exception e) {
			log.error("Error when trying to process RatingBookEvent", e);
			// Avoids the event to be re-queued and reprocessed.
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
}
