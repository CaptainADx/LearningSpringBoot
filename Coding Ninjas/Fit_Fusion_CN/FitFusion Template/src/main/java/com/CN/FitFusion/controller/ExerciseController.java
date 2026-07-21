package com.CN.FitFusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CN.FitFusion.dto.ExerciseDto;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.service.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
		@Autowired
		ExerciseService exerciseService;
		
		
//	   • GET “/exercise/all”: This API lets a trainer fetch all exercises. It returns an OK response status.
	
		@GetMapping("/all")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('TRAINER')")
		public List<Exercise> getAllExercises() {
			return exerciseService.getAllExercise();
		}
		
		
//     • GET “/exercise/{id}” (@PathVariable Long id): This API lets a trainer fetch an exercise by its ID. It returns an OK response status.
		
		@GetMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('TRAINER')")
		public Exercise getUserById(@PathVariable Long id) {
			return exerciseService.getExerciseById(id);
		}
		
		
//     • POST “/exercise/create/{userId}” (@RequestBody ExerciseDto exerciseDto, @PathVariable Long userId): This API allows a trainer to create an exercise for a user by using the user’s ID. It returns a CREATED response status.
		@PostMapping("/create/{userId}")
		@ResponseStatus(HttpStatus.CREATED)
		@PreAuthorize("hasRole('TRAINER')")
		public void createExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long userId) {
			exerciseService.createExercise(exerciseDto, userId);
		}
		
		
		
		
//     • PUT “/exercise/{id}” (@RequestBody ExerciseDto exerciseDto, @PathVariable Long id): This API allows a trainer to update an exercise by its ID. It returns an OK response status.
		@PutMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('TRAINER')")
		public void updateExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long id) {
			exerciseService.updateExercise(exerciseDto, id);
		}
		
		
		
//     • DELETE “/exercise/{id}” (@PathVariable Long id): This API allows a trainer to delete an exercise by its ID. It returns an OK response status.
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('TRAINER')")
		public void deleteExercise(@PathVariable Long id) {
			exerciseService.deleteExercise(id);
		}
	
	
}
