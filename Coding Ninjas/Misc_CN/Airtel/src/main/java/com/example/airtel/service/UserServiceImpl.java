package com.example.airtel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.NormalUser;
import com.example.airtel.repository.UserDao;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public void registerNormalUser(NormalUser user) {
		userDao.addNormalUser(user);
	}

	@Override
	public void registerCorporateUser(CorporateUser user) {
		userDao.addCorporateUser(user);
	}

	@Override
	public void addNormalPlan(NormalPlan plan) {
		userDao.addNormalPlan(plan);
	}

	@Override
	public void addCorporatePlan(CorporatePlan plan) {
		userDao.addCorporatePlan(plan);
	}

}
