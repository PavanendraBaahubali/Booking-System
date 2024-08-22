package com.Movie.Movie.Booking.System.Modals;


import jakarta.persistence.*;

@Entity
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    private String locationName;


}
