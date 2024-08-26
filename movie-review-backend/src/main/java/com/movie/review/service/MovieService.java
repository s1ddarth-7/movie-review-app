package com.movie.review.service;

import com.movie.review.entity.Movie;
import com.movie.review.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * Fetches info of Movie based on ID
     * @param id - id of the Movie obtained as the path variable
     * @return - Movie based on ID
     */
    public Optional<Movie> getMovieById(ObjectId id) {
        return movieRepository.findById(id);
    }

    /**
     * Fetches info of Movie based on IMDB ID
     * @param imdbId - imdbId of the Movie obtained as the path variable
     * @return - Movie based on imdbId
     */
    public Optional<Movie> getMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    /**
     * Sorts all movies based on field of Document
     * @param field - a parameter of the Movie document which is considered for sorting
     * @return - List of sorted Movies
     * Note: customized DESC sort based on release date has been implemented
     */
    public List<Movie> getAllMoviesSortedByField (String field) {
        Sort.Direction direction = field.equals("releaseDate") ? Sort.Direction.DESC: Sort.Direction.ASC;
        return movieRepository.findAll(Sort.by(direction, field));
    }

    /**
     * Pagination - fetches Movies based on page parameters
     * @param pageNum - pageNum starts from 0, hence -1 in the definition
     * @param pageSize - number of entries per page
     * @return - Page of Movies
     */
    public Page<Movie> getAllMoviesWithPagination(int pageNum, int pageSize) {
        return movieRepository.findAll(PageRequest.of(pageNum-1, pageSize)); // pageNum-1 as it starts from 0
    }

    /**
     * Pagination and sorting implementation
     * @param field - field used for sorting
     * @param pageNum - pageNum starts from 0, hence -1 in the definition
     * @param pageSize - number of entries per page
     * @return - Page of Movies of relevant size AFTER sorting
     */
    public Page<Movie> getAllMoviesWithPaginationAndSorting(String field, int pageNum, int pageSize) {
        Sort.Direction direction = field.equals("releaseDate") ? Sort.Direction.DESC: Sort.Direction.ASC;
        return movieRepository.findAll(PageRequest.of(pageNum-1, pageSize).withSort(Sort.by(direction, field)));
    }

    /**
     * List of Movies filtered based on genre
     * @param genre - query parameter from URL
     * @return - List of genre-matching Movies
     */
    public List<Movie> filterMoviesBasedOnGenre(String genre) {
        return movieRepository.findAll()
                .stream()
                .filter(it -> it.getGenres().stream().anyMatch(g ->
                        genre!=null && g.strip().equalsIgnoreCase(genre.strip()))) //null check and case-insensitive matching
                .collect(Collectors.toList());
    }
}
