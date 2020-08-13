package com.revature;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.comtroller.LogInController;
import com.revature.models.User;
/*
 * Author: Rukiye Eziz
 * Project: #0
 * Due Date: 08/19/2020 Wednesday
 * Description: Leveraging Java 8, create an application 
 * that simulates simple banking transactions
 */
import com.revature.services.UserService;

// ---> User.java
public class BankingApplication {

	private static final Logger log = LogManager.getLogger(BankingApplication.class);
	public static String welcome = "WELCOME TO UNIVERSITY OF MARS CREDIT UNION";
	static Scanner scan = new Scanner(System.in);
	static boolean logIn = false;
	static boolean create = false;
	static String userType;
	static User user = new User();
	static LogInController logInController = new LogInController();
	
	private static UserService userService = new UserService();

	public static void logInOrCreateAccountOption() {
		log.info("=== The banking application has started ===");
		System.out.println("Executing  BankingApplication.java ......");
		System.out.println("**************************************************************");
		System.out.printf("\033[32m%s\033[0m%n%n", welcome);
		
		// Display log in or create account options
		System.out.println("Select one of the options and press 'enter': \n");
		System.out.println("[1]\t Log in to your account");
		System.out.println("[2]\t Create a new user account");
		System.out.println("[3]\t Close the application\n");
		System.out.println("**************************************************************\n");

		// Get user's option for log in or create an account
		execute();
		scan.close();
		log.info("=== The banking application ends ===");
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
		default:
			System.out.println("Invalid option. Please select one of the following options:\n");
			logInOrCreateAccountOption();	
		}// end of switch

	}

	// combine logInAccount() and createAccount() method later
	// /////////////////////////// to do list
	// Display and select one of the user type options
	public static void logInAccount() {

		// Display the user type of log in options
		System.out.println("WELCOME BACK\n");
		System.out.println("Select one of the user type and press 'enter':\n");
		System.out.println("[1]\t Client Account");
		System.out.println("[2]\t Employee Account");
		System.out.println("[3]\t Admin Account");
		System.out.println("[4]\t Close the Application");
		System.out.println("\n**************************************************************\n");
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
		default:
			System.out.println("Invalid option. Please select one of the following options:");
			System.out.println("\n**************************************************************\n");
			logInAccount();
			
		}// end of switch
			
	}

	public static void createAccount() {

		// Display the user type create options
		System.out.println("WELCOME\n");
		System.out.println("Select one of the user type and press 'enter':\n");
		System.out.println("[1]\t Client Account");
		System.out.println("[2]\t Employee Account");
		System.out.println("[3]\t Admin Account");
		System.out.println("[4]\t Close the Application");
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println();
		create = true;

		switch (option) {

		case "1":
			userType = "Client";
			createUser(userType, create);
			break;
		case "2":
			userType = "Employee";
			createUser(userType, create);
			break;
		case "3":
			userType = "Admin";
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
		}// end of switch
			
	}

	// combine loginuser() and createuser() method possible
	// //////////////////////////////////////// to do list
	public static void logInUser(String usertype, boolean login) {

		System.out.println("Enter your user name and password:\n");
		System.out.print("User Name: ");
		String userName = scan.next();
		user.setUserName(userName);

		System.out.print("Password: ");
		String password = scan.next();
		user.setPassword(password);
		userType = usertype;
		user.setUserType(userType);
		logIn = login;
		user.setLogInAccount(logIn);
		System.out.println(user.toString());
		System.out.println("\n**************************************************************\n");
		log.info("User = " + userName + " logged into account." + user.toString());

		// do while later ask for re enter correct user name //////////////////// to do
		// list

//		if (logInController.userLogInValidate(userName, password)) {
//			logIn = login;
//			user.setLogInAccount(logIn);
//
//			System.out.println(user.toString());
//			System.out.println("\n**************************************************************\n");
//			// System.out.println(user.getUserName());
//			log.info("User = " + userName + " logged into account." + user.toString());
//		} else {
//			System.out.println("log in fail");
//		}
		
//		ArrayList<User> userInfo = new ArrayList<User>();
//		userInfo.add(new User(1, "aki", "aki"));
//		userInfo.add(new User(2, "ruki", "ruki"));
//		userInfo.add(new User(3, "jj", "jj"));
		
//		//System.out.println(userInfo);
//		System.out.println("this is coming from userDAO");
//		userService.callInitial();
//		User user = userService.findUserById(2);
		
		
		System.out.println("this is from console entry");
		System.out.println("console user name " + user.getUserName());
		System.out.println("console user pw " + user.getPassword());
//		userService.getUser(user.getUserName(), user.getPassword());
//		
		User user = userService.findUserById(1);	
		System.out.println("whooo user 1 all info " + user);
		System.out.println("whooo user 1 name " + user.getUserName());
		System.out.println("whooo user 1 pw " + user.getPassword());
		
		
		
		
		log.info(user);
//		User user2 = userService.findUserByName(1);
//		System.out.println("whooo user 1 name pw " + user2);
//		System.out.println(user2.getUserName());
//		log.info(user2);


	}

	public static void createUser(String usertype, boolean created) {
		System.out.println("Enter your user name and password:\n");
		System.out.print("User Name: ");
		String userName = scan.next();
		user.setUserName(userName);
		System.out.print("Password: ");
		String password1 = scan.next();
		System.out.println("Re-Enter Password: ");
		String password2 = scan.next();
		
		if(password1.equals(password2)) {
			user.setPassword(password1);
		}
		else {
			System.out.println("The credentials you provided cannot be determined to be authentic.");
			System.out.println("\n**************************************************************\n");
			createUser(usertype, created);
			
		}
		
		userType = usertype;
		user.setUserType(userType);
		create = created;
		user.setCreateAccount(create);
		//f("\033[32m%n%s\033[0m%n%n",
		System.out.println(user.toString());
		System.out.println("\n**************************************************************\n");
		// System.out.println(user.getUserName());
		log.info("User = " + userName + " created an account." + user.toString());

	}

	// check if the user valid or not

}

