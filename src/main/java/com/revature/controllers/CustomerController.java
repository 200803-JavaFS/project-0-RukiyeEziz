package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.services.CustomerService;


// customer manage their account, create a new account, edit personal info
public class CustomerController {
	
	private static AccountController accountController = new AccountController();
	private CustomerService customerService = new CustomerService();
	
	private static Scanner scan = new Scanner(System.in);
	
	public void customerTasks(String username) {
		
		Customer c = customerService.findCustomerByName(username);	

		int customerId = 0;
		if(c != null ) {
			System.out.println("Your customer User Name: " + c.getUserName());
			System.out.println("Your customer ID: " + c.getCustomerId() );
			customerId = c.getCustomerId();
		}

		System.out.println("\nWhat would you like to do? Select one of options and press 'enter':\n\n"
				+ "[1]\t Manage existing account\n"
				+ "[2]\t Apply for a new account\n"  // customer should apply joit account
				+ "[3]\t Edit your personal information\n"
				+ "[4]\t Close the Application");
		
		System.out.println("\n**************************************************************\n");
		String option = scan.next();
		System.out.println();
		
		switch (option) {

			case "1":
				accountController.manageAccount(customerId);
				break;
			case "2":
				System.out.println("Please speak with one of our employee for creating a new account. Thank you.");  
				System.out.println("Please select one of the following options:");
				System.out.println("\n**************************************************************\n");
				customerTasks(username);
				
				break;
			case "3":
				editPersonalInfo(customerId);
				break;
			case "4":
				System.out.println("Thank you for choosing business with University of Mars Credit Union.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please select one of the following options:");
				System.out.println("\n**************************************************************\n");
				customerTasks(username);
				break;		
		}// end of switch	
	}

	private void createNewAccount(int id) {
		System.out.println("create a new account");
		
	}
	private void editPersonalInfo(int id) {
		
		Customer c = customerService.findCustomerById(id);
		
		if(c != null) {
			System.out.println("\nYour Personal Information: ");
			System.out.println(c);
		}
		System.out.println("\nNOTE: You only can edit adrress and phone number.");
		System.out.println("\nWhat would you like to edit? Type one of options and press 'enter':\n\n"
				+ "Edit [Address]: \n"
				+ "Edit [Phone]: \n"
				+ "[Exit] Application: \n");
		String option = scan.next();
		option.toLowerCase();
		ArrayList<String> info = new ArrayList<>();
		scan = new Scanner(System.in);
		
		switch (option) {
			case "address":
				System.out.print("Enter Address: ");
				String address = scan.nextLine();
				info.add(address);
				
				System.out.println();
				System.out.print("Enter City: ");
				String city = scan.nextLine();
				info.add(city);
				
				System.out.println();
				System.out.print("Enter State: ");
				String state = scan.nextLine();
				info.add(state);
				
				System.out.println();
				System.out.print("Enter valid zip: ");
				int zip = scan.nextInt();   
				
				info.add(Integer.toString(zip));
				System.out.println("\nYou entered: " + info + "\n");
				
				if(customerService.updateAddress(info, id)) {
					System.out.println("Your information successfully updated.");
					
				}else {
					System.out.println("Something went wrong please try again");
					editPersonalInfo(id);					
				}							
				break;
			case "phone":
				System.out.print("Enter Address: ");
				int phone = scan.nextInt();
				System.out.println("\nYou entered: " + phone + "\n");
				if(customerService.updatePhone(phone, id)) {
					System.out.println("Your information successfully updated.");
					
				}else {
					System.out.println("Something went wrong please try again");
					editPersonalInfo(id);				
				}
								
				break;
			case "exit":
				System.out.println("Thank you. See you next time.\n");
				break;
			default:
				System.out.println("Invalid option. Please select one of the following options:");
				System.out.println("\n**************************************************************\n");
				editPersonalInfo(id);
				break;		
		}// end of switch		
	}// end of editPersonalInfo(int id)

} // end of controller
