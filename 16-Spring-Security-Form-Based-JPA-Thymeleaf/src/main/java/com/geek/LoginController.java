package com.geek;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.geek.entity.User;
import com.geek.service.UserService;

@Controller
public class LoginController {

	
	
	@GetMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@GetMapping("/other")
	public String otherPage() {
		return "other";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String adminPage(Principal p, Model model) {
		System.out.println(p.getName());
		model.addAttribute("user", p.getName());
		return "admin";
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')") 
	@GetMapping("/user")
	public String userPage(Principal p, Model model) {
		System.out.println(p.getName());
		model.addAttribute("user", p.getName());
		return "user";
	}
	
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		if(userService.getUserByUserName(user.getUserName()) != null) {
			return ResponseEntity.badRequest().body("Username already exists. Please choose another one.");
		}
		userService.saveUser(user);
		
		return ResponseEntity.ok("User Registration Successful !");
	}
	
}
