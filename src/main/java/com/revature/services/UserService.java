package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.daos.ICustomerDAO;
import com.revature.daos.CustomerDAO;
import com.revature.models.Customer;

// UserDAO.java <---- UserService.java  --->  DriverHelper.java
public class UserService {
	
	private static final Logger log = LogManager.getLogger(UserService.class);
	private static IUserDAO userDao = new UserDAO();
	private static ICustomerDAO cDao = new CustomerDAO();
	
	public List<User> findAll(){		
		return userDao.findAll();
	}
	
	public User findUserByName(String name) {	
		log.info("UserService looking for user name ... " + name);
		return userDao.findByName(name);
	}
	
	public User findUserByNameByPW(String name, String pw) {	
		log.info("UserService looking for user name and pw ... " + name);
		return userDao.findByNameByPW(name, pw);
	}
	
	public boolean insertUser(User user, Customer cus) {
		log.info("User Service trying to insert user to DB ... " + user);
			
		if(userDao.addUser(user, cus)) {
			return true;
		}
		return false;
	}


	
}

