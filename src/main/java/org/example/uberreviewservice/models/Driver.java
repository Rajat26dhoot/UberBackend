package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    private String phoneNumber;

    private String address;

    // one to many assosation
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings;










}
