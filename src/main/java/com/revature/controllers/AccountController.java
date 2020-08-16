package com.revature.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.services.AccountService;



public class AccountController {
	
	private AccountService accountService = new AccountService();
	private static Scanner scan = new Scanner(System.in);
	
	public void manageAccount(int id) {
	
		System.out.println("Your Account(s): \n");	
		// this is for employee or admin view all accounts
//		List<Account> allAccountList = accountService.findAll();
//		System.out.println("All accounts in DB:");
//		for(Account a : allAccountList) {
//			System.out.println(a);
//		}
		
		// print all account(s) that belong to per customer
		int customerId = id;
		System.out.println("customer id = " + customerId + "\n");
		List<Account> accountList = accountService.findAccountByCustomerId(customerId);
		//System.out.println("customer account(s) in DB:");
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a + " \n");
			}	
		}
		else {
			System.out.println("You do not have any account.\n");
		}
		
		// check if the option is valid or not
		int option; 
		long accountId;
		boolean flag = true;
		
		try {
			System.out.println("Which account number you would like to access? (Enter any number to exit) \n");
			option = scan.nextInt();
			for(int i = 0; i < accountList.size(); i++) {
				accountId = accountList.get(i).getAccountId();

				if(option == accountId) {
					System.out.println("Account Number: " + accountId + "\n");
					System.out.println(accountList.get(i) + "\n");
					transactionOptions(customerId, accountId);		
				}
			}	
			//System.out.println("Thank you. See you next time.");
		}catch(InputMismatchException e) {
			System.out.println("Invalid option. Select one of the option.");
			flag = false;		

		}
		scan.nextLine();
		if(!flag ) {
			manageAccount(customerId);
		}
		System.out.println("---");
	
	}
	 
	private void transactionOptions(int customerId, long accountId) {
		System.out.println("customer id = " + customerId + " account id = " + accountId);
		System.out.println("What type of transaction would like to complete? \n");
		System.out.println("[1]\t Deposit\n"
						+ "[2]\t Withdrawl\n"
						+ "[3]\t Transfer\n"
						+ "[4]\t Close the Application");
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println("option " +option);
		
		switch (option) {

		case "1":
			deposit(customerId, accountId);
			break;
		case "2":
			System.out.println("withdrawl");
			break;
		case "3":
			System.out.println("Transfer");
			break;
		case "4":
			System.out.println("Thank you for choosing business with University of Mars Credit Union. See you next time.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please select one of the following options:");
			System.out.println("\n**************************************************************\n");
			transactionOptions(customerId, accountId);
			break;		
		}// end of switch	
		
	}
	
	private void deposit(int customerId, long accountId) {
		System.out.println("customer id = " + customerId + " account id = " + accountId);
		Account account = accountService.findAccountByIds(customerId, accountId);
		System.out.println("\nYour selected account information: \n" + account + "\n");
		
		
		
		
		
		
	}
	
	
	

} // end of controller
