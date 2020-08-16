package com.revature.daos;

import java.sql.Connection;
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
				account.setCreatedDateTime(result.getDate("created_date_time"));
				
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
						result.getDate("created_date_time"));
				
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
				account.setCreatedDateTime(result.getDate("created_date_time"));
				
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

	
}
