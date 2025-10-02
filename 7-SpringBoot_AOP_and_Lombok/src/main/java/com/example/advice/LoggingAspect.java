package com.example.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.example.service.EmployeeServiceImplementation.*(..))")
	public void commonLogs() {
	
	}
	
	@Before("commonLogs()")
	public void logs1() {
		System.out.println("Before Logs...");
	}
	
	@After("commonLogs()")
	public void logs2() {
		System.out.println("After Logs...");
	}
}
