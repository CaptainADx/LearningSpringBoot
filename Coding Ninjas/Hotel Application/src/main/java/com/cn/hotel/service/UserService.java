package com.cn.hotel.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cn.hotel.dto.UserRequest;
import com.cn.hotel.model.User;
import com.cn.hotel.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public void createUser(UserRequest userRequest){
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
		
		User user = new User();
		
		user.setUsername(userRequest.getUsername());
		user.setPassword(encodedPassword);
	
	}
	
	
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
}
