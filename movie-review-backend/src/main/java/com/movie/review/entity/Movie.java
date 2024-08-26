package com.movie.review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

/**
 * This class represents each document (see variable names) of the 'movies' collection on MongoDB
 */
@Document (collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private Date releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference  // helps to link another document to the current document
    private List<Review> reviewIds;

}
