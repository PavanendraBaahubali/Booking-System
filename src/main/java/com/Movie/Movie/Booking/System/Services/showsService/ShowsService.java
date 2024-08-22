package com.Movie.Movie.Booking.System.Services.showsService;

import com.Movie.Movie.Booking.System.Modals.Shows;
import com.Movie.Movie.Booking.System.Repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShowsService {
    private final ShowRepository showRepo;

    @Autowired
    public ShowsService(ShowRepository showRepo){
        this.showRepo = showRepo;
    }

    public List<Shows> getAllAvailableShowsByTheatreId(Long theatreId){
        List<Shows> shows = showRepo.getAllAvailableShowsByTheatreId(theatreId);
        System.out.println(shows.get(0));
        return shows;
    }

}
