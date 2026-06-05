package com.example.airtel.service;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.NormalUser;

public interface UserService {
	void registerNormalUser(NormalUser user);
	void registerCorporateUser(CorporateUser user);
	void addNormalPlan(NormalPlan plan);
	void addCorporatePlan(CorporatePlan plan);
}
