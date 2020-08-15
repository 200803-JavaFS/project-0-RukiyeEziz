package com.revature.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.models.Customer;
import com.revature.services.CustomerService;



public class CustomerController {
	
	private static String userType = "client";
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	private static Scanner scan = new Scanner(System.in);
	
	private CustomerDAO cdao = new CustomerDAO();
	private CustomerService cs = new CustomerService();
	
	public void customerTasks(String userName) {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Login time: " + timeFormatter.format(currentTime));
		System.out.println("Select one of options and press 'enter':\n\n"
				+ "[1]\t Manage existing account\n"
				+ "[2]\t Apply for a new account\n"
				+ "[3]\t Edit your personal information\n"
				+ "[4]\t Close the Application");
		
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println();
		
		switch (option) {

			case "1":
				manageAccount(userName);
				break;
			case "2":
				createNewAccount(userName);
				
				break;
			case "3":
				editPersonalInfo();
				break;
			case "4":
				System.out.println("Thank you for choosing business with University of Mars Credit Union.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please select one of the following options:");
				System.out.println("\n**************************************************************\n");
				customerTasks(userName);
				break;		
		}// end of switch
		
	}
	private void manageAccount(String userName) {
		System.out.println("manage account");
		System.out.println("Your Account(s): ");
		
		
	}
	private void createNewAccount(String Name) {
		System.out.println("Your Personal Information: ");
		List<Customer> list = cs.findAll();
		
		for(Customer c : list) {
			System.out.println(c);
		}
		
		
	}
	private void editPersonalInfo() {
		// TODO Auto-generated method stub
		
	}
	



} // end of controller
