package com.Movie.Movie.Booking.System.Exceptions;


public class TheatreNotFoundException extends RuntimeException{
    public TheatreNotFoundException(String message){
        super(message);
    }
}
