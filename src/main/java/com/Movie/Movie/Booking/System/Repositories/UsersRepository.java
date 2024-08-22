package com.Movie.Movie.Booking.System.Repositories;

import com.Movie.Movie.Booking.System.Modals.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
