package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.CustomerService;

public class EmployeeController {
	
	private static AccountController accountController = new AccountController();
	private CustomerService customerService = new CustomerService();
	private static Scanner scan = new Scanner(System.in);
	
	public void employeeTasks(String username, String status) {
		
		System.out.println("\nWhat type of task would you like to do? Select one of options and press 'enter':\n\n"
				+ "[1]\t View All Customers Personal Information\n"
				+ "[2]\t View All Accounts Information\n"  
				+ "[3]\t View All Accounts With Balance"
				+ "[4]\t Approve/Deny Accounts"
				+ "[5]\t Add Account"
				+ "[6]\t Deposit, Withdraw, Transfer Funds (Admin only)"
				+ "[7]\t Edit Account (Admin)"
				+ "[8]\t Cancel Account (Admin only)"
				+ "[9]\t Exit Application");
		
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println(option);
		
	
		
		

		
	}

	
}
