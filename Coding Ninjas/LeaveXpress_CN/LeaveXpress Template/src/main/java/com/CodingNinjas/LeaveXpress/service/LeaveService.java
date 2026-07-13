package com.CodingNinjas.LeaveXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.exception.LeaveNotFoundException;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	LeaveRepository repo;
	
	
	//Services for GET REQUESTS

	public LeaveModel getLeaveById(Long id) {
		return repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave with Id : " + id + " not found"));
	}

	public List<LeaveModel> getAllLeave() {
		return repo.findAll();
	}

	public List<LeaveModel> getAllAcceptedLeave() {
		
		return repo.getAllAccptedLeave();
	}

	public List<LeaveModel> getAllRejectedLeave() {
		return repo.getAllRejectedLeave();
	}

	public Boolean getLeaveRecordStatusById(Long id) {
		
		LeaveModel leave = repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave with Id : " + id + " not found"));
		
		return leave.isAccepted();
	}

	
	
	
	//SERVICES FOR PUT REQUESTS
	public void updateLeave(Long id, LeaveDto updatedLeave) {
		LeaveModel leave = repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave with Id : " + id + " not found"));
		
		leave.setType(updatedLeave.getType());
		leave.setStartDate(updatedLeave.getStartDate());
		leave.setEndDate(updatedLeave.getEndDate());
		leave.setDescription(updatedLeave.getDescription());
		
		repo.save(leave);
		
	}
	
	
	
	//SERVICES FOR DELETE REQUESTS
	public void deleteLeaveById(Long id) {
		LeaveModel leave = repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave with Id : " + id + " not found"));
		
		repo.delete(leave);
	}

	
	
	
	
	
	//SERVICES FOR POST REQUESTS
	
	public void createLeaveRequest(LeaveDto leaveRequest) {
		LeaveModel leave = new LeaveModel();
		leave.setType(leaveRequest.getType());
		leave.setStartDate(leaveRequest.getStartDate());
		leave.setEndDate(leaveRequest.getEndDate());
		leave.setDescription(leaveRequest.getDescription());
		
		repo.save(leave);
		
	}

	public void acceptLeaveRequest(Long id) {
		LeaveModel leave = repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave with Id : " + id + " not found"));
		
		
		leave.setAccepted(true);
		
		repo.save(leave);
	}

	public void rejectLeaveRequest(Long id) {
		LeaveModel leave = repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave with Id : " + id + " not found"));
		
		
		leave.setAccepted(false);
		
		repo.save(leave);
	}
	
	
	
	
	
	
	

}
