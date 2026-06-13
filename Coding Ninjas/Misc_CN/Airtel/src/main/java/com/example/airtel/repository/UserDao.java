package com.example.airtel.repository;


import java.util.List;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.NormalUser;
import com.example.airtel.domain.Plan;
import com.example.airtel.domain.User;

public interface UserDao {
	
	void addNormalUser(NormalUser normalUser);
	void addCorporateUser(CorporateUser corporateUser);
	void addNormalPlan(NormalPlan normalPlan);
	void addCorporatePlan(CorporatePlan corporatePlan);
	List<User> getAllUsers();
	List<Plan> getAllPlans();
	
}
