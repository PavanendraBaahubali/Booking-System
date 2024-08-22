package com.Movie.Movie.Booking.System.Exceptions;

public class SeatNotAvailableException extends RuntimeException{
    public SeatNotAvailableException(String message){
        super(message);
    }

}
