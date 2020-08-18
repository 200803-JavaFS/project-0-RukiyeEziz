package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAll();

	public User findByName(String name);

	public User findByNameByPW(String name, String pw);
	
	public boolean addUser(User user, Customer c);
	
	
	
	
}
