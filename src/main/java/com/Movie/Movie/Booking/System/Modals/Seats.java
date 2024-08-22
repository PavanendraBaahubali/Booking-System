package com.Movie.Movie.Booking.System.Modals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatres theatres;

    private String seatNumber;

    private String status;

    @Version
    private Long version;

    @ManyToMany
    @JoinTable(
            name = "showSeats",
            joinColumns = @JoinColumn(name = "seat_Id"),
            inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Shows> shows;

}
