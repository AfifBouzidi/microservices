package com.abouzidi.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author Afif Bouzidi
 *
 */
@Component
public class EventDispatcher {

	private RabbitTemplate rabbitTemplate;

	private String bookratingExchange;

	private String bookratingSolvedRoutingKey;

	@Autowired
	EventDispatcher(final RabbitTemplate rabbitTemplate,
			@Value("${bookrating.exchange}") final String bookratingExchange,
			@Value("${bookrating.solved.key}") final String bookratingSolvedRoutingKey) {
		this.rabbitTemplate = rabbitTemplate;
		this.bookratingExchange = bookratingExchange;
		this.bookratingSolvedRoutingKey = bookratingSolvedRoutingKey;
	}

	public void send(final RatingBookEvent ratingBookEvent) {
		rabbitTemplate.convertAndSend(bookratingExchange, bookratingSolvedRoutingKey, ratingBookEvent);
	}
}
