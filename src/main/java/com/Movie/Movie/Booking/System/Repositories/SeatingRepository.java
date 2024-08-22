package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.DTO.seatDTO.SeatDTO;
import com.Movie.Movie.Booking.System.Modals.Seats;
import com.Movie.Movie.Booking.System.Modals.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatingRepository extends JpaRepository<Seats, Long> {
//    @Query("SELECT new com.Movie.Movie.Booking.System.DTO.seatDTO(sh.showId, se.theatres.theatreId, sh.showTimings, se.seatId, se.seatNumber, se.status ) " +
//            "FROM Seats se JOIN se.shows sh WHERE se.seatId = :seatId AND se.theatres.theatreId = :theatreId AND sh.showId = :showId")
//    List<SeatDTO> getAvailableShowsForASeat(@Param("seatId") Long seatId, @Param("theatreId") Long theatreId, @Param("showId") Long showId);
//
    @Query("SELECT new com.Movie.Movie.Booking.System.DTO.seatDTO.SeatDTO(sh.showId, se.theatres.theatreId, sh.showTimings, se.seatId, se.seatNumber, se.status) " +
            "FROM Seats se JOIN se.shows sh JOIN se.theatres t " +
            "WHERE se.seatId = :seatId AND t.theatreId = :theatreId AND sh.showId = :showId")
    List<SeatDTO> getAvailableShowsForASeat(@Param("seatId") Long seatId, @Param("theatreId") Long theatreId, @Param("showId") Long showId);

}