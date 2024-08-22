package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.Modals.Keys.MovieLocationId;
import com.Movie.Movie.Booking.System.Modals.MovieLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLocationRepository extends JpaRepository<MovieLocations, MovieLocationId> {

}
