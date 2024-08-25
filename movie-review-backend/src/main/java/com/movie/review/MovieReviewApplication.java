package com.movie.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovieReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewApplication.class, args);
	}

	/**
	 * The below two mappings handle the root API (/) and any undefined/unmatched APIs that aren't defined in other controllers
	 * The other controllers can override "/**" pattern to the requirement specific API pattern
	 */

	@GetMapping ("/")
	public ResponseEntity<String> rootApi() {
		return new ResponseEntity<>("Welcome!", HttpStatus.OK);
	}

	@GetMapping ("/**")
	public ResponseEntity<String> handleUndefinedApi() {
		// return rootApi();
		return new ResponseEntity<>("No such APIs defined!", HttpStatus.NOT_FOUND);
	}

}
