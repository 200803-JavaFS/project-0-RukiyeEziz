package com.revature.services;

import java.util.ArrayList;
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

	public Customer findCustomerByName(String username) {
		log.info("CustomerService looking for customer by user name ... " + username);
		log.info("Customer logged in and about to do tasks.");
		return customerDao.findByName(username);
	}

	public Customer findCustomerById(int id) {
		log.info("CustomerService looking for customer by id ...: " + id);	
		return customerDao.findById(id);
	}

	public boolean updateAddress(ArrayList<String> list, int id) {
		
		if(customerDao.updateAddress(list, id)) {
			log.info("CustomerService successfully updated customer information.");
			return true;
		}
		log.info("CustomerService could not update customer information on DB.");
		return false;
	}
	
	public boolean updatePhone(int phone, int id) {
		if(customerDao.updatePhone(phone, id)) {
			log.info("CustomerService successfully updated customer information.");
			return true;
		}
		log.info("CustomerService could not update customer information on DB.");
		return false;
	}
	
}
