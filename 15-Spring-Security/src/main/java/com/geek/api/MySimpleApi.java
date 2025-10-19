package com.geek.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySimpleApi {
	@GetMapping("/home/admin")
	public String admin() {
		return "Admin Page";
	}
	
	@GetMapping("/home/**")
	public String user() {
		return "User Page";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}
}