//
//public void selectUserType() {	
//	log.info("=== The banking application has started ===");
//	System.out.println("Executing  BankingApplication.java ......");
//	System.out.println("**************************************************************");
//	System.out.printf("\033[32m%s%n%n", welcome);
//	//System.out.printf(String.format("%1$50s\n", welcome));
//	
//	// user type option
//	System.out.println("Select one of the user types and press 'enter': ");	
//	System.out.printf("%n%s%n", "[1]\t Client Account");
//	System.out.printf("%s%n", "[2]\t Employee Account");
//	System.out.printf("%s%n", "[3]\t Admin Account");
//	System.out.printf("%s%n%n", "[4]\t Close the Application\033[0m");		
//	System.out.println("**************************************************************");
//	
//	String option = scan.next();
//	switch (option) {
//		case "1": 
//			userType = "Client";
//			clientType(userType); 
//			break;
//		case "2": 
//			userType = "Employee";
//			employeeType(userType);          	
//			break;
//		case "3":    	
//			userType = "Admin";
//			employeeType(userType);
//			break;
//		case "4": 
//			System.out.println("Thank you for choosing business with University of Mars Credit Union."); 
//			System.exit(0);
//			break;
//		default: System.out.println("Invalid option. Please select one of the user types and press 'enter':"); 
//			selectUserType();
//   }//end of switch
//	
//	
//	log.info("=== The banking application ends ===");
//			
//}
//
//public static void clientType(String usertype) {	
//	
//	// Display log in or create account options
//	System.out.printf("%n\033[32m%s%n%n", "Select one of the options and press 'enter': ");	
//    System.out.printf("%s%n", "[1]\t Log into your account");
//    System.out.printf("%s%n", "[2]\t Create a new user account");
//    System.out.printf("%s%n%n", "[3]\t Close the application\033[0m");		
//	System.out.println("**************************************************************");
//		//logInUser(userType, logIn);
//	String option = scan.next();
//	System.out.println();
//
//    switch (option) {
//   
//        case "1":  
//        	logIn = true;
//        	logInClientAccount(usertype, logIn);
//        	break;
//        case "2":            	
//        	create = true;
//        	createClientAccount(usertype, create);
//        	break;
//        case "3": 
//        	System.out.println("Thank you for choosing business with University of Mars Credit Union."); 
//        	System.exit(0);
//        	break;
//        default: System.out.println("Invalid option. Please select one of the following options:"); 
//        	clientType(userType);
//    }//end of switch
//	
//}
//public static void employeeType(String usertype) {	
//	
//	System.out.printf("\033[32m%s %n%n", "Enter your user name and password:");
//	System.out.print("User Name: \033[0m");
//	String userName = scan.next();
//	user.setUserName(userName);
//	System.out.print("\033[32mPassword: \033[0m");
//	String password = scan.next();
//	user.setPassword(password);
//	userType = usertype;
//	user.setUserType(userType);
//	logIn = true;
//	user.setLogInAccount(logIn);
//	
//	System.out.printf("\033[32m%n%s\033[0m%n%n",user.toString());
//	System.out.println("**************************************************************");	
//
//	log.info("User = " + userName + " logged into account." + user.toString());
//
//}
//
//public static void logInClientAccount(String usertype, boolean login) {
//
//	System.out.printf("\033[32m%s %n%n", "Enter your user name and password:");
//	System.out.print("User Name: \033[0m");
//	String userName = scan.next();
//	user.setUserName(userName);
//	System.out.print("\033[32mPassword: \033[0m");
//	String password = scan.next();
//	user.setPassword(password);
//	userType = usertype;
//	user.setUserType(userType);
//	
//	
//	//do while later ask for re enter correct user name //////////////////// to do list
//	
//	if(logInController.userLogInValidate(userName, password)) {
//		logIn = login;
//		user.setLogInAccount(logIn);
//		
//		System.out.printf("\033[32m%n%s\033[0m%n%n",user.toString());
//		System.out.println("**************************************************************");	
//		//System.out.println(user.getUserName());
//		log.info("User = " + userName + " logged into account." + user.toString());
//	}
//	else {
//		System.out.println("log in fail");
//	}	
//	
//}
//
//public static void createClientAccount(String usertype, boolean created) {
//	System.out.printf("\033[32m%s %n%n", "Enter your user name and password:");
//	System.out.print("User Name: \033[0m");
//	String userName = scan.next();
//	// check if there is same user???////////////////////////////////////
//	
//	user.setUserName(userName);
//	System.out.print("\033[32mPassword: \033[0m");
//	String password1 = scan.next();
//	
//	System.out.print("\033[32mRe-enter Password: \033[0m");
//	String password2 = scan.next();
//	
//	// if else for compare password
//	user.setPassword(password1);
//	
//	userType = usertype;
//	user.setUserType(userType);
//	create = created;
//	user.setCreateAccount(create);
//	
//	System.out.printf("\033[32m%n%s\033[0m%n%n",user.toString());
//	System.out.println("**************************************************************");	
//	//System.out.println(user.getUserName());
//	log.info("User = " + userName + " created an account." + user.toString());
//	
//}
//
//
//
////check if the user valid or not
