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

import com.CN.FitFusion.dto.DietDto;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.service.DietService;

@RestController
@RequestMapping("/diet")
public class DietController {
	
	@Autowired
	DietService dietService;
	
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public List<Diet> getAllDiets(){
		return dietService.getAllDiets();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public Diet getDietById(@PathVariable Long id) {
		return dietService.getDietById(id);
	}
	
	@PostMapping("/create/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('TRAINER')")
	public void createDiet(@RequestBody DietDto dietDto, @PathVariable Long userId) {
		dietService.createDiet(dietDto, userId);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public void updateDiet(@RequestBody DietDto dietDto, @PathVariable Long id) {
		dietService.updateDiet(dietDto, id);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public void deleteDiet(@PathVariable Long id) {
		dietService.deleteDiet(id);
	}
	
}










