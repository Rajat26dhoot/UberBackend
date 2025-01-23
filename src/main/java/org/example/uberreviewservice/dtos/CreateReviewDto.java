package org.example.uberreviewservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {

    private String content;

    private Long bookingId;

    private Double rating;

}
