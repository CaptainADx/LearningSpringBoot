package com.codingninjas.EVotingSystem.repositories;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;

public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long> {

	@Query("SELECT v.electionChoice FROM Vote v WHERE v.election.id = ?1 GROUP BY v.electionChoice ORDER BY COUNT(v.id) DESC ")
	List<ElectionChoice> findWinner(Long electionId, Pageable pageable);
    
    @Query("select Count(ec) from ElectionChoice ec where ec.election.id = ?1 ")
    Long countAllChoiceByElectionId(Long id);
}
