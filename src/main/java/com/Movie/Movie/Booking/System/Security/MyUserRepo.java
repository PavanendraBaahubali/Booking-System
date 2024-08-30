package com.Movie.Movie.Booking.System.Security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUserName(String userName);
}
