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

import com.revature.models.User;
import com.revature.utilities.ConnectionUtility;


public class UserDAO implements IUserDAO {
	private static final Logger log = LogManager.getLogger(UserDAO.class);
	//private static int index = 0;
	
	@Override
	public List<User> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement statement = conn.createStatement();
			
			List<User> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
//				User user = new User();
//				user.setUserId(result.getInt("user_id")); 
//				user.setUserName(result.getString( "user_name"));
//				user.setPassword(result.getString("user_pw"));
//				user.setUserType(result.getString("user_type"));
//				list.add(user);
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
			// TODO Auto-generated catch block
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
//				User user = new User();
//				user.setUserName(result.getString("user_name"));
//				user.setPassword(result.getString("user_pw"));
//				user.setUserType(result.getString("user_type"));
//				System.out.println("UserDAO find by name user: " + user);	
//				return user;
				User user = new User(
						result.getInt("user_id"),
						result.getString("user_name"),
						result.getString("user_pw"),
						result.getString("user_type"));
				
				log.info("UserDAO found by user name from DB: " + user);	
				return user;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("UserDAO could not find user name from DB.");
		return null;
	}
	
	@Override
	public User findByNamePW(String name, String pw) {
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "SELECT * FROM users WHERE user_name = ? and user_pw = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			statement.setString(2, pw);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
//				User user = new User();
//				user.setUserName(result.getString("user_name"));
//				user.setPassword(result.getString("user_pw"));
//				user.setUserType(result.getString("user_type"));
				User user = new User(
						result.getInt("user_id"),
						result.getString("user_name"),
						result.getString("user_pw"),
						result.getString("user_type"));
				
				log.info("UserDAO found user and pw info from DB: " + user);
				return user;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("UserDAO could not find user name and pw from DB.");
		return null;
	}

	
	@Override
	public boolean addUser(User u) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "INSERT INTO users (user_name, user_pw, user_type) "
					+ "VALUES (?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);			
			
			int index = 0;
			//statement.setInt(++index, u.getUserId()); // id is auto incremented for users table
			statement.setString(++index, u.getUserName());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getUserType());
			
			statement.execute();
			log.info("UserDAO successfully added new user to DB: " + u);
			return true;
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		log.info("UserDAO could not add new user to DB.");
		return false;
	}

	
	

}

	

//while (result.next()) {
//// Mapping the result from the query into UserInformation POJO
//return mapUser(result);
//}
/*
ResultSet result = statement.executeQuery(sql);
//ResultSet result = statement.executeQuery(sql);
//int index = 0;
//statement.getString(++index, x);
log.info(name);

if(result.next()) {
User user = new User();
user.setUserName(result.getString("user_name"));
user.setPassword(result.getString("user_pw"));
user.setUserType(result.getString("user_type"));
System.out.println("UserDAO found user info: " + user);
//if(user != null) {
//	user.setUserName(result.getString("user_name"));
//}

return user;
}	
else {
return null;
}*/
