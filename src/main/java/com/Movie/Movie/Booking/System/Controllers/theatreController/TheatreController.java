package com.Movie.Movie.Booking.System.Controllers.theatreController;

import com.Movie.Movie.Booking.System.DTO.TheatreDTOs.TheatreDTO;
import com.Movie.Movie.Booking.System.Modals.Theatres;
import com.Movie.Movie.Booking.System.Services.movieService.MovieService;
import com.Movie.Movie.Booking.System.Services.theatreService.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/theatres")
public class TheatreController {
    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }

    // Get all theatres located in a specific location
    @GetMapping("/locationName/{locationname}")
    public ResponseEntity<List<TheatreDTO>> getAllTheatresByLocation(@PathVariable(name = "locationname") String locationName){
        List<TheatreDTO> theatres = theatreService.findAllTheatresByLocationName(locationName.toLowerCase());
        System.out.println(theatres + "from controller");
        return ResponseEntity.ok(theatres);
    }

    // Get all theatres available for a particular movie
    @GetMapping("/{moviename}")
    public ResponseEntity<List<Theatres>> getAllTheatresByMovieName(@PathVariable(name = "moviename") String movieName){
        List<Theatres> theatres = theatreService.getAllTheatresByMovieName(movieName.toLowerCase());
        System.out.println(theatres.get(0).getTheatreName());
        return ResponseEntity.ok(theatres);
    }

}
