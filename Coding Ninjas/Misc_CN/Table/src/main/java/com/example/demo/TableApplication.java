package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TableApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TableApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome! Please give the size of table:");
		String size = sc.nextLine();
		
		while(!(size.equals("long")) && !(size.equals("short")))
		{
			System.out.println("Please enter either \"Long\" or \"short\" ");
			
			size = sc.nextLine();
			
		}
		
		
		if(size.equals("long")) {
			System.out.println("Long Table");
		} else {
			System.out.println("Short Table");
		}
	}

}
