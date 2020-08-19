package com.revature.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.services.AccountService;

/**
 * @author Rukiye
 *
 */
public class AccountController {
	private AccountService accountService = new AccountService();
	private static Scanner scan = new Scanner(System.in);
	
	public void manageAccount(int id) {	
		
		// print all account(s) that belong to per customer
		System.out.println(id);
		int customerId = id;
		System.out.println("Your Account(s) Information:");
		List<Account> accountList = accountService.findAccountByCustomerId(customerId);
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a );			
			}				
		}
		else {
			System.out.println("You do not have any account. Please speak with one of representitives.\n");
		}		
		// transaction options	deposit, withdraw, transfer	
		System.out.println("\nWhat type of transaction would like to complete? \n");
		System.out.println("[1]\t Deposit\n"
						+ "[2]\t Withdrawl\n"
						+ "[3]\t Transfer\n"
						+ "[4]\t Close the Application");
		System.out.println("\n*************************************************************************\n");
		String option = scan.next();

		switch (option) {

		case "1":
			System.out.println("Deposit transaction started ...");
			deposit(customerId, accountList);
			
			break;
		case "2":
			System.out.println("withdraw transaction started ...\n");
			withdraw(customerId, accountList);
			break;
		case "3":
			System.out.println("Transfer funds started ...\n");
			transfer(customerId, accountList);
			break;
		case "4":
			System.out.println("Thank you for choosing business with University of Mars Credit Union. See you next time.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please select one of the following options:");
			System.out.println("\n*************************************************************************\n");
			manageAccount(customerId);
			break;		
		}// end of switch	
	}
	/*
	 * 
	 * Transfer Funds
	 * 
	 */
	private void transfer(int customerid, List<Account> accountlist) {
		// if a customer has at least 2 accounts, then transfer continue process
		if(accountlist.size() >= 2) {
			for(Account a : accountlist) {
				System.out.println("\n" + a );
			}	
			System.out.println("\nYou have total " + accountlist.size() + " account(s).\n");
		}
		else {
			System.out.println("You have to have at least 2 accounts in order to transfer funds.\n");
			System.out.println("Would you like to continue other transaction process again: (yes/no)\n");
			String answer = scan.next();
			if(answer.equalsIgnoreCase("yes")){
				System.out.println();
				// go back to transactions option again
				manageAccount(customerid);
				
			}else {
				System.out.println("Thank you. See you next time.");
				System.exit(0);
			}
		}
		
		// get the accounts set the id's for both accounts
		long option1, option2;
		long accountid1 = 0, accountid2 = 0;
		boolean flag = true;
		double balance1 = 0, balance2 = 0, newBalance1 = 0, newBalance2 = 0;
		double amount;
		
		try {
			System.out.println("\nWhich account number you would like to transfer from? (Enter any number to exit) \n");
			option1 = scan.nextLong();
			System.out.println("\nWhich account number you would like to transfer to? (Enter any number to exit) \n");
			option2 = scan.nextLong();
							
			// if both inputs for options are same, give warning
			if(option1 == option2) {
				System.out.println("\nYou can not transfer funds from and to the same account. Please try again.\n");
				System.out.println("\n*************************************************************************\n");
				transfer(customerid, accountlist);
			}
			else {
				for(int i = 0; i < accountlist.size(); i++){
						
						if(option1 == accountlist.get(i).getAccountId()) {
							accountid1 = accountlist.get(i).getAccountId();
							balance1 = accountlist.get(i).getAccountBalance();
							System.out.println("accountid = " + accountid1 + " account balance = " + balance1);
						}
						else if(option2 == accountlist.get(i).getAccountId()) {
							accountid2 = accountlist.get(i).getAccountId();
							balance2 = accountlist.get(i).getAccountBalance();
							System.out.println("accountid = " + accountid2 + " account balance = " + balance2);
						}		
				}// end of for loop	
				
				System.out.println();
				// calculate the transfer funds
				do {
					System.out.printf("Enter the amount for transfer from first account (current balance = $%.02f): $", balance1 );
					amount = scan.nextDouble();
					
					if(amount <= 0 || balance1 <= 0 || balance2 <= 0 || amount > balance1) {
						System.out.println("NOTE: Transfer amount or(and) balances must be valid. Try again.\n");
						//flag = false;
						
						transfer(customerid, accountlist);
					}
					else {
						newBalance1 = balance1 - amount;
						// update account with balance from withdrawn
						boolean withdrawedAccount = accountService.withdrawAccount(customerid, accountid1, newBalance1);
						newBalance2 = balance2 + amount;
						boolean depositedAccount = accountService.depositAccount(customerid, accountid2, newBalance2);
						
						if(withdrawedAccount == true && depositedAccount == true)
						{
							System.out.println("\nTransfer funds successed. ");
							System.out.println("Accounts information: \n");
							System.out.println(accountService.findAccountByIds(customerid, accountid1));
							System.out.println(accountService.findAccountByIds(customerid, accountid2));
							
							System.out.println("\nWould you like to continue transaction process again: (yes/no)\n");
							String answer = scan.next();
							if(answer.equalsIgnoreCase("yes")){
								System.out.println();
								// go back to transactions option again
								manageAccount(customerid);
								
							}else {
								System.out.println("Thank you. See you next time.");
								System.exit(0);
							}						
						}
					}
							
				}while(amount <= 0 || balance1 <= 0 || balance2 <= 0 || amount > balance1);
				
				scan.nextLine();		
				
			}// end of else
					
		}catch(InputMismatchException e) {
			System.out.println("\nInvalid option. Try again.\n");
			flag = false;		
		}		
		scan.nextLine();
		if(!flag ) {
			manageAccount(customerid);
		}	
	}
	/*
	 * 
	 * Deposit
	 * 
	 */
	private void deposit(int customerid, List<Account> accountList) {
		System.out.println(accountList.size());
		 // if there is no account(s) deposit process end
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a );
			}	
			System.out.println("\n\nYou have total " + accountList.size() + " account(s).\n");
		}
		else {
			System.out.println("You do not have any account. Please speak with one of representitives.\n");
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
				
				// get the balance of the account
				if(option == accountId) {
					//System.out.println("Account Number: " + accountId + "\n");
					System.out.println(accountList.get(i) + "\n");	
					balance = accountList.get(i).getAccountBalance();
					//deposit(customerid, accountId, balance);
					
					double amount = 0; 		
					// get the amount to deposit
					do {
						System.out.printf("Enter the amount to deposit (current balance =  $%.02f): $", balance );
						amount = scan.nextDouble();
						if(amount < 0) {
							System.out.println("NOTE: Deposit amount must be greater than zero.\n");
							flag = false;
						}				
					}while(amount < 0);
					
					scan.nextLine();
					// get new balance after deposit
					balance += amount;				
					// update the account with balance	
					boolean depositedAccount = accountService.depositAccount(customerid, accountId, balance);
					if(depositedAccount == true) {
						System.out.printf("\nYour new balance: $%.02f \n", balance );
						Account account = accountService.findAccountByIds(customerid, accountId);
						System.out.println("\n" + account + "\n");
						System.out.println("Deposit transaction ended.");
						System.out.println("\n*************************************************************************\n");
					}
					
					System.out.println("Would you like to continue transaction process again: (yes/no)\n");
					String answer = scan.next();
					if(answer.equalsIgnoreCase("yes")){
						System.out.println();
						// go back to transactions option again
						manageAccount(customerid);
						
					}else {
						System.out.println("Thank you. See you next time.");
						System.exit(0);
					}
					
				}// end of if
				else {
					flag = false;
				}
			}// end of for loop			
		}catch(InputMismatchException e) {
			
			flag = false;		
		}
		
		scan.nextLine();
		if(!flag ) {
			System.out.println("\nInvalid option. Try again.\n");
			manageAccount(customerid);
		}

	}//end of deposit
	/*
	 * 
	 * Withdraw
	 * 
	 */
	private void withdraw(int customerid, List<Account> accountList) {
		
		// if there is no account(s) deposit process end
		if(accountList.size() != 0) {
			for(Account a : accountList) {
				System.out.println("\n" + a );
			}	
			System.out.println("\n\nYou have total " + accountList.size() + " account(s).\n");
		}
		else {
			System.out.println("You do not have any account. Please speak with one of representitives.\n");
		}

		// get the account deposit to
		int option; 
		long accountid;
		boolean flag = true;
		double balance;
		
		try {
			System.out.println("\nWhich account number you would like to access? (Enter any number to exit) \n");
			option = scan.nextInt();
			for(int i = 0; i < accountList.size(); i++) {
				accountid = accountList.get(i).getAccountId();
				
				if(option == accountid) {
					System.out.println(accountList.get(i) + "\n");	
					balance = accountList.get(i).getAccountBalance();
					//withdraw(customerid, accountId, balance);
					
					double amount = 0; 		
					// get the amount to deposit
					do {
						System.out.printf("Enter the amount to withdraw (current balance =  $%.02f): $", balance);
						amount = scan.nextDouble();
						
						if(amount < 0 || amount >= balance) {
							System.out.println("NOTE: Withdraw amount must be greater than zero or greater than balance.\n");
							flag = false;
						}				
					}while(amount < 0 || amount >= balance);
					
					scan.nextLine();
					// get new balance
					balance -= amount;
					// update account with balance
					boolean withdrawedAccount = accountService.withdrawAccount(customerid, accountid, balance);
					
					if(withdrawedAccount == true)
					{
						System.out.printf("\nYour new balance: $%.02f \n", balance );
						Account account = accountService.findAccountByIds(customerid, accountid);
						System.out.println("\n" + account + "\n");
						System.out.println("Withdraw transaction ended.");
						System.out.println("\n*************************************************************************\n");
					}
				
					System.out.println("Would you like to continue transaction process again: (yes/no)\n");
					String answer = scan.next();
					if(answer.equalsIgnoreCase("yes")){
						System.out.println();
						// go back to transactions option again
						manageAccount(customerid);
						
					}else {
						System.out.println("Thank you. See you next time.");
						System.exit(0);
					}	
				}// end of if
				else {
					flag = false;
				}
				
			}// end of for loop	
			
		}catch(InputMismatchException e) {
			System.out.println("\nInvalid option. Select one of the option.\n");
			flag = false;		
		}
		
		scan.nextLine();
		if(!flag ) {
			manageAccount(customerid);
		}
	}// end of withdraw



} // end of controller
