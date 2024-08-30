package com.Movie.Movie.Booking.System.Security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepo myUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = myUserRepo.findByUserName(username);
        System.out.println(user.getUserName() + "and" + user.getRoles());
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return new MyUserDetails(user);
    }
}
