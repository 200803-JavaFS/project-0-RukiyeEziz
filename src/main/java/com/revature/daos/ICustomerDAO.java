package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.User;

public interface ICustomerDAO {
	
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public Customer findByName(String username);
	
	public boolean updateAddress(ArrayList<String> list, int id);
	
	public boolean updatePhone(int phone, int id);
	
	public boolean addUser( Customer c, User user);


}
