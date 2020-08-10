package com.revature;

import java.util.Scanner;

/*
 * Author: Rukiye Eziz
 * Project: #0
 * Due Date: 08/19/2020 Wednesday
 * Description: Leveraging Java 8, create an application 
 * that simulates simple banking transactions
 */

public class BankingApplication {
	public static String welcome = "WELCOME TO UNIVERSITY OF MARS CREDIT UNION";
	
	public static void logInOrCreateAccountOption() {
		
		System.out.println("Executing  BankingApplication.java ......");
		System.out.println("**************************************************************");
		System.out.printf("\033[32m %1$50s %n%n", welcome);
		//System.out.printf(String.format("%1$50s\n", welcome));
		System.out.println("Please select one of the following options and press 'Enter': \n");
		
		// Display the options
        System.out.printf("%s%n", "[1]\t Log in to your account");
        System.out.printf("%s%n", "[2]\t Create a new user account");
        System.out.printf("%s%n%n", "[3]\t Close the application\033[0m");		
		System.out.println("**************************************************************");
		
		// Get user's option
		execute();
		
	}
	
	public static void execute() {
		
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
            	System.out.println("Thank you for choosing business with University of Mars Credit Union."); 
            	System.exit(0);
            	break;
            default: System.out.println("Invalid option. Please select one of the following options."); execute();
        }//end of switch

        
        scan.close();
	}

}
