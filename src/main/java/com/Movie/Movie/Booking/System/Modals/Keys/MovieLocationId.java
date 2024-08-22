package com.Movie.Movie.Booking.System.Modals.Keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieLocationId implements Serializable {

    private Long movieId; // Adjusted type to Long to match the Movies entity
    private Long locationId; // Adjusted type to Long to match the Locations entity

    // Default constructor
    public MovieLocationId() {
    }

    public MovieLocationId(Long movieId, Long locationId) {
        this.movieId = movieId;
        this.locationId = locationId;
    }

    // Getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieLocationId that = (MovieLocationId) o;
        return Objects.equals(movieId, that.movieId) &&
                Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, locationId);
    }
}
