package com.abouzidi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.abouzidi.dto.BookMapper;

import fr.xebia.extras.selma.Selma;

/**
 * @author Afif Bouzidi
 *
 */
@Configuration
@EnableWebMvc
public class BookConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	BookMapper bookRatingMapper() {
		return Selma.builder(BookMapper.class).build();
	}

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET","POST","PUT", "DELETE");
	}

}
