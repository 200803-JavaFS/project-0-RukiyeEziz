package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Customer;
import com.revature.services.UserService;
import com.revature.utilities.ConnectionUtility;

public class CustomerDAO implements ICustomerDAO {
	private static final Logger log = LogManager.getLogger(UserService.class);
	@Override
	public List<Customer> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM customers;";
			
			Statement statement = conn.createStatement();
			
			List<Customer> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);	
			
			while(result.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(result.getInt("customer_id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setMiddleName(result.getString("middle_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name_fk"));
				customer.setAddress(result.getString("address"));
				customer.setCity(result.getString("city"));
				customer.setState(result.getString("state"));
				customer.setZip(result.getInt("zip"));
				customer.setPhoneNumber(result.getInt("phone_number"));
						
				list.add(customer);		
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPersonalInfo(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
