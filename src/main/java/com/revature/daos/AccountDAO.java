package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.services.AccountService;
import com.revature.utilities.ConnectionUtility;

public class AccountDAO implements IAccountDAO {
	private static final Logger log = LogManager.getLogger(AccountService.class);
	
	@Override
	public List<Account> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts;";
			
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Account account = new Account();
				account.setAccountId(result.getLong("account_id"));
				account.setAccountName(result.getString("account_name"));
				account.setAccountType(result.getString("account_type"));
				account.setAccountBalance(result.getDouble("balance"));
				account.setStatus(result.getString("status"));
				account.setCustomerId(result.getInt("customer_id_fk"));
				account.setInternalMemo(result.getString("internal_memo"));
				account.setCreatedDateTime(result.getString(("created_date_time")));
				
				list.add(account);				
			}
			log.info("AccountDAO successfully found all accounts from DB.");
			return list;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("AccountDAO could not find all accounts from DB.");
		return null;
	}

	@Override
	public List<Account> findById(int id) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE customer_id_fk = " + id + ";";
			
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Account account = new Account(
						result.getLong("account_id"),						
						result.getString("account_name"),
						result.getString("account_type"),
						result.getDouble("balance"),
						result.getString("status"),
						result.getInt("customer_id_fk"),
						result.getString("internal_memo"),
						result.getString("created_date_time"));
				
				log.info("AccountDAO found account by customer id from DB: " + account);
				
				list.add(account);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("CustomerDAO could not find account by customer id from DB.");
		return null;
	}

	@Override
	public Account findByIds(int customerid, long accountid) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE account_id = " + accountid 
					+ " AND customer_id_fk = " + customerid + ";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				Account account = new Account();
				account.setAccountId(result.getLong("account_id"));
				account.setAccountName(result.getString("account_name"));
				account.setAccountType(result.getString("account_type"));
				account.setAccountBalance(result.getDouble("balance"));
				account.setStatus(result.getString("status"));
				account.setCustomerId(result.getInt("customer_id_fk"));
				account.setInternalMemo(result.getString("internal_memo"));
				account.setCreatedDateTime(result.getString(("created_date_time")));
				
				log.info("AccountDAO successfully found the specific one account from DB.");
				return account;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("AccountDAO could not find the specific one account from DB.");
		return null;
	}

	@Override
	public boolean depositAccount(int customerid, long accountid, double amount) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "UPDATE accounts "
					+ "SET balance = " + amount + " "
					+ "WHERE customer_id_fk = " + customerid + " AND account_id = " + accountid + ";";
			
			Statement statement = conn.createStatement();
			statement.execute(sql);
				
				log.info("AccountDAO found account by customer id from DB: " );
				
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		log.info("AccountDAO could not deposit to ccount on DB.");	
		return false;
	}

	@Override
	public boolean withdrawAccount(int customerid, long accountid, double amount) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "UPDATE accounts "
					+ "SET balance = " + amount + " "
					+ "WHERE customer_id_fk = " + customerid + " AND account_id = " + accountid + ";";
			
			Statement statement = conn.createStatement();
			statement.execute(sql);
				
				log.info("AccountDAO found account by customer id from DB: " );
				
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		log.info("AccountDAO could not deposit to ccount on DB.");	
		return false;
	}

	@Override
	public List<Account> viewAllAccountsBalances() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT account_id, balance FROM accounts;";
			
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Account account = new Account();
				account.setAccountId(result.getLong("account_id"));
				account.setAccountBalance(result.getDouble("balance"));
				
				list.add(account);
			}	
			log.info("AccountDAO successfully found the list of accounts balances from DB.");
			return list;
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		log.info("AccountDAO couldn't find the list of accounts balances from DB.");
		return null;
	}

	@Override
	public boolean setAccountStatus(Account account) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE accounts SET status = ?"
					+ "WHERE account_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, account.getStatus());
			statement.setLong(2, account.getAccountId());
			
			statement.execute();
			
			log.info("AccountDAO successfully set the status of this account from DB.");
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("AccountDAO failed to set the status of this account from DB.");
		return false;
	}

	@Override
	public boolean AddAccount(Account account) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO accounts (account_id, account_name, account_type, balance, status, customer_id_fk, internal_memo, created_date_time)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setLong(++index, account.getAccountId());
			statement.setString(++index, account.getAccountName());
			statement.setString(++index, account.getAccountType());
			statement.setDouble(++index, account.getAccountBalance());
			statement.setString(++index, account.getStatus());
			statement.setLong(++index, account.getCustomerId());
			statement.setString(++index, account.getInternalMemo());
			statement.setString(++index, account.getCreatedDateTime());
			
			statement.execute();
			
			log.info("AccountDAO successfully created this account sent to get approved from DB.");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		log.info("AccountDAO failed to create this account from DB.");
		return false;
	}
	

	
}
