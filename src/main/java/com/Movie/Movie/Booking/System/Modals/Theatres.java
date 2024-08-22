package com.Movie.Movie.Booking.System.Modals;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Theatres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Locations location;

    private int seatingCapacity;

    @ManyToMany(mappedBy = "theatres")
    private Set<Shows> shows;

    @OneToMany(mappedBy = "theatres", cascade = CascadeType.ALL)
    private List<Seats> seats;

    private String theatreName;

}
