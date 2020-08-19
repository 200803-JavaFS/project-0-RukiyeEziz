package com.revature.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.AccountService;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;


public class EmployeeController {
	private static final Logger log = LogManager.getLogger(EmployeeController.class);
	
	private static AccountController accountController = new AccountController();
	private EmployeeService employeeService = new EmployeeService();
	private AccountService accountService = new AccountService();
	private CustomerService customerService = new CustomerService();
	private Customer customer = new Customer();
	
	private static Scanner scan = new Scanner(System.in);
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	
	public void employeeTasks(String username, String status) {
		log.info("Employee tasks start.");
		String userName = username;
		String employeeStatus = status;	
		
		System.out.println("\nWhat type of task would you like to do? Select one of options and press 'enter':\n\n"
				+ "[1]\t View All Customers Personal Information\n"
				+ "[2]\t View All Employees Information\n" 
				+ "[3]\t View All Accounts Information\n"  
				+ "[4]\t View All Accounts' Balance\n"
				+ "[5]\t Approve/Deny Accounts\n"
				+ "[6]\t Add Account\n"
				+ "[7]\t Deposit, Withdraw, Transfer Funds (Admin only)\n"
				+ "[8]\t Edit Account (Admin only)\n"
				+ "[9]\t Cancel Account (Admin only)\n"
				+ "[0]\t Exit Application");
		
		System.out.println("\n***********************************************************************************\n");
		String option = scan.next();
		System.out.println(option);
		
		switch (option) {

			case "1":
				if(status.equals("employee") || status.equals("admin")) {
					viewAllCustomersInfo(username, status);
				}else {
					System.out.println("Unknown status accessing the DB.");
					log.error("Unknown status accessing customers data.");
				}			
				break;
			case "2":
				if(status.equals("employee") || status.equals("admin")) {
					viewAllEmployeesInfo(username, status);
				}else {
					System.out.println("Unknown status accessing the DB.");
					log.error("Unknown status accessing employees data.");
				}					
				break;
			case "3":
				if(status.equals("employee") || status.equals("admin")) {
					viewAllAccounts(username, status); 
//					System.out.println("");
//					System.out.println("Would you like to continue other banking process again: (yes/no)\n");
//					String answer = scan.next();
//					if(answer.equalsIgnoreCase("yes")){
//						System.out.println();
//						
//						beginApp();
//
//						viewAccountByAccountCustomerIds(); 
//						viewAccountsByCustomerId();
//						
//					}else {
//						System.out.println("Thank you. See you next time.");
//						System.exit(0);
				}else {
					System.out.println("Unknown status accessing the DB.");
					log.error("Unknown status accessing accounts data.");
				}	
				
				break;
			case "4":
				if(status.equals("employee") || status.equals("admin")) {
					viewAllBalances(username, status);
				}else {
					System.out.println("Unknown status accessing the DB.");
					log.error("Unknown status accessing accounts balance data.");
				}	
				
				break;
			case "5":
				//approveDenyAccount();
				break;
			case "6":
				if(status.equals("employee") || status.equals("admin")) {
					addAccount(username, status);
					
					
				}else {
					System.out.println("Unknown status accessing the DB.");
					log.error("Unknown status accessing accounts data.");
				}	
				
				
				break;
			case "7":
				System.out.println("Under construction ...");
				//transactions(); 
				break;
			case "8":
				System.out.println("Under construction ...");
				//editAccount();
				break;
			case "9":
				System.out.println("Under construction ...");
				//cancelAccount();
				break;
			case "0":
				System.out.println("Thank you for your hardwork at University of Mars Credit Union.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please select one of the following options:");
				System.out.println("\n**************************************************************\n");
				employeeTasks(username, status);
			break;		
		}// end of switch
		
		

		
	}
	private void setStatusProcess(String username, String status) {
		System.out.println("We will inform you soon that your account process.");
		
		
	}
	/*
	 * to create a new account for a customer
	 */
	private Account addAccount(String username, String status) {
		System.out.println("Thank you for opening an account with our bank.\n");
		System.out.println("What type of account would you like to open (checking or saving account)?");
		System.out.println();
		String type = scan.next();
		System.out.println("What amount would you like add to your account?");
		double balance = scan.nextDouble();
		System.out.println("What would you like to call your new account?");
		String name = scan.next();
		System.out.println("Customer Id: ");
		int customerId = scan.nextInt();
		System.out.println("Account Id: ");
		long accountId = scan.nextLong();
		System.out.println();
		System.out.println("Thank you for your patience. Your account is being sent to get approved.");
		System.out.println();
		String accountStatus = "pending";
		String memo = "need to be evaluated";
		LocalDateTime currentTime = LocalDateTime.now();
		
		Account newAccount = new Account(accountId, name, type, balance, accountStatus, customerId, memo, timeFormatter.format(currentTime));
		//boolean pending = accountService.setAccountStatus(newAccount);
		boolean created = accountService.AddAccount(newAccount);
		
		if(created) {
			System.out.println("\n---- THANK YOU -----.");
		}else {
			System.out.println("There is a problem.");
		}
		
		
		return newAccount;
		
	}
	/*
	 * to view all accounts' balance information
	 */
	private void viewAllBalances(String username, String status) {
		System.out.println("View All Accounts' Balances Information: \n");
		
		List<Account> balanceList = accountService.viewAllAccountsBalances();
		System.out.println();
		for(Account a : balanceList) {
			System.out.println("Account Id: " + a.getAccountId() + "  Balance: " + a.getAccountBalance());
		}
		System.out.println("\n***********************************************************************************\n");
		employeeTasks(username, status);
	}
	/*
	 * to view all accounts information
	 */
	private void viewAllAccounts(String username, String status) {
		System.out.println("View All Accounts Information: \n");

		List<Account> accountAllList = accountService.findAll();
		System.out.println();
		for(Account a : accountAllList) {
			System.out.println(a);
		}
		System.out.println("\n***********************************************************************************\n");
		employeeTasks(username, status);
	}
	/*
	 * to view all employees information
	 */
	private void viewAllEmployeesInfo(String username, String status) {
		System.out.println("View All Employees Information: \n");
		// get all customers information
		List<Employee> employeeList = employeeService.findAllEmployees();
		System.out.println();
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("\n***********************************************************************************\n");
		employeeTasks(username, status);
}
	/*
	 * to view all customers information
	 */
	private void viewAllCustomersInfo(String username, String status) {
		System.out.println("View All Customers Information: \n");

		// get all customers information
		List<Customer> customerList = customerService.findAll();
		System.out.println();
		for(Customer c : customerList) {
			System.out.println(c);
		}
		System.out.println("\n***********************************************************************************\n");
		employeeTasks(username, status);
	}
	
	
	
	
	
}
