package com.Movie.Movie.Booking.System.Services.movieService;

import com.Movie.Movie.Booking.System.Exceptions.MovieNotFoundException;
import com.Movie.Movie.Booking.System.Modals.Movies;
import com.Movie.Movie.Booking.System.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public List<Movies> getMoviesList(){
        return movieRepo.findAll();
    }

    public Movies getMovieById(Long id) {
        Optional<Movies> movie = movieRepo.findById(id);
        if (movie.isEmpty()) {
            throw new MovieNotFoundException("Movie with ID " + id + " not found");
        } else {
            return movie.get(); // Return the actual Movies object
        }
    }


    public Movies getMovieByName(String movieName) {
        System.out.println("request coming to service layer");

        Movies movie = movieRepo.findByMovieName(movieName);
        if (movie == null) {
            throw new MovieNotFoundException("Movie with name: " + movieName + " not found");
        } else {
            return movie;
        }
    }

    public List<Movies> getMoviesByGenre(String genre){
        List<Movies> movie = movieRepo.getMoviesByGenre(genre);
        if (movie == null) throw new MovieNotFoundException("Movie not found with : " + genre);
        else return movie;
    }

    public List<Movies> getAllMoviesByLocationName(String locationName){
        List<Movies> movie = movieRepo.getMoviesByLocation(locationName);
        if (movie.isEmpty()) throw new MovieNotFoundException("movie is not found with " + locationName);
        else return movie;
    }



}
