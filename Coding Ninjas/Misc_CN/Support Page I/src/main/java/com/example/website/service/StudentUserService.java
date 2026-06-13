package com.example.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.website.domain.User;

@Service
public class StudentUserService implements UserService {
	
	@Autowired
	User studentUser;

	@Override
	public User getUser() {
		return studentUser;
	}

	@Override
	public boolean signUp(String name, String gender, String location, String college) {
		boolean isStudentCreated = studentUser.createUser(name, gender, location, college);
		studentUser.saveUser();
		return isStudentCreated;
	}

}
