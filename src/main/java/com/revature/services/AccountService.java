package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountDAO;
import com.revature.daos.IAccountDAO;
import com.revature.models.Account;


public class AccountService {
	private static final Logger log = LogManager.getLogger(AccountService.class);
	private static IAccountDAO accountDao = new AccountDAO();
	
	public List<Account> findAll(){
		return accountDao.findAll();
	}
	
	public List<Account> findAccountByCustomerId(int id) {
		log.info("AccountService looking for account by customer id ... " + id);
		return accountDao.findById(id);
	}

	public Account findAccountByIds(int customerid, long accountid) {
		log.info("AccountService looking for an account by customer id ... " + customerid + " and account id " + accountid );
		return accountDao.findByIds(customerid, accountid);
	}
	
	public boolean depositAccount(int customerid, long accountid, double amount) {
		log.info("AccountService depositing to an account ...");
		if(accountDao.depositAccount(customerid, accountid, amount)) {
			
			return true;
		}
		return false;
	}
	public boolean withdrawAccount(int customerid, long accountid, double amount) {
		log.info("AccountService withdrawing from an account ...");
		if(accountDao.withdrawAccount(customerid, accountid, amount)) {
			
			return true;
		}
		return false;
	}
	public List<Account> viewAllAccountsBalances() {
		return accountDao.viewAllAccountsBalances();
	}
	
	public boolean setAccountStatus(Account account) {
		if(accountDao.setAccountStatus(account)) {
			return true;
		}
		return false;
	}
	public boolean AddAccount(Account account) {
		if(accountDao.AddAccount(account)) {
			return true;
		}
		return false;
	}
}
