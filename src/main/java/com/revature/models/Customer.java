package com.revature.models;

import java.util.Date;
import java.util.UUID;

public class Customer {
	
	private UUID id;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private int ssn;
	private Date dob;
	
	private String userName;
	private String password;
	//private Long customerNumber;
	private Date logInDateTime;
	
	private AddressInfo addresstInfo;
	private String email;
	private String phone;
	
	

}
