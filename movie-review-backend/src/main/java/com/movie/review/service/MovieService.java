package com.movie.review.service;

import com.movie.review.entity.Movie;
import com.movie.review.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    /**
     * Method to fetch all Movie data
     * @return - List of Movie data
     */
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    /**
     * Method that fetches info of Movie based on ID
     * @param id - id of the Movie obtained as the path variable
     * @return - Movie based on ID
     */
    public Optional<Movie> getMovieById(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie>  getMovieByImdbId (String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
