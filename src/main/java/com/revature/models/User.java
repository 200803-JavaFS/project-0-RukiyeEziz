package com.revature.models;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userName;	
	private String password;
	private String userType; // client, employee, admin
	
//	private boolean logInAccount = false;
//	private boolean createAccount = false;
	public User() {
		// TODO Auto-generated constructor stub
		super();
	}
	public User(int id, String username, String userPW, String usertype) {
		super();
		this.userId = id;
		this.userName = username;
		this.password = userPW;
		this.userType = usertype;
	}
	public User(String username, String userPW, String usertype) {
		super();	
		this.userName = username;
		this.password = userPW;
		this.userType = usertype;
	}
	
//	public User(int i, String name, String pw, String type)   //, boolean logIn, boolean create) {
//		super();
//		this.userId = i;
//		this.userName = name;
//		this.password = pw;
//		this.userType = type;
////		this.logInAccount = logIn;
////		this.createAccount = create;
//		
//	}
//	
	public User(String name) {
		super();
		this.userName = name;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
//	public boolean isLogInAccount() {
//		return logInAccount;
//	}
//
//	public void setLogInAccount(boolean logInAccount) {
//		this.logInAccount = logInAccount;
//	}
//
//	public boolean isCreateAccount() {
//		return createAccount;
//	}
//
//	public void setCreateAccount(boolean createAccount) {
//		this.createAccount = createAccount;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + (createAccount ? 1231 : 1237);
//		result = prime * result + (logInAccount ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
//		if (createAccount != other.createAccount)
//			return false;
//		if (logInAccount != other.logInAccount)
//			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userName = " + userName + ", password = " 
				+ password + ", userType = " + userType + "]";
		
		//", logInAccount = " + logInAccount + ", createAccount = " + createAccount + 
	}
	
	
}
