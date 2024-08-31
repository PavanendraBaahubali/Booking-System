package com.Movie.Movie.Booking.System.Security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepo myUserRepo;

    @Autowired
    private RoleRepo roleRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = myUserRepo.findByUserName(username);
        System.out.println(user.getUserName() + "and" + user.getRoles());
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return new MyUserDetails(user);
    }

    public String registerUser(UserInfo user){
        UserInfo existingUser = myUserRepo.findByUserName(user.getUserName());
        if (existingUser != null){
            System.out.println("user already existed");
            throw new RuntimeException("User already existed with username:" + user.getUserName());
        }
        Roles defaultRole = roleRepo.findByRole("USER");

        UserInfo newUser = new UserInfo();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setRoles(new ArrayList<>());
        newUser.getRoles().add(defaultRole);

        myUserRepo.save(newUser);
        return "User successfully registered.";
    }


}
