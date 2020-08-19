package com.revature.daos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;

public interface IEmployeeDAO { 
	
	public List<Customer> findAllCustomers();
	
	public List<Employee> findAllEmployees();
	
	public List<Account> findAllAccounts();
	
	public List<Account> findAccountsWithBalance();
	
	public List<Account> findAccountByCustomerId(int customerid); 
	
	public Account findAccountByIds(int customerid, long accountid); 
	
	public boolean updateAccountStatus(String employeestatus, Account account1);
	
	public Account transaction();
	
	public boolean addAccount();
	
	public boolean deleteAccount(int accountid, String employeestatus);
	
	
	
	
	
}
