package com.Movie.Movie.Booking.System.Controllers;

import com.Movie.Movie.Booking.System.Services.BookingsService.BookingsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bookings")
@AllArgsConstructor
public class BookingsController {

    private final BookingsService bookingsService;

    @PostMapping("/create")
    public ResponseEntity<String> makeABooking(
            @RequestParam Long userId,
            @RequestParam Long movieId,
            @RequestParam Long theatreId,
            @RequestParam Long showId,
            @RequestParam Long seatId) {

        String response = bookingsService.makeBooking(userId, movieId, theatreId, showId, seatId);
        return ResponseEntity.ok(response);
    }


}
