package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.models.Passenger;
import org.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("SELECT r from Booking b inner join Review r where b.id=:bookingId")
    Review findReviewByBookingId(Long bookingId);




}



