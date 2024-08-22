package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.Modals.Bookings;
import com.Movie.Movie.Booking.System.Modals.Seats;
import com.Movie.Movie.Booking.System.Modals.Shows;
import com.Movie.Movie.Booking.System.Modals.Theatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    @Query("SELECT se.status FROM Seats se " +
            "JOIN se.theatres th " +
            "JOIN se.shows sh " +
            "WHERE th.theatreId = :theatreId AND " +
            "sh.showId = :showId AND " +
            "se.seatId = :seatId")
    String seatStatus(@Param("theatreId") Long theatreId, @Param("showId") Long showId, @Param("seatId") Long seatId);
}

