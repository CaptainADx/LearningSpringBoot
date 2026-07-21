package com.CN.Gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.CN.Gym.dto.JwtRequest;
import com.CN.Gym.dto.JwtResponse;
import com.CN.Gym.jwt.JwtAuthenticationHelper;

@Service
public class AuthService {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtAuthenticationHelper helper;

    public JwtResponse login(JwtRequest jwtRequest) {

        doAuthentication(jwtRequest.getUsername(),
                         jwtRequest.getPassword());

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        jwtRequest.getUsername());

        String token = helper.buildToken(userDetails);

        return new JwtResponse(token);
    }

    private void doAuthentication(String username, String password) {

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        username,
                        password);

        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Credentials Entered");
        }
    }
}