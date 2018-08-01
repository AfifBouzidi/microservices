package com.abouzidi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.abouzidi.dto.RatingMapper;

import fr.xebia.extras.selma.Selma;

/**
 * @author Afif Bouzidi
 *
 */
@Configuration
@EnableWebMvc
public class BookRatingConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	RatingMapper bookRatingMapper() {
		return Selma.builder(RatingMapper.class).build();
	}

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET","POST","PUT", "DELETE");
	}
	
}
