package com.revature.utilities;

import java.util.List;
import java.util.Scanner;

import com.revature.controllers.CustomerController;

import com.revature.models.User;
import com.revature.services.UserService;



public class DriverHelper {
	
	private static UserService userService = new UserService();
	private static CustomerController customerController = new CustomerController();
	
	private static Scanner scan = new Scanner(System.in);
	private static boolean logIn = false;
	private static boolean create = false;
	private static String userType;		// client, employee, admin
	
    
	// Banking application start
	public void beginApp() {
		
		System.out.println("**************************************************************");
		System.out.printf("\033[32m%s\033[0m%n%n", "WELCOME TO UNIVERSITY OF MARS CREDIT UNION");
		
		// Display log in or create account options
		System.out.println("Select one of the options and press 'enter':\n\n"
							+ "[1]\t Log into existing account\n"
							+ "[2]\t Create a new account\n"
							+ "[3]\t Close the application\n");
		System.out.println("**************************************************************\n");
		String option = scan.next();
		logInOrCreateOption(option);
	}
	
	/*
	 ***************************************************
	 * User Controller
	 *************************************************** 
	 */
	// Get user's option for log in or create an account
	private void logInOrCreateOption(String option) {
		
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
			break;
		default:
			System.out.println("Invalid option. Please select one of the following options:\n");
			beginApp();	
			break;
		}// end of switch

	}
	
	// Display and select one of the user type options after logged 
	private void logInAccount() {
		System.out.println("WELCOME BACK\n"
						+ "Select one of the user type and press 'enter':\n\n"
						+ "[1]\t Client Account\n"
						+ "[2]\t Employee Account\n"
						+ "[3]\t Admin Account\n"
						+ "[4]\t Close the Application");
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println("option "+option);
		System.out.println();
		logIn = true;
		
		switch (option) {

		case "1":
			userType = "client";
			logInUser(userType, logIn);
			break;
		case "2":
			userType = "employee";
			logInUser(userType, logIn);
			break;
		case "3":
			userType = "admin";
			logInUser(userType, logIn);
			break;
		case "4":
			System.out.println("Thank you for choosing business with University of Mars Credit Union.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please select one of the following options:");
			System.out.println("\n**************************************************************\n");
			logInAccount();
			break;		
		}// end of switch		
	}
	
	// Display and select one of the user type options after created
	private void createAccount() {
		System.out.println("WELCOME\n"
				+ "Select one of the user type and press 'enter':\n"
				+ "[1]\t Client Account\n"
				+ "[2]\t Employee Account\n"
				+ "[3]\t Admin Account\n"
				+ "[4]\t Close the Application");
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println();
		create = true;

		switch (option) {

			case "1":
				userType = "client";
				createUser(userType, create);
				break;
			case "2":
				userType = "employee";
				createUser(userType, create);
				break;
			case "3":
				userType = "admin";
				createUser(userType, create);
				break;
			case "4":
				System.out.println("Thank you for choosing business with University of Mars Credit Union.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please select one of the following options.");
				System.out.println("\n**************************************************************\n");
				createAccount();
				break;
		}// end of switch
	}		
	
	// request info from existing user
	private void logInUser(String usertype, boolean login) {
		
		//System.out.println(userType + " log in " + login);
		System.out.println("Enter your user name and password:\n");
		System.out.print("User Name: ");
		String userName = scan.next();		////// TO DO: userName restriction
		System.out.print("Password: ");
		String userPassword = scan.next();	////// TO DO: password restriction	
		System.out.println();
		userType = usertype;		
		logIn = login;
		
				
		// this is just for testing get all users infor
		// this is stiuation that admin view all user and edit to make chages
		List<User> userAllList = userService.findAll();
		System.out.println("All user in DB:");
		for(User u : userAllList) {
			System.out.println(u);
		}
		
		
		/*
		System.out.println("your user name: " + userName);
		System.out.println("your user pw: " + userPassword);
		*/
		
		User userNameDB = userService.findUserByNameByPW(userName, userPassword);
		//System.out.println(userNameDB.getUserName() + " " + userNameDB.getPassword());
		//System.out.println("driver " + userNameDB);
		if(userNameDB != null && userNameDB.getUserName().equals(userName) && userNameDB.getPassword().equals(userPassword)) {		
			System.out.println("Welcome " + userName + ". You have succefully logged in.");	
			System.out.println(userName + " " + userPassword + " " + userType);
			System.out.println("**************************************************************");
			switch(userType) {
				case "client":
					customerController.customerTasks(userName);
					break;
				case "employee":
					System.out.println("build employee tasks here..");
					//employeeController.employeeTasks(userName);
					break;
				case "admin":
					System.out.println("build admin tasks here...");
					//adminController.adminTasks(userName);
					break;
				default:
					System.out.println("Something Went wrong here.");
					break;
			}		
		}
		else {
			System.out.println("\nUser name and password do not match with DB. Try again! \n");
			logInUser(userType, logIn);
		}
		
		System.out.println("\n**************************************************************\n");		

	}


	// request info from new user
	private void createUser(String usertype, boolean created) {

		System.out.println("Welcome New User");
		System.out.println("Enter your user name and password:\n");
		System.out.print("User Name: ");
		String userName = scan.next();		////// TO DO: userName restriction
		
		User user = userService.findUserByName(userName);
		//System.out.println(user.getUserName());
		if(user != null ) {
			System.out.println("Similar user name already exist in the DB. Try other name.");
			System.out.println("Enter your user name and password:\n");
			System.out.print("User Name: ");
			userName = scan.next();
		}
		
		boolean pwChk = true;
		String userPassword1;
		String userPassword2;
		
		do {
			System.out.print("\nPassword: ");
			userPassword1 = scan.next();	////// TO DO: password restriction	
			System.out.println("\nRe-Enter Password: ");
			userPassword2 = scan.next();			
			
			if(!userPassword1.equals(userPassword2)) {
				System.out.println("Passwords do not match. Try again: ");
				pwChk =false;
			}
			else {
				pwChk = true;
			}
			
		}while(!pwChk);
			
		System.out.println();
		userType = usertype;		
		create = created;
		//System.out.println(userName + " " + userPassword1 + " " +  userPassword2 + " " +  userType + " create " +  create);
		
		User newUser = new User(userName, userPassword1, userType);
		boolean newUserCreated = userService.insertUser(newUser);
		if(!newUserCreated) {
			System.out.println("Something went wrong. Please try again.");
			beginApp();
		} 
		//System.out.println(newUserCreated);
		System.out.println("\nA new user was added to the database");
		System.out.println("\nWould you like to log in to your account? (yes/no) \n");
		Scanner scan1 = new Scanner(System.in);
		String answer = scan1.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			beginApp();
		}
		else {
			System.out.println("Thank you for creating an account with us. See you next time!");
		}
	}
	
	
	
	
		
}
	
