package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.DTO.TheatreDTOs.TheatreDTO;
import com.Movie.Movie.Booking.System.Modals.Theatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatresRepository extends JpaRepository<Theatres, Long> {

    @Query("SELECT new com.Movie.Movie.Booking.System.DTO.TheatreDTOs.TheatreDTO(th.theatreId, th.theatreName) FROM Theatres th WHERE LOWER(th.location.locationName) = LOWER(:locationName)")
    public List<TheatreDTO> findAllTheatresByLocationName(@Param("locationName") String locationName);

    @Query(value = "select th from Theatres th where th.movie.movieName = :movieName")
    public List<Theatres> findAllTheatresByMovieName(@Param("movieName") String movieName);
}
