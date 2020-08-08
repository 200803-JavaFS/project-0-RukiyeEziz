package com.revature;
/*
 * @Author: Rukiye Eziz
 * Project: # 0
 * Due Date: 08/19/2020
 * Description: Leveraging Java 8, create an application 
 * that simulates simple banking transactions
 */

import java.util.Scanner;

public class BankingApplicationDriver {
	
	public static void main(String[] args) {
	
		System.out.println("Starting   BankingApplicationDriver.java ......");
		
		
//	    Scanner input = new Scanner(System.in);
//	    String secret = "Please", guess = "";
//
//	    System.out.print("Secret word?");
//
//	    while (!guess.equals(secret)) {
//	        guess = input.next();
//
//	        if (guess.equals(secret)) {
//	            System.out.println("enter");
//	        } else {
//	            System.out.println("try again");
//	        }
//	    }
		
		// calling helper function
		BankingApplication bankApp = new BankingApplication();
		bankApp.execute();
		
	}

}
