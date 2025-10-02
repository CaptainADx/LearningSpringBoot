package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
	
	@Autowired  
	@Qualifier("desktop")  //When both classes of same interface are component we can set its priority using "@Qualifier" Annotation
	Computer comp;
	
	public void build() {
		comp.compile();
		System.out.println("Working on Awesome Project");
	}
}
