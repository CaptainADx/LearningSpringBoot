package com.example.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.ApiError;
import com.example.exception.CustomException;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(exception = {CustomException.class})
	public ResponseEntity<ApiError> handleException(Exception e) {
		
		ApiError error = new ApiError(e.getMessage(), "404");
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e){
		
		Map<String, String> errors = new HashMap<>();
		
		e.getFieldErrors().forEach(f -> errors.put(f.getField(), f.getDefaultMessage()));
		 
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		
	}
}

