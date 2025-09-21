package com.example.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(exception = Exception.class)
	public String handleException(Exception e) {
		
		return e.getMessage();
	}
}
