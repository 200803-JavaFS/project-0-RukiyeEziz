package com.revature.services.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceHelper {
	
	private Pattern namePattern;
	private Pattern pwPattern;
	private Matcher matcher;
	
	// user name must contain at least 3 to at most 15 characters
	// it allows letter and digits
	// must not other special characters
	private static final String USERNAMEREGEX = "^[A-Za-z0-9]{3,15}$";
	// password must contain at least 3 to at most 15 characters
	// it allows at least one digit, at least one letter
	// must not other special characters
	private static final String PASSWORDREGEX = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{3,15})$"; // "^[A-Za-z0-9]{3,15}$"; //
	
	public UserServiceHelper() {	
		namePattern = Pattern.compile(USERNAMEREGEX);
		pwPattern = Pattern.compile(PASSWORDREGEX);
		
	}
	
	/**
	   * Validate user name and password with regular expression
	   * true if valid user name and password, 
	   * false if invalid
	   */
	  public boolean validateUserName(final String username){

		  matcher = namePattern.matcher(username);
		  
		  return matcher.matches();

	  }

	  public boolean validatePassword(final String pw){

		  matcher = pwPattern.matcher(pw);
		  
		  return matcher.matches();

	  }
	
	

}
