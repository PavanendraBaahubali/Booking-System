package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.Modals.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Long> {
    @Query("SELECT s FROM Shows s JOIN s.theatres t WHERE t.theatreId = :theatreId")
    List<Shows> getAllAvailableShowsByTheatreId(@Param("theatreId") Long theatreId);
}
