package com.CN.FitFusion.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.CN.FitFusion.repository.RoleRepository;
import com.CN.FitFusion.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.UserDto;
import com.CN.FitFusion.exception.UserNotFoundException;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.Role;
import com.CN.FitFusion.model.User;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;
    
    @Autowired
    RoleRepository roleRepo;
    
    

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	public void updateUser(UserDto userDto, Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
		
		if(userDto.getPassword() != null && !userDto.getPassword().equals("")) {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(userDto.getPassword());
			user.setPassword(encodedPassword);
		}
		
		user.setAge(userDto.getAge());
		user.setContactNo(userDto.getContactNo());
		user.setEmail(userDto.getEmail());
		
		user.setGender(userDto.getGender());
		
		userRepo.save(user);
		
		
	}

	public void deleteUser(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
		
		userRepo.delete(user);
		
	}

	

	
	public List<Exercise> getExerciseByUserId(Long id) {
		return userRepo.findExerciseByUserId(id);
	}
	
	
	
	public List<Diet> getDietByUserId(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findDietByUserId(id);
	}
	
	
	public void createUser(UserDto userDto) {

	    PasswordEncoder encoder = new BCryptPasswordEncoder();
	    String encodedPassword = encoder.encode(userDto.getPassword());

	    User user = User.builder()
	            .age(userDto.getAge())
	            .contactNo(userDto.getContactNo())
	            .email(userDto.getEmail())
	            .password(encodedPassword)
	            .gender(userDto.getGender())
	            .build();

//	    Set<Role> roles = new HashSet<>();
	    String roleName;

	    if (userDto.getUserType() == null) {
	        roleName = "ROLE_CUSTOMER";
	    } else if ("ADMIN".equalsIgnoreCase(userDto.getUserType())) {
	        roleName = "ROLE_ADMIN";
	    } else if ("TRAINER".equalsIgnoreCase(userDto.getUserType())) {
	        roleName = "ROLE_TRAINER";
	    } else {
	        roleName = "ROLE_CUSTOMER";
	    }

	    Role role = roleRepo.findByRoleName(roleName).orElse(null);

	    // If the role does not exist, create and save it first
	    if (role == null) {
	        role = new Role();
	        role.setRoleName(roleName);
	        role = roleRepo.save(role);
	    }
	    
	    role = roleRepo.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("Role Not Found"));
	    
	    user.getRoles().add(role);

	    userRepo.save(user);

	}

}






















