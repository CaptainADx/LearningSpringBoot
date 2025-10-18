  package com.geek;

import java.util.List;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService (UserRepository userRepository) {
		this.userRepository  = userRepository;
	}
	
	public String getUserNameInUpperCase(int id) {
		User user = userRepository.findById(id);
		if(user != null) {
			String name = user.getName().toUpperCase();
			return name;
		}
		return "Not Available";
	}
	
	public List<String> getAllPremiumUser(){
		List<String> userNames = userRepository.getAllUser().stream().filter(u -> u.isPremium()).map(u->u.getName()).toList();
		
		return userNames;
	}
	
	public boolean checkForPremium(int id) {
		User user = userRepository.findById(id);
		return user.isPremium();
	}
}	
