package com.movie.review.repository;

import com.movie.review.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    /*
    to enable custom search based on specific parameter of entity, we introduce custom method with parameter
    having the exact same name in the entity class.
    @Repository is smart enough to understand, so we need not worry defining the abstract method
     */
    Optional<Movie> findMovieByImdbId (String imdbId);  // class: Movie, search based on parameter: imdbId
}
