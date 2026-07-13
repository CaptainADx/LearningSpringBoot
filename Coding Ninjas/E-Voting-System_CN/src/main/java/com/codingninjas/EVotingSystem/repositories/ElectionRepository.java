package com.codingninjas.EVotingSystem.repositories;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.EVotingSystem.entities.Election;

public interface ElectionRepository extends JpaRepository<Election, Long> {

	@Query("Select e from Election e where e.name = ?1")
	public Election findByName(String electionName);


}
