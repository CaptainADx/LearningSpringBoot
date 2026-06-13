package com.example.airtel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.NormalUser;
import com.example.airtel.service.UserService;


@Controller
public class AirtelController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public String home() {
		return "welcome";
	}
	
	//Normal Setting
	
	@GetMapping("/normalSignup")
	public String normalSignup(@ModelAttribute("normalUser") NormalUser user) {
		return "normalUserSignUpPage";
	}
	
	@PostMapping("/saveNormalUser")
	public String addNormalUser(@ModelAttribute("normalUser") NormalUser normalUser, @ModelAttribute("normalPlan") NormalPlan normalPlan) {
		userService.registerNormalUser(normalUser);
		return "normalPlans";
	}
	
	@PostMapping("/saveNormalPlan")
	public String saveNormalPlan(@ModelAttribute("normalPlan") NormalPlan normalPlan) {
		userService.addNormalPlan(normalPlan);
		return "thankyou";
	}
	
	
	//Corporate Setting
	
	@GetMapping("/corporateSignup")
	public String corporateSignup(@ModelAttribute("corporateUser") CorporateUser corporateUser) {
		return "corporateUserSignUpPage";
	}
	
	@PostMapping("/saveCorporatePlan")
	public String saveCorporatePlan(@ModelAttribute("corporatePlan") CorporatePlan corporatePlan) {
		userService.addCorporatePlan(corporatePlan);
		return "thankyou";
	}
	
	
	@PostMapping("/saveCorporateUser")
	public String addCorporateUser(@ModelAttribute("corporateUser") CorporateUser corporateUser, @ModelAttribute("corporatePlan") CorporatePlan corporatePlan) {
		userService.registerCorporateUser(corporateUser);
		return "thankyou";
	}
	
	
	
	
	
	
	
	
}
