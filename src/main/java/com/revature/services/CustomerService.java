package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.CustomerDAO;
import com.revature.daos.ICustomerDAO;
import com.revature.models.Customer;

public class CustomerService {
	private static final Logger log = LogManager.getLogger(UserService.class);
	private static ICustomerDAO customerDao = new CustomerDAO();
	
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}
}
