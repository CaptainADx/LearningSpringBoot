package com.CodingNinjas.LeaveXpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CodingNinjas.LeaveXpress.model.LeaveModel;


public interface LeaveRepository extends JpaRepository<LeaveModel, Long> {

	@Query("SELECT l from LeaveModel l where l.isAccepted = true")
	List<LeaveModel> getAllAccptedLeave();

	@Query("SELECT l from LeaveModel l where l.isAccepted = false")
	List<LeaveModel> getAllRejectedLeave();
	
	
	

}
