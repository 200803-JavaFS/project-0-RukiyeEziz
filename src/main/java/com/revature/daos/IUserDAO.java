package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAll();

	public User findByName(String name);

	public User findByNamePW(String name, String pw);
	
	public boolean addUser(User u);
	
	
	
}
