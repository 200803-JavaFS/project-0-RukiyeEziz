package com.revature.models;

public class User {

	private int userId;
	private String userName;	
	private String password;
	private String userType; // client, employee, admin
	private boolean logInAccount = false;
	private boolean createAccount = false;
	
	// BankingApplication.java <-- User.java --> UserDAO.java
	public User() {
		super();
	}
	
	public User(int i, String name, String pw, 
			String type, boolean logIn, boolean create) {
		super();
		this.userId = i;
		this.userName = name;
		this.password = pw;
		this.userType = type;
		this.logInAccount = logIn;
		this.createAccount = create;
		
		
	}
	
//	public User(String userName, String pw) {
//		super();
//		setUserName(userName);
//		setPassword(pw);
//	}
//
//	public User( int id, String userName, String pw) {
//		this(userName, pw);
//		setUserId(id);		
//	}
//	
//	public User(String userName, String pw, int id, String userType) {
//		this(userName, pw);
//		setUserType(userType);		
//	}
//	public User(String userName, String pw, int id, String userType, boolean logIn, boolean create) {
//		this(userName, pw);
//		this.isLogInAccount();
//		this.isCreateAccount();
//		
//	}
	
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
	
	public boolean isLogInAccount() {
		return logInAccount;
	}

	public void setLogInAccount(boolean logInAccount) {
		this.logInAccount = logInAccount;
	}

	public boolean isCreateAccount() {
		return createAccount;
	}

	public void setCreateAccount(boolean createAccount) {
		this.createAccount = createAccount;
	}
	
	@Override
	public String toString() {
		return "User [userName = " + userName + ", password = " 
				+ password + ", userType = " + userType + ", logInAccount = "
				+ logInAccount + ", createAccount = " + createAccount + "]";
	}
	
	

	

	
	
	
}
