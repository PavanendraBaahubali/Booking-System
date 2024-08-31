package com.Movie.Movie.Booking.System.Security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private UserInfo userInfo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userInfo.getRoles().
                stream().
                map((role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))).
                collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        System.out.println(userInfo.getUserName());
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
