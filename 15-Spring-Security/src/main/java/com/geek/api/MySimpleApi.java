package com.geek.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySimpleApi {
	@GetMapping("/hello")
	public String printHello() {
		return "Hello";
	}
}
