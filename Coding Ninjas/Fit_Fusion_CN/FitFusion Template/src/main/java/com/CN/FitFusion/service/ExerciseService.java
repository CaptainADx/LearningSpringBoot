package com.CN.FitFusion.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.ExerciseDto;
import com.CN.FitFusion.exception.ExerciseNotFoundException;
import com.CN.FitFusion.exception.UserNotFoundException;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.ExerciseRepository;
import com.CN.FitFusion.repository.UserRepository;


@Service
public class ExerciseService {

	@Autowired
	ExerciseRepository exerciseRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Exercise> getAllExercise() {
		return exerciseRepo.findAll();
	}

	public Exercise getExerciseById(Long id) {
		return exerciseRepo.findById(id).orElseThrow(()-> new ExerciseNotFoundException("No Exercise found"));
		
	}

	
	public void createExercise(ExerciseDto exerciseDto, Long userId) {
		
		User user = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));
		
		Exercise exercise = new Exercise();
		exercise.setDescription(exerciseDto.getDescription());
		exercise.setName(exerciseDto.getName());
		exercise.setReps(exerciseDto.getReps());
		exercise.setSets(exerciseDto.getSets());
		exercise.setUser(user);
		
		exerciseRepo.save(exercise);
		
		user.getExerciseList().add(exercise);
		
		userRepo.save(user);
		
		
	}

	public void updateExercise(ExerciseDto exerciseDto, Long id) {
		
		Exercise exercise = exerciseRepo.findById(id).orElseThrow(()->new ExerciseNotFoundException("Exercise not found"));
		
		exercise.setDescription(exerciseDto.getDescription());
		exercise.setName(exerciseDto.getName());
		exercise.setReps(exerciseDto.getReps());
		exercise.setSets(exerciseDto.getSets());
		
		exerciseRepo.save(exercise);
		
	}

	public void deleteExercise(Long id) {
		Exercise exercise = exerciseRepo.findById(id).orElseThrow(()->new ExerciseNotFoundException("Exercise not found"));
		
		
		User user = exercise.getUser();
		user.getExerciseList().remove(exercise);
		exerciseRepo.delete(exercise);
		userRepo.save(user);
	}

}
