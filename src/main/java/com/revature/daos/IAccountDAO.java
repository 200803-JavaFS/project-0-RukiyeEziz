package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {
	
	public List<Account> findAll();
	
	public List<Account> findById(int customerid); 
	
	public Account findByIds(int customerid, long accountid); 
	
	public boolean depositAccount(int customerid, long accountid, double ammount);
	
	public boolean withdrawAccount(int customerid, long accountid, double amount);
	
	public List<Account> viewAllAccountsBalances();
	
	public boolean setAccountStatus(Account account);
	
	public boolean AddAccount(Account account);
	
	
	

}
