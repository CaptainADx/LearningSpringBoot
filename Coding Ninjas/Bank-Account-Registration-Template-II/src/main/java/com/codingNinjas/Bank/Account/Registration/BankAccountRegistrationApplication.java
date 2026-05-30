package com.codingNinjas.Bank.Account.Registration;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		

        Scanner sc = new Scanner(System.in);

        // Load Spring Context
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext("com.codingNinjas.Bank.Account.Registration");

        ApplicationContext context = SpringApplication.run(BankAccountRegistrationApplication.class, args);
        
        // Get User Bean
        User user = context.getBean(myUser.class);

        System.out.println("Welcome to Account Registration Application!");

        // User Name
        System.out.println("Please enter Your name?");
        String name = sc.nextLine();

        user.setUserDetails(name);

        int choice;

        do {

            System.out.println("Do you want to add account");
            System.out.println("1. Yes");
            System.out.println("2. No");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("Please select the account type");
                System.out.println("1. Current");
                System.out.println("2. Savings");

                int accountChoice = sc.nextInt();

                System.out.println("Enter the opening balance");

                double balance = sc.nextDouble();

                Account account;

                if (accountChoice == 1) {

                    account = context.getBean(currentAccount.class);

                } else {

                    account = context.getBean(savingsAccount.class);

                }

                account.addBalance(balance);

                user.addAccount(account);

                System.out.println("Do you want to add more accounts");
                System.out.println("1. Yes");
                System.out.println("2. No");

                choice = sc.nextInt();
            }

        } while (choice == 1);

        // Display Accounts
        System.out.println("\nHi " + user.getName() +
                ", here is the list of your accounts:");

        for (Account acc : user.getAllAccounts()) {

            System.out.println(
                    acc.getAccountType()
                    + " : opening balance - "
                    + acc.getBalance()
                    + " Reference Id "
                    + acc
            );
        }

        sc.close();
	}

}
