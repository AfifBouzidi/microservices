package com.abouzidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Afif Bouzidi
 *
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class BookRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRatingApplication.class, args);
	}
}
