package com.revature.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.services.AccountService;
import com.revature.services.CustomerService;



public class AccountController {
	
	private AccountService accountService = new AccountService();
	private static Scanner scan = new Scanner(System.in);
	private CustomerService customerService = new CustomerService();
	
	public void manageAccount(int id) {
	
			
		// this is for employee or admin view all accounts
//		List<Account> allAccountList = accountService.findAll();
//		System.out.println("All accounts in DB:");
//		for(Account a : allAccountList) {
//			System.out.println(a);
//		}
		
		// print all account(s) that belong to per customer
		
		//System.out.println("customer id = " + customerId + "\n");
		
		int customerId = id;
		System.out.println("Your Account(s): \n");
		List<Account> accountList = accountService.findAccountByCustomerId(customerId);
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a );
				
			}	
			
		}
		else {
			System.out.println("You do not have any account.\n");
		}
		
		// transaction options
		
		System.out.println("\nWhat type of transaction would like to complete? \n");
		System.out.println("[1]\t Deposit\n"
						+ "[2]\t Withdrawl\n"
						+ "[3]\t Transfer\n"
						+ "[4]\t Close the Application");
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		//System.out.println("option " + option);
		
		//System.out.println("customer id = " + customerId + " account id = " + accountId);
		switch (option) {

		case "1":
			System.out.println("Deposit transaction start.\n");
			depositSelection(customerId, accountList);
			// show transaction history()
			break;
		case "2":
			System.out.println("withdraw transaction start.\n");
			withdrawSelection(customerId, accountList);
			break;
		case "3":
			System.out.println("Transfer");
			// show transaction history();
			break;
		case "4":
			System.out.println("Thank you for choosing business with University of Mars Credit Union. See you next time.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please select one of the following options:");
			System.out.println("\n**************************************************************\n");
			manageAccount(customerId);
			break;		
		}// end of switch	
		
		
		
		
		/*
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
		
		*/
	
	}
	 
	// deposit transaction
	private void depositSelection(int customerid, List<Account> accountList) {
		
		//System.out.println("customer id = " + customerid );
		//System.out.println("Your Account(s): \n" + accountList);
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a );
			}	
			System.out.println("You have total " + accountList.size() + " account(s).\n");
		}
		else {
			System.out.println("You do not have any account.\n");
		}
		
		
		// get the account deposit to
		int option; 
		long accountId;
		boolean flag = true;
		double balance;
		
		try {
			System.out.println("\nWhich account number you would like to access? (Enter any number to exit) \n");
			option = scan.nextInt();
			for(int i = 0; i < accountList.size(); i++) {
				accountId = accountList.get(i).getAccountId();

				if(option == accountId) {
					//System.out.println("Account Number: " + accountId + "\n");
					System.out.println(accountList.get(i) + "\n");	
					balance = accountList.get(i).getAccountBalance();
					deposit(customerid, accountId, balance);
				}
			}	
			
		}catch(InputMismatchException e) {
			System.out.println("\nInvalid option. Select one of the option.\n");
			flag = false;		
		}
		
		scan.nextLine();
		if(!flag ) {
			manageAccount(customerid);
		}

	}
	
	
	private void deposit(int customerid, long accountid, double balance) {

		double amount = 0; 		
		System.out.println("customer id = " + customerid + " account id = " + accountid + " balance = " + balance);
		// get the amount to deposit
		do {
			System.out.printf("Enter the amount to deposit (current balance =  $%.02f): $", balance);
			amount = scan.nextDouble();
			if(amount < 0) {
				System.out.println("Amount must be greater than zero.");
				}				
		}while(amount < 0);
		
		scan.nextLine();
		// get new balance
		balance += amount;
		// update account with balance
		System.out.println("New balance = \n" + balance);		
		boolean depositedAccount = accountService.depositAccount(customerid, accountid, balance);
		System.out.println("Your new balance:\n" + depositedAccount);
		Account account = accountService.findAccountByIds(customerid, accountid);
		System.out.println("\n" + account);
		manageAccount(customerid);
	
	}
	// withdraw transaction
	private void withdrawSelection(int customerid, List<Account> accountList) {
		
		//System.out.println("customer id = " + customerid );
		//System.out.println("Your Account(s): \n" + accountList);
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a );
			}	
			System.out.println("You have total " + accountList.size() + " account(s).\n");
		}
		else {
			System.out.println("You do not have any account.\n");
		}
		
		
		// get the account deposit to
		int option; 
		long accountId;
		boolean flag = true;
		double balance;
		
		try {
			System.out.println("\nWhich account number you would like to access? (Enter any number to exit) \n");
			option = scan.nextInt();
			for(int i = 0; i < accountList.size(); i++) {
				accountId = accountList.get(i).getAccountId();

				if(option == accountId) {
					//System.out.println("Account Number: " + accountId + "\n");
					System.out.println(accountList.get(i) + "\n");	
					balance = accountList.get(i).getAccountBalance();
					withdraw(customerid, accountId, balance);
				}
			}	
			
		}catch(InputMismatchException e) {
			System.out.println("\nInvalid option. Select one of the option.\n");
			flag = false;		
		}
		
		scan.nextLine();
		if(!flag ) {
			manageAccount(customerid);
		}

	}
	private void withdraw(int customerid, long accountid, double balance) {

		double amount = 0; 		
		System.out.println("customer id = " + customerid + " account id = " + accountid + " balance = " + balance);
		// get the amount to deposit
		do {
			System.out.printf("Enter the amount to withdraw (current balance =  $%.02f): $", balance);
			amount = scan.nextDouble();
			if(amount < 0 || amount >= balance) {
				System.out.println("Amount must be greater than zero.");
				}				
		}while(amount < 0 || amount >= balance);
		
		scan.nextLine();
		// get new balance
		balance -= amount;
		// update account with balance
		System.out.println("New balance = \n" + balance);		
		boolean withdrawededAccount = accountService.withdrawAccount(customerid, accountid, balance);
		System.out.println("Your new balance:\n" + withdrawededAccount );
		Account account = accountService.findAccountByIds(customerid, accountid);
		System.out.println("\n" + account);
		manageAccount(customerid);
	
	}
	
	/*

	
	private void transferAccount(CustomerService customerService, Scanner scan) {
		int fromAccount;
		int toAccount;
		double amount; 
		double accountBalance;
		// get the aacount to transfer from
		do {
			System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer from: ", customerService.numberOfAccounts());
			fromAccount = scan.nextInt() - 1;
			if(fromAccount < 0 || fromAccount >= customerService.numberOfAccounts() ) {
				System.out.println("Invalid account. Please try again.");
			}
		}while(fromAccount < 0 || fromAccount >= customerService.numberOfAccounts());
		
		accountBalance = customerService.getAccountBalance(fromAccount);
		
		// get the account to transfer to
		do {
			System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer to: ", customerService.numberOfAccounts());
			toAccount = scan.nextInt() - 1;
			if(toAccount < 0 || toAccount >= customerService.numberOfAccounts() ) {
				System.out.println("Invalid account. Please try again.");
			}
		}while(toAccount < 0 || toAccount >= customerService.numberOfAccounts());
		
		// get the amount to transfer
		do {
			System.out.printf("Enter the amount to transfer (max $%.02f): $", accountBalance);
			if(amount < 0) {
				System.out.println("Amount must be greater than zero.");
			}else if(amount > accountBalance) {
				System.out.printf("Amount must not be greater than \n" + "balance of $%.02f.\n", accountBalance);
				
			}
		}while(amount < 0 || amount > accountBalance);
		
		// make the transfer
		customerService.addAccountTransaction(fromAccount, -1 * amount, 
				String.format("Transfer to account %s", ((Object) customerService).getAccountUUID(toAccount)));
		customerService.addAccountTransaction(toAccount, amount, 
				String.format("Transfer to account %s", customerService.getAccountUUID(fromAccount)));
		
	}
	
	// print the transaction summary for an account
	private void showTransactionStatus( CustomerService customerService, Scanner scan) {
		 int theAccount;
		 
		 // get account whose transaction to look
		 do {
			 System.out.printf("Enter the number (1-%d) of the account transaction\n" + 
					 "you would like to see: ", customerService.numberOfAccounts()); // build at customer service the number of accounts per customer has
			 theAccount = scan.nextInt() - 1;
			 
			 if(theAccount < 0 || theAccount >= customerService.numberOfAccounts()) {
				 System.out.println("Invalid account. Please try again.");
			 }
		 }while(theAccount < 0 || theAccount >= customerService.numberOfAccounts()) ;
		 
		 customerService.printAccountSummary(theAccount);
	 }
	*/
	

} // end of controller
