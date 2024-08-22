package com.Movie.Movie.Booking.System.Services.BookingsService;

import com.Movie.Movie.Booking.System.Exceptions.MovieNotFoundException;
import com.Movie.Movie.Booking.System.Exceptions.SeatNotAvailableException;
import com.Movie.Movie.Booking.System.Exceptions.ShowNotFoundException;
import com.Movie.Movie.Booking.System.Exceptions.TheatreNotFoundException;
import com.Movie.Movie.Booking.System.Modals.*;
import com.Movie.Movie.Booking.System.Repositories.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;



@Service
@AllArgsConstructor
public class BookingsService {

    private final BookingsRepository bookingsRepository;
    private final MovieRepository movieRepository;
    private final UsersRepository usersRepository;
    private final TheatresRepository theatresRepository;
    private final ShowRepository showsRepository;
    private final SeatingRepository seatsRepository;

    @Transactional
    public String makeBooking(Long userId, Long movieId, Long theatreId, Long showId, Long seatId) {
        try {
            // Fetch entities...
            Users user = usersRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

            Movies movie = movieRepository.findById(movieId)
                    .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + movieId));

            Theatres theatre = theatresRepository.findById(theatreId)
                    .orElseThrow(() -> new TheatreNotFoundException("Theatre not found with id: " + theatreId));

            Shows show = showsRepository.findById(showId)
                    .orElseThrow(() -> new ShowNotFoundException("Show not found with id: " + showId));

            Seats seat = seatsRepository.findById(seatId)
                    .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + seatId));

            // Check and update seat status
            String seatStatus = seat.getStatus().toLowerCase();
            if ("available".equals(seatStatus)) {
                seat.setStatus("Not Available");
                seatsRepository.save(seat);
            }
            else
                throw new SeatNotAvailableException("Seat not available for show: " + showId + " seat: " + seatId);

            seat.setStatus("Not Available");
            seatsRepository.save(seat);

            // Create and save booking
            Bookings booking = new Bookings();
            booking.setUser(user);
            booking.setMovies(movie);
            booking.setTheatres(theatre);
            booking.setShows(show);
            booking.setSeats(seat);
            booking.setBookingTime(LocalDateTime.now().toString());
            booking.setStatus("CONFIRMED");

            bookingsRepository.save(booking);

            // Return response...
            return "Booking is done";
        } catch (OptimisticLockingFailureException e) {
            throw new RuntimeException("The seat was booked by someone else. Please try again.", e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while processing your booking: " + e.getMessage(), e);
        }
    }

}
