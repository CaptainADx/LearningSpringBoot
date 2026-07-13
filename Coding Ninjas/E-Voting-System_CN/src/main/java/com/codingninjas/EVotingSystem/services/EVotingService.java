package com.codingninjas.EVotingSystem.services;

import java.util.List;

//import javax.swing.colorchooser.ColorSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class EVotingService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    ElectionChoiceRepository electionChoiceRepository;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public void addVote(Long userId, Long electionId, Long electionChoiceId) {
    	User user = userRepository.findById(userId).get();
    	
    	Election election = electionRepository.findById(electionId).get();
    	
    	ElectionChoice electionChoice = electionChoiceRepository.findById(electionChoiceId).get();
    	
    	Vote vote = new Vote();
    	
    	vote.setUser(user);
    	vote.setElection(election);
    	vote.setElectionChoice(electionChoice);
    	
    	voteRepository.save(vote);
    	
    }

    public void addElection(Election election) {
    	
        electionRepository.save(election);
    }

    public boolean AlreadyGivenVote(Long userId, Long electionId) {
        return voteRepository.countVotesByUserAndElection(userId, electionId) > 0;
    }

    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    public void addElectionChoice(ElectionChoice electionChoice) {
    	Long electionId = electionChoice.getElection().getId();

        Election election = electionRepository.findById(electionId).orElseThrow();

        electionChoice.setElection(election);

        electionChoiceRepository.save(electionChoice);
    }

    public List<ElectionChoice> getAllElectionChoices() {
        return electionChoiceRepository.findAll();
    }

    public Election findElectionByName(String electionName) {
        return electionRepository.findByName(electionName);
    }

    public long countTotalVotes() {
       return voteRepository.countVotes();
    }

    public long countVotesByElectionName(String electionName) {
        return voteRepository.countVotesByElectionName(electionName);
    }
    public long choicesByElection(Long electionId) {
    	return electionChoiceRepository.countAllChoiceByElectionId(electionId);
    }

	public ElectionChoice findElectionWinner(String electionName) {
		Election election = findElectionByName(electionName);
		long electionId = election.getId();
		
		List<ElectionChoice> winner = electionChoiceRepository.findWinner(electionId, PageRequest.of(0, 1));
		
		if(winner.isEmpty()) {
			return null;
		}
		
		return winner.get(0);
	}
}
