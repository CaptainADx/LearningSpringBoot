package com.CodingNinjas.LeaveXpress.controller;

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

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
	
	/*
	 *  • GET “/api/leave/{id}” (@PathVariable Long id): This API allows the employee to fetch a Leave record by its ID. It returns an OK response status.

	    • GET "/api/leave/all": This API allows employees to fetch all Leaves records. It returns an OK response status.
	
	    • GET "/api/leave/accepted": This API allows employees to fetch all accepted Leave Records. It returns an OK response status.
	
	    • GET "/api/leave/rejected": This API allows employees to fetch all rejected Leave  Records. It returns an OK response status.
	
	    • GET "/api/leave/status/{id}" (@PathVariable Long id): This API allows the employee to fetch a Leave Record status by its ID. It returns an OK response status.
	 */
	
	@Autowired
	LeaveService service;
	
	@GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public LeaveModel getLeaveById(@PathVariable Long id) {
		return service.getLeaveById(id);
	}
	
	@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	public List<LeaveModel> getAllLeave(){
		return service.getAllLeave();
	}
	
	@GetMapping("/accepted")
    @ResponseStatus(HttpStatus.OK)
	public List<LeaveModel> getAllAcceptedLeave(){
		return service.getAllAcceptedLeave();
	}
	
	@GetMapping("/rejected")
    @ResponseStatus(HttpStatus.OK)
	public List<LeaveModel> getAllRejectedLeave(){
		return service.getAllRejectedLeave();
	}
	
	@GetMapping("/status/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Boolean getLeaveRecordStatusById(@PathVariable Long id) {
		return service.getLeaveRecordStatusById(id);
	}
	
	
	/*
	 * 
	 * • PUT "/api/leave/{id}" (@PathVariable Long id, @RequestBody LeaveDto updatedLeave): This API allows the employee to update a Leave Record by its ID. It returns an OK response status.
	 */
	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public void updateLeave(@PathVariable Long id, @RequestBody LeaveDto updatedLeave) {
		service.updateLeave(id, updatedLeave);
	}
	
	
	
	/*
	 * • DELETE "/api/leave/{id}" (@PathVariable Long id): This API allows the employee to delete a Leave Record by its ID. It returns an OK response status.
	*/
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteLeaveById(@PathVariable Long id) {
		service.deleteLeaveById(id);
	}
	
	
	/*
	 *  • POST "/api/leave/apply" (@RequestBody LeaveDto leaveRequest): This API allows the employees to apply for a leave. It returns an OK response status.

	    • POST "/api/leave/accept/{id}" (@PathVariable Long id): This API allows the manager to accept a Leave Record by its ID. It returns an ACCEPTED response status.
	
	    • POST "/api/leave/reject/{id}" (@PathVariable Long id): This API allows the manager to reject a Leave Record by its ID. It returns an OK response status.
	 */
	
	@PostMapping("/apply")
	@ResponseStatus(HttpStatus.OK)
	public void createLeaveRequest(@RequestBody LeaveDto leaveRequest) {
		service.createLeaveRequest(leaveRequest);
	}
	
	
	@PostMapping("/accept/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PreAuthorize("hasRole('MANAGER')")
	public void acceptLeaveRequest(@PathVariable Long id) {
		service.acceptLeaveRequest(id);
	}
	
	@PostMapping("/reject/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('MANAGER')")
	public void rejectLeaveRequest(@PathVariable Long id) {
		service.rejectLeaveRequest(id);
	}
	
	
}
