package com.CN.FitFusion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.JwtRequest;
import com.CN.FitFusion.dto.JwtResponse;
import com.CN.FitFusion.jwt.JwtAuthenticationHelper;

@Service
public class AuthService {
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtAuthenticationHelper helper;

	public JwtResponse login(JwtRequest jwtRequest) {
		
		
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();
	
		doAuthentication(username, password);
			
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		String token = helper.buildToken(userDetails);
		
		return new JwtResponse(token);
	}
	
	private void doAuthentication(String username, String password) {
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Credentials Entered");
        }
		
		
	}
	
	
	
	
}
