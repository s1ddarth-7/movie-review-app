package com.movie.review.controller;

import com.movie.review.entity.Review;
import com.movie.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     * Post Method to add movie reviews
     * @param payload - passed as a JSON on Postman
     * @return - responseEntity
     */
    @PostMapping
    public ResponseEntity<Review> createReview (@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>
                (reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
        // reviewBody and imdbId should be the exact parameter names passed in the JSON
    }

    @DeleteMapping ("/delete")
    public void deleteReview (@RequestBody String reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
