package com.Movie.Movie.Booking.System.Services.SeatingService;

import com.Movie.Movie.Booking.System.DTO.seatDTO.SeatDTO;
import com.Movie.Movie.Booking.System.Exceptions.ShowNotFoundException;
import com.Movie.Movie.Booking.System.Exceptions.TheatreNotFoundException;
import com.Movie.Movie.Booking.System.Modals.Seats;
import com.Movie.Movie.Booking.System.Modals.Shows;
import com.Movie.Movie.Booking.System.Modals.Theatres;
import com.Movie.Movie.Booking.System.Repositories.SeatingRepository;
import com.Movie.Movie.Booking.System.Repositories.TheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {
    private final TheatresRepository theatresRepository;
    private final SeatingRepository seatingRepository;

    @Autowired
    public SeatService(TheatresRepository theatresRepository, SeatingRepository seatingRepository){
        this.theatresRepository = theatresRepository;
        this.seatingRepository = seatingRepository;
    }
//    public void addSeatsToTheatre(int seatCapacity, long theatreId){
//        Theatres theatre = theatresRepository.findById(theatreId).orElseThrow(() -> new TheatreNotFoundException("Theatre Not Found with Id" + theatreId));
//
//
//        for (int i = 1; i <= seatCapacity; i ++){
//            Seats seats = new Seats();
//            seats.setSeatNumber("seat" + i);
//            seats.setTheatres(theatre);
//            seats.setStatus("Available");
//            seatingRepository.save(seats);
//            theatre.getSeats().add(seats);
//        }
//
//        theatresRepository.save(theatre);
//
//    }

    public List<SeatDTO> getAllAvailableShowsForASeat(Long seatId, Long theatreId, Long showId){
        List<SeatDTO> shows = seatingRepository.getAvailableShowsForASeat(seatId, theatreId, showId);
        System.out.println(shows);
        if (shows.isEmpty()) throw new ShowNotFoundException("No Shows were found with seat id, theatre id, show id: " + seatId + " " + theatreId + " " +  showId);
        else return shows;
    }




}
