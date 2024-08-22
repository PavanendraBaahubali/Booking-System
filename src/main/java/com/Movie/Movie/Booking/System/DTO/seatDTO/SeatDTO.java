package com.Movie.Movie.Booking.System.DTO.seatDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {
    private Long showId;
    private Long theatreId;
    private String showTimings;
    private Long seatId;
    private String seatNumber;
    private String seatStatus;
}
