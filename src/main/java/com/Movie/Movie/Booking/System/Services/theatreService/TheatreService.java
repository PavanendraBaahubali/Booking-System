package com.Movie.Movie.Booking.System.Services.theatreService;

import com.Movie.Movie.Booking.System.DTO.TheatreDTOs.TheatreDTO;
import com.Movie.Movie.Booking.System.Exceptions.TheatreNotFoundException;
import com.Movie.Movie.Booking.System.Modals.Theatres;
import com.Movie.Movie.Booking.System.Repositories.TheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ContextLifecycleScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatresRepository theatresRepo;

    @Autowired
    public TheatreService(TheatresRepository theatresRepo) {
        this.theatresRepo = theatresRepo;
    }

    public List<TheatreDTO> findAllTheatresByLocationName(String locationName){
        List<TheatreDTO> theatres = theatresRepo.findAllTheatresByLocationName(locationName);
        System.out.println(theatres + "from service");
        if (theatres.isEmpty()) throw new TheatreNotFoundException("theatres are not found location in location " + locationName);
        else return theatres;
    }

    public List<Theatres> getAllTheatresByMovieName(String movieName){
        List<Theatres> theatres  = theatresRepo.findAllTheatresByMovieName(movieName);
        System.out.println(theatres.get(0).getTheatreName());
        if (theatres.isEmpty()) throw new TheatreNotFoundException("no theatres are found with movieName " + movieName);
        else return theatres;
    }

}
