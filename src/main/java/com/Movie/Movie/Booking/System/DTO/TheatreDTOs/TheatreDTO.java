package com.Movie.Movie.Booking.System.DTO.TheatreDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TheatreDTO {
    private Long theatreId;
    private String theatreName;

    public TheatreDTO() {
    }
}
