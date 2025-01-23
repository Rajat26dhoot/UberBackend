package org.example.uberreviewservice.controllers;


import org.example.uberreviewservice.adapters.CreateReviewDtoReviewAdapter;
import org.example.uberreviewservice.dtos.CreateReviewDto;
import org.example.uberreviewservice.dtos.ReviewDto;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;

    private CreateReviewDtoReviewAdapter createReviewDtoReviewAdapter;
    public ReviewController(ReviewService reviewService,CreateReviewDtoReviewAdapter createReviewDtoReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoReviewAdapter = createReviewDtoReviewAdapter;
    }


    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto request) {
        Review incomingReview=this.createReviewDtoReviewAdapter.convertDto(request);
        if(incomingReview==null) {
            return new ResponseEntity<>("Invalid argument",HttpStatus.BAD_REQUEST);
        }
        Review review = this.reviewService.publishReview(incomingReview);
        ReviewDto response=ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .CreatedAt(review.getCreatedAt())
                .UpdatedAt(review.getUpdatedAt())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId) {
        try {
            boolean isDeleted = this.reviewService.deleteReviewById(reviewId);
            if(!isDeleted) return new ResponseEntity<>("Unable to delete Review", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review request){
        try {
            Review review = this.reviewService.updateReview(reviewId, request);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
