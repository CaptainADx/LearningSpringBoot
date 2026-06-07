package com.example.website.service;

import com.example.website.domain.User;

public interface UserService {
	public User getUser();
	public boolean signUp(String name, String gender, String location, String college);

}
