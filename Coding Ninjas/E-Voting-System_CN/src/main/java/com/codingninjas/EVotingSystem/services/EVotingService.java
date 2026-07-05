package com.codingninjas.EVotingSystem.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        
    }

    public void addUser(User user) {
        
    }

    public List<User> getAllUsers() {
       
    }

    public void addVote(Long userId, Long electionId, Long electionChoiceId) {
    
    }

    public void addElection(Election election) {
        
    }

    public boolean AlreadyGivenVote(Long userId, Long electionId) {
        
    }

    public List<Election> getAllElections() {
        
    }

    public void addElectionChoice(ElectionChoice electionChoice) {
        
    }

    public List<ElectionChoice> getAllElectionChoices() {
        
    }

    public Election findElectionByName(String electionName) {
        
    }

    public long countTotalVotes() {
       
    }

    public long countVotesByElectionName(String electionName) {
        
    }

    public long choicesByElection(Long electionId) {

    }

	public ElectionChoice findElectionWinner(String electionName) {
   
	}
}
