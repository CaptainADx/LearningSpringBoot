package com.cn.hotel.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.cn.hotel.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepo; 
	
	public CustomUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return this.userRepo.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
	}
	
	
	

}
