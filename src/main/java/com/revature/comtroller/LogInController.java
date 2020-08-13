package com.revature.comtroller;

public class LogInController {
	
	
	public boolean userLogInValidate(String username, String pw) {
		System.out.println("I am in LogInController");
		if(username.equalsIgnoreCase("jamie") && pw.equals("aki")) {
			return true;
		}
			
		
		return false;
		
	}
	

}
