package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

// UserDAO.java <---- UserService.java  --->  driver? UserController
public class UserService {
	
	private static final Logger log = LogManager.getLogger(UserService.class);
	private UserDAO dao = new UserDAO();
	

	public User findUserById(int id) {
		log.info("account id = " + id);
		return dao.findInt(id);
	}

	
}

////
//public User findUserByName(int i) {
//	return dao.findName(i);
//}

//public void callInitial() {
//dao.initialUser();	
//}

//public Object getUser(String name, String pw) {
//	return dao.addUser(name, pw);
//}