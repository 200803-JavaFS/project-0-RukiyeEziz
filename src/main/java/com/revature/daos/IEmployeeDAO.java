package com.revature.daos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;

public interface IEmployeeDAO { //extends ICustomerDAO, IAccountDAO {
	
	public List<Employee> findAllEmployees();
	
	public List<Account> findAllAccounts();
	
	public List<Customer> findAllCustomers();
	
	public Account findAccountByAccountId(long accountid); // this is find an account with its unique account id
	
	public List<Account> findAccountByCustomerId(int customerid); // this is find  multiple accounts with single customer
	
	public Account findByIds(int customerid, long accountid); // this finds an account tha belong to a customer
	
	//public Customer findCustomerByCustomerId(int customerid);
	
	public boolean updateAccount(Account account, String employeestatus);
	
	public boolean deleteAccount(int accountid, String employeestatus);
	
	public boolean approveDenyAccount(int customerid, long accountid, boolean approved, String memo);
	
	
	
	
}
//@Override
//public boolean approveDenyAccount(int customerid, long accountid, boolean approved, String memo) {
//	// TODO Auto-generated method stub
//	return false;
//}