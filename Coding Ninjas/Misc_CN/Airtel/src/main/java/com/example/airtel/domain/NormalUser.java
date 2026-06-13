package com.example.airtel.domain;

import org.springframework.stereotype.Component;

@Component
public class NormalUser implements User {
	
	String name;
	String registrationNumber;
	String planType;
	int userId;
	
	public void setUserId(int id) {
		this.userId = id;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	@Override
	public void createUser(String name, String registrationNumber, String planType) {
		this.setName(name);
		this.setRegistrationNumber(registrationNumber);
		this.setPlanType(planType);
	}

}
