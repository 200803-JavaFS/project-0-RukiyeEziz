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

import com.revature.models.Customer;
import com.revature.models.User;
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
				customer.setAddress(result.getString("address"));
				customer.setCity(result.getString("city"));
				customer.setState(result.getString("state"));
				customer.setZip(result.getInt("zip"));
				customer.setPhoneNumber(result.getInt("phone_number"));
				//customer.setUserName(result.getString("user_name_fk"));
						
				list.add(customer);		
			}
			log.info("CustomerDAO successfully found all customers from DB."); // + list);
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("CustomerDAO could not find all customers from DB.");
		return null;
	}

	@Override
	public Customer findById(int id) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM customers WHERE customer_id = " + id + ";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			
			if(result.next()) {
				Customer customer = new Customer(
						result.getInt("customer_id"),						
						result.getString("first_name"),
						result.getString("middle_name"),
						result.getString("last_name"),
						result.getString("address"),
						result.getString("city"),
						result.getString("state"),
						result.getInt("zip"),
						result.getInt("phone_number"),
						null);//result.getString("user_name_fk"));
				
				log.info("CustomerDAO found customer by id from DB: " + customer);
				
				return customer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("CustomerDAO could not find customer by id from DB.");
		return null;
	}

	@Override
	public Customer findByName(String username) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM customers WHERE user_name_fk = ? ;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				Customer customer = new Customer();
				customer.setCustomerId(result.getInt("customer_id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setMiddleName(result.getString("middle_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setAddress(result.getString("address"));
				customer.setCity(result.getString("city"));
				customer.setState(result.getString("state"));
				customer.setZip(result.getInt("zip"));
				customer.setPhoneNumber(result.getInt("phone_number"));
				//customer.setUserName(result.getString("user_name_fk"));
			
				log.info("CustomerDAO found customer by name from DB: " + customer);
				
				return customer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("CustomerDAO could not find customer by name from DB.");
		return null;
	}

	@Override
	public boolean updateAddress(ArrayList<String> list, int id) {
		System.out.println("got the list at c dao");
		String address, city, state;
		address = list.get(0);
		city = list.get(1);
		state = list.get(2);
		int zip = Integer.parseInt(list.get(3));
		
		System.out.println(address + " " + city + " " + state + " " + zip);
		
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "UPDATE customers "
					+ "SET address = '" + address + "', city = '" + city + "', state = '" + state + "', zip = " + zip + " " 
					+ "WHERE customer_id  = " + id + ";";
		
			Statement statement = conn.createStatement();
			statement.execute(sql);
				log.info("CustomerDAO successfully updated customer personal info on DB: " );		
				return true;
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("CustomerDAO could not update customer personal info from DB.");
		return false;

	}

	@Override
	public boolean updatePhone(int phone, int id) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "UPDATE customers "
					+ "SET phone_number = " + phone + " " 
					+ "WHERE customer_id  = " + id + ";";
			
			Statement statement = conn.createStatement();
			statement.execute(sql);
			log.info("CustomerDAO successfully updated customer personal info on DB: " );		
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("CustomerDAO could not update customer personal info from DB.");
		return false;
	}

	@Override
	public boolean addUser(Customer c, User user) {
		try(Connection conn = ConnectionUtility.getConnection()){
//			String sql = "INSERT INTO users (user_name, user_pw, user_type) "
//					+ "VALUES (?, ?, ?);";
			
			
			String sql = "BEGIN; "
					+ "INSERT INTO users (user_name, user_pw, user_type)"
					+ "VALUES (?, ?, ?);"
					+ "INSERT INTO customers (first_name, middle_name, last_name, address, city, state, zip, phone_number, user_name_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"				
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//Customer c =  user.getUserName();
			
			
			int index = 0;
			//statement.setInt(++index, user.getUserId());
			statement.setString(++index, user.getUserName());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, user.getUserType());
			statement.setString(++index, c.getFirstName());
			statement.setString(++index, c.getMiddleName());
			statement.setString(++index, c.getLastName());
			statement.setString(++index, c.getAddress());
			statement.setString(++index, c.getCity());
			statement.setString(++index, c.getState());
			statement.setInt(++index, c.getZip());
			statement.setInt(++index, c.getPhoneNumber());
			statement.setString(++index, user.getUserName());
			
	
			
//			
//			PreparedStatement statement = conn.prepareStatement(sql);			
//			
//			int index = 0;
//			//statement.setInt(++index, u.getUserId()); // id is auto incremented for users table
//			statement.setString(++index, user.getUserName());
//			statement.setString(++index, user.getPassword());
//			statement.setString(++index, user.getUserType());
			
			statement.execute();
			log.info("UserDAO successfully added new user to DB: " + user);
			return true;
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		log.info("UserDAO could not add new user to DB.");
		return false;
	}
	
}
