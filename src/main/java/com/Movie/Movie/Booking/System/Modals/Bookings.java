package com.Movie.Movie.Booking.System.Modals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"theatre_id", "show_id", "seat_id"})
})
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    private Movies movies;


    @ManyToOne
    private Theatres theatres;

    @ManyToOne
    private Shows shows;

    @ManyToOne
    private Seats seats;

    private String bookingTime;
    private String status;

}
