package com.CN.Gym.service;

import com.CN.Gym.dto.UserRequest;
import com.CN.Gym.dto.WorkoutDto;
import com.CN.Gym.exception.UserNotFoundException;
import com.CN.Gym.model.Role;
import com.CN.Gym.model.User;
import com.CN.Gym.model.Workout;
import com.CN.Gym.repository.UserRepository;
import com.CN.Gym.repository.WorkoutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

@Service
public class UserService {

        /*
        This is the service class for User, you need to complete the class by doing the following:
        a. Use appropriate annotations.
        b. Complete the methods given below.
        c. Autowire the necessary dependencies.
     */

	@Autowired
	 UserRepository userRepo;
	@Autowired
	 WorkoutRepository workoutRepo;
	
	
	

	
    public List<User> getAllUsers() {
    	return userRepo.findAll();
    }

    

    @Transactional
    public void createUser(UserRequest userRequest) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userRequest.getPassword());
        
        User user = User.builder().email(userRequest.getEmail()).age(userRequest.getAge())
                .gender(userRequest.getGender()).password(encodedPassword)
                .build();
        
        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        
        if(userRequest.getUserType() != null) {
            if (userRequest.getUserType().equalsIgnoreCase("TRAINER")) {
                role.setRoleName("ROLE_TRAINER");
                roles.add(role);
                user.setRoles(roles);
            } else if (userRequest.getUserType().equalsIgnoreCase("ADMIN")) {
                role.setRoleName("ROLE_ADMIN");
                roles.add(role);
                user.setRoles(roles);
            } else {
                role.setRoleName("ROLE_CUSTOMER");
                roles.add(role);
                user.setRoles(roles);
            }
        }
        else {
            role.setRoleName("ROLE_CUSTOMER");
            roles.add(role);
            user.setRoles(roles);
        }
        userRepo.save(user);
    }

    public User getUserById(Long id) {
    	return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }
    


    @Transactional
    public void updateUser(UserRequest userRequest, Long id) {
    	User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    	
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
    	
    	user.setAge(userRequest.getAge());
    	user.setEmail(userRequest.getEmail());
    	user.setGender(userRequest.getGender());
    	user.setPassword(encodedPassword);
    	user.setType(userRequest.getUserType());
    	
    	userRepo.save(user);
    
    }


    @Transactional
    public void deleteUser(Long id){
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    	
        userRepo.delete(user);
    }


    @Transactional
    public void addWorkout(WorkoutDto workoutDto, Long userId) {
    	User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
    	
    	Workout workout = new Workout();
    	
    	workout.setDescription(workoutDto.getDescription());
    	workout.setDifficultyLevel(workoutDto.getDifficultyLevel());
    	workout.setDuration(workoutDto.getDuration());
    	workout.setWorkoutName(workoutDto.getWorkoutName());

    	workout.setUser(user);
    	
    	workoutRepo.save(workout);
    	
    	user.getWorkouts().add(workout);
    	
    	userRepo.save(user);
    }
}
