package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAll();
	
	public User findById(int id);
	
}