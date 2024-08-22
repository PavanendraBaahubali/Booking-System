package com.Movie.Movie.Booking.System.Controllers.SeatsController;

import com.Movie.Movie.Booking.System.DTO.seatDTO.SeatDTO;
import com.Movie.Movie.Booking.System.Modals.Shows;
import com.Movie.Movie.Booking.System.Services.SeatingService.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/seats")
public class SeatController {
    private final SeatService seatService;
    @Autowired
    public SeatController(SeatService seatService){
        this.seatService = seatService;
    }

//    @PostMapping("/addseats/theatreId/{theatreId}/seatCapacity/{seatCapacity}")
//    public ResponseEntity<String> postTheatreSeatsBasedOnCapacity(@PathVariable int seatCapacity, @PathVariable long theatreId) {
//        System.out.println(seatCapacity + " " + theatreId);
//        seatService.addSeatsToTheatre(seatCapacity, theatreId);
//        String response = seatCapacity + " seats have been added to theatre " + theatreId;
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/theatreid/{theatreid}/showid/{showid}/seatid/{seatid}")
    public ResponseEntity<List<SeatDTO>> getAllAvailableShowsForASeat(
            @PathVariable("seatid") Long seatId,
            @PathVariable("theatreid") Long theatreId,
            @PathVariable("showid") Long showId)
    {
        List<SeatDTO> shows = seatService.getAllAvailableShowsForASeat(seatId, theatreId, showId);
        System.out.println(shows);
        return ResponseEntity.ok(shows);
    }

}
