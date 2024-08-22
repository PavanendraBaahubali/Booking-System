package com.Movie.Movie.Booking.System.Modals;

import com.Movie.Movie.Booking.System.Modals.Keys.MovieLocationId;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_locations") // Adjusted to match table naming conventions
public class MovieLocations {

    @EmbeddedId
    private MovieLocationId id;

    @ManyToOne
    @MapsId("movieId") // MapsId value should match the attribute name in MovieLocationId
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movies movie;

    @ManyToOne
    @MapsId("locationId") // MapsId value should match the attribute name in MovieLocationId
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Locations location;

    public MovieLocations() {
    }

    public MovieLocations(MovieLocationId id, Movies movie, Locations location) {
        this.id = id;
        this.movie = movie;
        this.location = location;
    }

    // Getters, setters, equals, and hashCode
}
