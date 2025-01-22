package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ReviewService {
    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);
}
