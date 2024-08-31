package com.Movie.Movie.Booking.System.Security;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String role;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private List<UserInfo> users;
}
