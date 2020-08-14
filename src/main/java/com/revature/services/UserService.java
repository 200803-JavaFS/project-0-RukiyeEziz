package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;

// UserDAO.java <---- UserService.java  --->  driver? UserController
public class UserService {
	
	private static final Logger log = LogManager.getLogger(UserService.class);
	private static IUserDAO userDao = new UserDAO();
	
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	


	
}


//public User findUserById(int id) {
//log.info("account id = " + id);
//return dao.findInt(id);
//}

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