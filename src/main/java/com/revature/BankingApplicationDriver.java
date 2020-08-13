package com.revature;
/*
 * @Author: Rukiye Eziz
 * Project: # 0
 * Due Date: 08/19/2020 Wednesday
 * Description: Leveraging Java 8, create an application 
 * that simulates simple banking transactions
 */

public class BankingApplicationDriver {
	
	
	public static void main(String[] args) {
	
		System.out.println("Starting BankingApplicationDriver.java ......");
		
		// calling helper function BankingApplication.java
		BankingApplication bankApp = new BankingApplication();
		
		bankApp.logInOrCreateAccountOption();
		//bankApp.selectUserType();
		
	}

}
