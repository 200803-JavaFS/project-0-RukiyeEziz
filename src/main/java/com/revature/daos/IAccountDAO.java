package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {
	
	public List<Account> findAll();
	
	public List<Account> findById(int customerid);
	
	public Account findByIds(int customerid, long accountid);
	
	public boolean depositAccount(int customerid, long accountid, double ammount);
	
	public boolean withdrawAccount(int customerid, long accountid, double amount);
	
	//public Account transferFunds(int customerid1, int customerid2, long accountid1, long accountid2, double amount);
	
	public boolean approveDenyAccount(int customerid, long accountid, boolean approved);
	
	public boolean updateAccount (int customerid, long accountid);
	
	public boolean deleteAccount(int customerid, long accountid);                                        
	

}
