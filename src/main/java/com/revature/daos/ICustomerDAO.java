package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

public interface ICustomerDAO {
	
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public boolean addPersonalInfo(Customer c);

}
