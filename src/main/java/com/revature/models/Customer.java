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
	private Address customerAddress;
	
	public Customer(UUID id, 
					String firstName, 
					String middleName, 
					String lastName, 
					int ssn, 
					Date dob, 
					String userName,
					String password, 
					Address customerAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.dob = dob;
		this.userName = userName;
		this.password = password;
		this.customerAddress = customerAddress;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
}
