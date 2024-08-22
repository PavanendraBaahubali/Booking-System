package com.Movie.Movie.Booking.System.Controllers.showsController;

import com.Movie.Movie.Booking.System.Modals.Shows;
import com.Movie.Movie.Booking.System.Services.showsService.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/shows")
public class ShowController {
    private final ShowsService showsService;

    @Autowired
    public ShowController(ShowsService showsService) {
        this.showsService = showsService;
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<List<Shows>> getAllShowsByTheatreId(@PathVariable(name = "theatreId") Long theatreId){
        List<Shows> shows = showsService.getAllAvailableShowsByTheatreId(theatreId);
        System.out.println(shows.get(0));
        return ResponseEntity.ok(shows);
    }

}
