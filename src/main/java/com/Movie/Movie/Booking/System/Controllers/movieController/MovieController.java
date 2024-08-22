package com.Movie.Movie.Booking.System.Controllers.movieController;

import com.Movie.Movie.Booking.System.Exceptions.MovieNotFoundException;
import com.Movie.Movie.Booking.System.Modals.Movies;
import com.Movie.Movie.Booking.System.Services.movieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    // Get all movies from database
    @GetMapping("movies")
    public ResponseEntity<List<Movies>> getMovies(){
        List<Movies> movies = movieService.getMoviesList();
        return ResponseEntity.ok(movies);
    }

    // Get specified movie from database by using movie ID
    @GetMapping("movies/id/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable Long id){
            Movies movie = movieService.getMovieById(id);
            return ResponseEntity.ok(movie);
    }

    // Get specific movie from database by using movie name
    @GetMapping("movies/name/{moviename}")
    public ResponseEntity<Movies> getMovieByName(@PathVariable(name = "moviename") String movieName){
        System.out.println("request coming to controller");
        Movies movie =  movieService.getMovieByName(movieName);
        return ResponseEntity.ok(movie);
    }

    // Get all movies based on genres
    @GetMapping("movies/genre/{genre}")
    public ResponseEntity<List<Movies>> getMovieByGenre(@PathVariable String genre){
        List<Movies> movie = movieService.getMoviesByGenre(genre.toLowerCase());
        return ResponseEntity.ok(movie);
    }

    // Get all movies by locationName
    @GetMapping("movies/location/{locationname}")
    public ResponseEntity<List<Movies>> getAllMoviesByLocationName(@PathVariable(name = "locationname") String locationName){
        System.out.println(locationName);
        List<Movies> movie = movieService.getAllMoviesByLocationName(locationName.toLowerCase());
        return ResponseEntity.ok(movie);
    }

}
