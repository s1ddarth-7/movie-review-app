package com.movie.review.controller;

import com.movie.review.entity.Movie;
import com.movie.review.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieWithId(@PathVariable String id) {
        /*
        - the below String to ObjectId conversion is crucial to handle a non-valid /{id} for ObjectId conversion
        - handles this error: Failed to convert value of type 'java.lang.String' to required type 'org.bson.types.ObjectId'
        - in case of invalid objectId we generate a dummy objectId, this will not match because of the way objectId is generated
        - object ID is generated is combo of current timestamp, machine identifier, process identifier and counter
         */
        ObjectId objectId = ObjectId.isValid(id) ? new ObjectId(id) : new ObjectId();
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(objectId), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieWithImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
