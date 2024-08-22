package com.Movie.Movie.Booking.System.Exceptions;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException(String message){
        super(message);
    }
}
