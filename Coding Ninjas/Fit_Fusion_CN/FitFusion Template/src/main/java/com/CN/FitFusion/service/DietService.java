package com.CN.FitFusion.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.DietDto;
import com.CN.FitFusion.exception.DietNotFoundException;
import com.CN.FitFusion.exception.UserNotFoundException;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.DietRepository;
import com.CN.FitFusion.repository.UserRepository;

@Service
public class DietService {
	
	@Autowired
	DietRepository dietRepo;
	
	@Autowired
	UserRepository userRepo;

	public List<Diet> getAllDiets() {
		return dietRepo.findAll();
	}

	public Diet getDietById(Long id) {
		
		return dietRepo.findById(id)
		        .orElseThrow(() ->
		            new DietNotFoundException("Diet not found"));
	}

	public void createDiet(DietDto dietDto, Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		
		if(dietDto == null) return;
		
		Diet diet = new Diet();
		diet.setDescription(dietDto.getDescription());
		diet.setName(dietDto.getName());
		diet.setUser(user);
		user.getDiets().add(diet);
		
		dietRepo.save(diet);
		userRepo.save(user);
	
		
	}

	
	public void updateDiet(DietDto dietDto, Long id) {
		Diet diet = dietRepo.findById(id).orElseThrow(() -> new DietNotFoundException("Diet not found"));
		
		diet.setDescription(dietDto.getDescription());
		diet.setName(dietDto.getName());
		
		dietRepo.save(diet);
		
		
	}

	
	public void deleteDiet(Long id) {
		Diet diet = dietRepo.findById(id).orElseThrow(() -> new DietNotFoundException("Diet not found"));
		
		User user = diet.getUser();
		user.getDiets().remove(diet);

	    dietRepo.delete(diet);
		
	}
	
}
