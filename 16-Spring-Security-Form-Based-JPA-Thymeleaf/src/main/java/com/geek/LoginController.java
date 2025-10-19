package com.geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
