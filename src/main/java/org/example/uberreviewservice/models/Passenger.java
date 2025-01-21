package org.example.uberreviewservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings=new ArrayList<>();
}
