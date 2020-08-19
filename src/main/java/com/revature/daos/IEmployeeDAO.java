package com.revature.daos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;

public interface IEmployeeDAO { //extends ICustomerDAO, IAccountDAO {
	
	public List<Customer> findAllCustomers();
	
	public List<Employee> findAllEmployees();
	
	public List<Account> findAllAccounts();
	
	public List<Account> findAccountsWithBalance();
	
	public List<Account> findAccountByCustomerId(int customerid); // this is find  multiple accounts with single customer
	
	public Account findAccountByIds(int customerid, long accountid); // this finds an account tha belong to a customer
	
	public boolean updateAccountStatus(String employeestatus, Account account1);
	
	public Account transaction();
	
	public boolean addAccount();
	
	public boolean deleteAccount(int accountid, String employeestatus);
	
	
	
	
	
}
