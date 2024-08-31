package com.Movie.Movie.Booking.System.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> registeruser(@RequestBody UserInfo user){
        System.out.println(user);
        String response = myUserDetailsService.registerUser(user);
        return ResponseEntity.ok(response);
    }
}
