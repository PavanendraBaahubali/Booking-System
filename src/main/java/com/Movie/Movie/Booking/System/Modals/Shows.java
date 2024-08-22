package com.Movie.Movie.Booking.System.Modals;

import com.Movie.Movie.Booking.System.Exceptions.TheatreNotFoundException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    private String showTimings;

    @ManyToMany
    @JoinTable(
            name = "show_theatre",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "theatre_id")
    )
    private Set<Theatres> theatres;

    @ManyToMany(mappedBy = "shows")
    private List<Seats> seatsList;

}
