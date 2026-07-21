package com.CN.FitFusion.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	

	/*
	 1. Autowire the necessary dependencies and override the interface methods.
	*/
	@Autowired
	UserRepository userRepo;
//	
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	
//	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User with username: " + username + " not found"));
	}
	
	
	

}