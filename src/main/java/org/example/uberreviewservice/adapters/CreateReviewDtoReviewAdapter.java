package org.example.uberreviewservice.adapters;

import org.example.uberreviewservice.dtos.CreateReviewDto;
import org.example.uberreviewservice.models.Review;

public interface CreateReviewDtoReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
