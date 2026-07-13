package com.CN.Gym.service;


import com.CN.Gym.dto.GymDto;
import com.CN.Gym.exception.GymNotFoundException;
import com.CN.Gym.exception.UserNotFoundException;
import com.CN.Gym.model.Gym;
import com.CN.Gym.model.User;
import com.CN.Gym.repository.GymRepository;
import com.CN.Gym.repository.UserRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService {

    /*
        This is the service class for Gym, you need to complete the class by doing the following:
        a. Use appropriate annotations.
        b. Complete the methods given below.
        c. Autowire the necessary dependencies.
     */
	@Autowired
	GymRepository gymRepo;
	
	@Autowired
	UserRepository userRepo;
	

    public List<Gym> getAllGyms() {   
    	return gymRepo.findAll();
    }

    
     public Gym getGymById(Long id) {
    	 return gymRepo.findById(id).orElseThrow(()-> new GymNotFoundException("Gym with Id : " + id + " not found"));
    }


     @Transactional
    public void deleteGymById(Long id) {        
    	Gym gym = gymRepo.findById(id).orElse(null);
        if(gym == null) return;
    	gymRepo.delete(gym);
    }


    @Transactional
    public void updateGym(GymDto gymDto, Long id) {
    	
    	Gym gym = gymRepo.findById(id)
        .orElseThrow(() ->
                new GymNotFoundException("Gym with id " + id + " not found"));
    	gym.setAddress(gymDto.getAddress());
    	gym.setContactNo(gymDto.getContactNo());
    	gym.setFacilities(gymDto.getFacilities());
    	gym.setMembershipPlans(gymDto.getMembershipPlans());
    	gym.setName(gymDto.getName());
    	
    	gymRepo.save(gym);
    }


    @Transactional
    public void createGym(GymDto gymDto) {
    	Gym gym = new Gym();
    	gym.setAddress(gymDto.getAddress());
    	gym.setContactNo(gymDto.getContactNo());
    	gym.setFacilities(gymDto.getFacilities());
    	gym.setMembershipPlans(gymDto.getMembershipPlans());
    	gym.setName(gymDto.getName());
    	
    	
    	gymRepo.save(gym);
    }


    @Transactional
    public void addMember(Long userId, Long gymId) {
    	Gym gym = gymRepo.findById(gymId).orElseThrow(() ->
                new GymNotFoundException("Gym with id " + gymId + " not found"));
    	
    	User user = userRepo.findById(userId).orElseThrow( () -> 
    			new UserNotFoundException("User with id " + userId + " not found"));
    	
    	gym.getMembers().add(user);
    	user.setGym(gym);
    	
    	userRepo.save(user);
    	
    	gymRepo.save(gym);
    	
    }

    @Transactional
    public void deleteMember(Long userId, Long gymId) {
    	Gym gym = gymRepo.findById(gymId)
    			.orElseThrow(() -> new GymNotFoundException("Gym with id " + gymId + " not found"));

    			User user = userRepo.findById(userId).orElse(null);
    			if (user == null) return;
    			if (!gym.getMembers().contains(user)) return;

    			if (!gym.getMembers().remove(user)) return;
    			
    			gym.getMembers().remove(user);
    			if (user.getGym() != null && user.getGym().getId().equals(gymId)) {
    			    user.setGym(null);
    			    userRepo.save(user);
    			}
    	

    }
}
