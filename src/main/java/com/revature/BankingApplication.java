package com.revature;

import java.util.Scanner;

import com.revature.models.User;
/*
 * Author: Rukiye Eziz
 * Project: #0
 * Due Date: 08/19/2020 Wednesday
 * Description: Leveraging Java 8, create an application 
 * that simulates simple banking transactions
 */

public class BankingApplication {
	
	public static String welcome = "WELCOME TO UNIVERSITY OF MARS CREDIT UNION";
	static Scanner scan = new Scanner(System.in);
	static boolean logIn = false;
	static boolean create = false;
	static String userType = "";
	static User user = new User(); 
	
	public void logInOrCreateAccountOption() {		
		System.out.println("Executing  BankingApplication.java ......");
		System.out.println("**************************************************************");
		System.out.printf("\033[32m%s%n%n", welcome);
		//System.out.printf(String.format("%1$50s\n", welcome));
		
		// Display log in or create account options
		System.out.println("Select one of the options and press 'enter': ");	
        System.out.printf("%s%n", "[1]\t Log in to your account");
        System.out.printf("%s%n", "[2]\t Create a new user account");
        System.out.printf("%s%n%n", "[3]\t Close the application\033[0m");		
		System.out.println("**************************************************************");
		
		 
		
		// Get user's option for log in or create an account
		execute();
		scan.close();	
	}
	// Get user's option for log in or create an account
	public static void execute() {	
		String option = scan.next();
		System.out.println();
	
        switch (option) {
       
            case "1":    	
            	logInAccount();
            	break;
            case "2":            	
            	createAccount();
            	break;
            case "3": 
            	System.out.println("Thank you for choosing business with University of Mars Credit Union."); 
            	System.exit(0);
            	break;
            default: System.out.println("Invalid option. Please select one of the following options:"); 
            	execute();
        }//end of switch
        
	}	
	// Display and select one of the user type options
	public static void logInAccount() {
		
		// Display the user type of log in options
		System.out.printf("\033[32m%s %n%n", "WELCOME BACK");
		System.out.println("Select one of the user type and press 'enter':");	
        System.out.printf("%n%s%n", "[1]\t Client Account");
        System.out.printf("%s%n", "[2]\t Employee Account");
        System.out.printf("%s%n", "[3]\t Admin Account");
        System.out.printf("%s%n%n", "[4]\t Close the Application\033[0m");		
		System.out.println("**************************************************************");		
		String option = scan.next();
		System.out.println();	
		logIn = true;
		
		
        switch (option) {
       
            case "1":   
            	userType = "Client";
            	logInUser(userType, logIn);
            	break;
            case "2": 
            	userType = "Employee";
            	logInUser(userType, logIn);          	
            	break;
            case "3":    	
            	userType = "Admin";
            	logInUser(userType, logIn);
            	break;
            case "4": 
            	System.out.println("Thank you for choosing business with University of Mars Credit Union."); 
            	System.exit(0);
            	break;
            default: System.out.println("Invalid option. Please select one of the following options:"); 
            	execute();
        }//end of switch
        

		
	}
	
	public static void createAccount() {
		
		// Display the user type create options
		System.out.printf("\033[32m%s %n%n", "WELCOME");
		System.out.println("Select one of the user type and press 'enter':");		
        System.out.printf("%n%s%n", "[1]\t Client Account");
        System.out.printf("%s%n", "[2]\t Employee Account");
        System.out.printf("%s%n", "[3]\t Admin Account");
        System.out.printf("%s%n%n", "[4]\t Close the Application\033[0m");		
		System.out.println("**************************************************************");		
		String option = scan.next();
		System.out.println();
		
        switch (option) {
       
            case "1":    	
            	//createAsClient();
            	break;
            case "2":            	
            	//createAsEmployee();
            	break;
            case "3":    	
            	//createAsAdmin();
            	break;
            case "4": 
            	System.out.println("Thank you for choosing business with University of Mars Credit Union."); 
            	System.exit(0);
            	break;
            default: System.out.println("Invalid option. Please select one of the following options."); 
            execute();
        }//end of switch
        
	}
	
	public static void logInUser(String usertype, boolean login) {
		
		System.out.printf("\033[32m%s %n%n", "Enter your user name and password:");
		System.out.print("User Name: \033[0m");
		String userName = scan.next();
		user.setUserName(userName);
		System.out.print("\033[32mPassword: \033[0m");
		String password = scan.next();
		user.setPassword(password);
		userType = usertype;
		user.setUserType(userType);
		logIn = login;
		user.setLogInAccount(logIn);
		
		System.out.printf("\033[32m%n%s\033[0m%n%n",user.toString());
		System.out.println("**************************************************************");	
		//System.out.println(user.getUserName());
		
	}
	
	public static void createUser() {
		
	}

	
	
	

}
