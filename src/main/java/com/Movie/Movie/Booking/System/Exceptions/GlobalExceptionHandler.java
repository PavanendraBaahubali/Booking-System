package com.Movie.Movie.Booking.System.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TheatreNotFoundException.class)
    public ResponseEntity<String> handleTheatresNotFoundException(TheatreNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ShowNotFoundException.class)
    public ResponseEntity<String> handleShowNotFoundException(ShowNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(SeatNotAvailableException.class)
    public ResponseEntity<String> handleSeatNotAvailable(SeatNotAvailableException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistedException.class)
    public ResponseEntity<String> handleUserAlreadyExistedException(UserAlreadyExistedException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
