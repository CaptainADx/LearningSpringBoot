package com.example.airtel.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.NormalUser;
import com.example.airtel.domain.Plan;
import com.example.airtel.domain.User;


@Repository
public class UserDaoImpl implements UserDao{
	
	ArrayList<User> users = new ArrayList<>();
	ArrayList<Plan> plans = new ArrayList<>();
	

	@Override
	public void addNormalUser(NormalUser normalUser) {
		users.add(normalUser);
		System.out.println("Normal User Added");
		
	}

	@Override
	public void addCorporateUser(CorporateUser corporateUser) {
		users.add(corporateUser);
		System.out.println("Corporate User Added");
		
	}

	@Override
	public void addNormalPlan(NormalPlan normalPlan) {
		plans.add(normalPlan);
		System.out.println("Normal Plan Added");
	}

	@Override
	public void addCorporatePlan(CorporatePlan corporatePlan) {
		plans.add(corporatePlan);
		System.out.println("Corporate Plan Added");
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public List<Plan> getAllPlans() {
		
		return plans;
	}
	
	

}
