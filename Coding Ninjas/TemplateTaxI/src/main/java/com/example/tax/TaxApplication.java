package com.example.tax;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");
		System.out.println("Please select which tax you want to pay: ");
		System.out.println("1. Income");
		System.out.println("2. Property");
		System.out.println("3. Exit");
		
		String taxChoice = "";

        int choice = sc.nextInt();
        
        
        Tax tax = null;
        
        switch(choice) {
	        case 1 -> {
	        	taxChoice = "incomeTax";
	        	break;
	        }
	        
	        case 2 -> {
	        	taxChoice = "propertyTax";
	        	break;
	        }
	        
	        case 3 -> {
	        	System.out.println("Exiting...");
	        	sc.close();
	        	context.close();
	        	return;
	        }
	        
	        default -> {
	        	System.out.println("Invalid Choice");
	        	sc.close();
	        	context.close();
	        	return;
	        }
        }
        
        tax = (Tax) context.getBean(taxChoice);
        
        if(tax.isTaxPayed()) {
        	
        	System.out.println("You have already paid " + tax.getTaxType().substring(0,1).toUpperCase() + tax.getTaxType().substring(1) + " tax");
        	return;
        }
        
        
        System.out.println("Please Enter your Income/Property value: ");
        double taxableAmount = sc.nextDouble();
    
        
        
        tax.setTaxableAmount(taxableAmount);
        tax.calculateTaxAmount();
        
        System.out.println("You have selected " + tax.getTaxType() + " tax and your tax amount is: " + tax.getTaxAmount());
        
        
        System.out.println("Do you want to pay the tax:");
        System.out.println("1. Yes \n2. Exit");
        
        int payChoice = sc.nextInt();

		if (payChoice == 1) {
			tax.payTax();
		}
        

    	context.close();
    	sc.close();
	       
	}

}
