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
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.utilities.ConnectionUtility;

public class EmployeeDAO implements IEmployeeDAO {
	private static final Logger log = LogManager.getLogger(EmployeeDAO.class);
	
	@Override
	public List<Customer> findAllCustomers() {
		return null;
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM employees;";
			
			Statement statement = conn.createStatement();
			
			List<Employee> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);		
			
			while(result.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(result.getInt("employee_id"));
				employee.setEmployeeStatus(result.getString("status"));
				employee.setEmployeeUserName(result.getString("user_name_fk"));
							
				list.add(employee);		
			}
			log.info("EmployeeDAO successfully found all employees from DB."); 
			return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		log.info("EmployeeDAO could not find all employees from DB.");
			return null;
		}

	@Override
	public List<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * to find balances with accounts ids
	 */
	@Override
	public List<Account> findAccountsWithBalance() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * to find one or more accounts that a customer
	 */
	@Override
	public List<Account> findAccountByCustomerId(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * to find an account that hold by a specific customer
	 */
	@Override
	public Account findAccountByIds(int customerid, long accountid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * update account's status with approve, deny, or pending
	 */
	@Override
	public boolean updateAccountStatus(String employeestatus, Account account1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * perform deposit, withdraw, transfer funds, this is only for admin
	 */
	@Override
	public Account transaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * perform creating an account 
	 */
	@Override
	public boolean addAccount() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * perform canceling an account and this is only for admin
	 */
	@Override
	public boolean deleteAccount(int accountid, String employeestatus) {
		// TODO Auto-generated method stub
		return false;
	}





	

}
