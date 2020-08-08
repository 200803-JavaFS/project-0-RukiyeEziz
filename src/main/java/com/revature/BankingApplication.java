package com.revature;

import java.util.Scanner;

/*
 * Author: Rukiye Eziz
 * Project: #0
 * Description: Leveraging Java 8, create an application 
 * that simulates simple banking transactions
 */

public class BankingApplication {
	public static String welcome = "WELCOME TO UNIVERSITY OF MARS CREDIT UNION";
	
	public void execute() {
		
		System.out.println("Executing  BankingApplication.java ......");
		System.out.println("**************************************************************");
		System.out.printf("\033[32m %1$50s %n%n", welcome);
		//System.out.printf(String.format("%1$50s\n", welcome));
		System.out.println("Please select one of the following options and press 'Enter': \n");
		
		// Display the options
        System.out.println("[1]\t Log in to your account");
        System.out.println("[2]\t Create a new user account");
        System.out.println("[3]\t Close the application\033[0m");		
		System.out.println("**************************************************************");
		
		// Get user's option
		selectOption();
		
		
		
	}
	public void selectOption() {
		
		Scanner scan = new Scanner(System.in);
		String option = scan.next();
		
        //Display the option
        switch (option) {
            case "1": 
            	System.out.println("Welcome back .... DO somethig here"); 
            	break;
            case "2": 
            	System.out.println("Thank you for creating a new account ... Do something here"); 
            	break;
            case "3": 
            	System.out.println("Thank you. University of Mars Credit Union look forward to meeting you."); 
            	System.exit(0);
            	break;
            default: System.out.println("Invalid option. Please select one of the following options."); execute();
        }//end of switch

        
        scan.close();
	}

	

}
