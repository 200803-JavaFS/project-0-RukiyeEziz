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
import com.revature.utilities.ConnectionUtility;


public class UserDAO implements IUserDAO {
	private static final Logger log = LogManager.getLogger(UserDAO.class);
	private ICustomerDAO cDao = new CustomerDAO();
	
	@Override
	public List<User> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement statement = conn.createStatement();
			
			List<User> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User user = new User(
						result.getInt("user_id"),
						result.getString("user_name"),
						result.getString("user_pw"),
						result.getString("user_type"));
				list.add(user);
		
			}
			log.info("UserDAO successfully found all users from DB.");
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		log.info("UserDAO could not find all users from DB.");
		return null;
	}
	
	@Override
	public User findByName(String name) {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			//String sql = "SELECT * FROM users WHERE user_name = '" + name + "';";
			String sql = "SELECT * FROM users WHERE user_name = ?;";
			//Statement statement = conn.createStatement();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User user = new User(
						result.getInt("user_id"),
						result.getString("user_name"),
						result.getString("user_pw"),
						result.getString("user_type"));
				
				log.info("UserDAO found by user name from DB: " + user);	
				return user;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("UserDAO could not find user name from DB.");
		return null;
	}
	
	@Override
	public User findByNameByPW(String name, String pw) {
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "SELECT * FROM users WHERE user_name = ? and user_pw = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			statement.setString(2, pw);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {

				User user = new User(
						result.getInt("user_id"),
						result.getString("user_name"),
						result.getString("user_pw"),
						result.getString("user_type"));
				
				log.info("UserDAO found user and pw info from DB: " + user);
				return user;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("UserDAO could not find user name and pw from DB.");
		return null;
	}

	
	@Override
	public boolean addUser(User user, Customer c) {
		try(Connection conn = ConnectionUtility.getConnection()){

			String sql = "BEGIN; "
					+ "INSERT INTO users (user_name, user_pw, user_type)"
					+ "VALUES (?, ?, ?);"
					+ "INSERT INTO customers (first_name, middle_name, last_name, address, city, state, zip, phone_number, user_name_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"				
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
						
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
