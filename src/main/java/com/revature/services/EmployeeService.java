package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountDAO;
import com.revature.daos.CustomerDAO;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.IAccountDAO;
import com.revature.daos.ICustomerDAO;
import com.revature.daos.IEmployeeDAO;
import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class EmployeeService {
	private static final Logger log = LogManager.getLogger(EmployeeService.class);
	private static IEmployeeDAO employeeDao = new EmployeeDAO();
	private static IAccountDAO accountDao = new AccountDAO();
	private static ICustomerDAO customerDao = new CustomerDAO();
	private static IUserDAO userDao = new UserDAO();
	
	public List<Customer> findAllCustomers() {
		return null;
		
	}
	
	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}
	
	
}
