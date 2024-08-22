package com.Movie.Movie.Booking.System.DTO.TheatreDTOs;

public class TheatreDTO {
    private Long theatreId;
    private String theatreName;

    public TheatreDTO() {
    }

    public TheatreDTO(Long theatreId, String theatreName) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }
}
