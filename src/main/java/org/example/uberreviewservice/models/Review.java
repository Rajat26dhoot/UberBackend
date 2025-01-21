package org.example.uberreviewservice.models;


import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_Review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;


    private Double rating;

//    @OneToOne(orphanRemoval = true)
//
//    private Booking booking;

    @Override
    public String toString(){
        return "Review "+this.content+"this.rating"+" "+this.createdAt;
    }
}
