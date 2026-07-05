package com.codingninjas.EVotingSystem.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.EVotingService;

@RestController
public class EVotingController {
	
	@Autowired
	EVotingService EVotingService;

	// User

	@PostMapping("/add/user")
	public void addUser(@RequestBody User user) {
	
	}

	@GetMapping("/get/users")
	public List<User> getAllUsers(){
		
	}

	// Election

	@PostMapping("/add/election")
	public void addElection(@RequestBody Election election) {
	
	}

	@GetMapping("/get/elections")
	public List<Election> getAllElections(){
		
	}

	// ElectionChoice

	@PostMapping("/add/electionChoice")
	public void addElectionChoice(@RequestBody ElectionChoice electionChoice) {
		
	}

	@GetMapping("/get/electionChoices")
	public List<ElectionChoice> getAllElectionChoices() {
		
	}

	@GetMapping("/count/{electionId}")
	public long getCountByElectionId(@PathVariable Long electionId){
		
	}

	// Vote




	// Result


}
