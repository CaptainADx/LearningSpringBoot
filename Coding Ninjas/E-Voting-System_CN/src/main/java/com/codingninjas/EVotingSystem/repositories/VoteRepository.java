package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

//import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
	
	@Query("Select Count(v) from Vote v")
	public long countVotes();

	@Query("Select Count(v) from Vote v where v.election.name = ?1")
	public long countVotesByElectionName(String electionName);
	
	@Query("SELECT COUNT(v) FROM Vote v WHERE v.user.id = ?1 AND v.election.id = ?2")
	long countVotesByUserAndElection(Long userId, Long electionId);
}
