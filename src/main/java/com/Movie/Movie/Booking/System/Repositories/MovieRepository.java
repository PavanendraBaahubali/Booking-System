package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.Modals.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {
    @Query(value = "select  * from movies where movie_name = :name ", nativeQuery = true)
    public Movies findByMovieName(String name);

    @Query(value = "select * from movies where lower(genre) = :genre", nativeQuery = true)
    public List<Movies> getMoviesByGenre(String genre);

    @Query(value = "select ml.movie from MovieLocations ml where lower(ml.location.locationName) = :locationName")
    public List<Movies> getMoviesByLocation(String locationName);



}
