package com.movie.review.service;

import com.movie.review.entity.Movie;
import com.movie.review.entity.Review;
import com.movie.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * method to add review to a Movie
     * @param reviewBody - received as JSON from Postman while testing
     * @param imdbId - received as JSON from Postman while testing
     * @return - Review
     */
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        /*
        MongoTemplate helps in interacting with database when the queries get complicated
        or basically involves different Table/Document classes
        .first() is used to apply the change to the first matching document
        in case the condition(i.e., Criteria) matches multiple documents
         */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }
}
