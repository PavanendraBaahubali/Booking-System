package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.Modals.UpcomingMovies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpcomingMoviesRepository extends JpaRepository<UpcomingMovies, Long> {


}
