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

	@Override
	public List<User> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement statement = conn.createStatement();
			
			List<User> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User user = new User();
				user.setUserId(result.getInt("user_id")); 
				user.setUserName(result.getString( "user_name"));
				user.setPassword(result.getString("user_pw"));
				user.setUserType(result.getString("user_type"));
				list.add(user);
		
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	@Override
	public User findByName(String name) {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			//String sql = "SELECT * FROM users WHERE user_name = '" + name + "';";
			String sql = "SELECT * FROM users WHERE user_name = ?;";
			//Statement statement = conn.createStatement();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name.toLowerCase());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User user = new User();
				user.setUserName(result.getString("user_name"));
				user.setPassword(result.getString("user_pw"));
				user.setUserType(result.getString("user_type"));
				System.out.println("UserDAO found user info: " + user);	
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public User findByNamePW(String name, String pw) {
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "SELECT * FROM users WHERE user_name = ? and user_pw = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name.toLowerCase());
			statement.setString(2, pw);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User user = new User();
				user.setUserName(result.getString("user_name"));
				user.setPassword(result.getString("user_pw"));
				user.setUserType(result.getString("user_type"));
				
				log.info("UserDAO user info: " + user);
				return user;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	
	@Override
	public boolean addUser(User u) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "INSERT INTO users (user_name, user_pw, user_type) "
					+ "VALUES (?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);			
			
			int index = 0;
			//statement.setInt(++index, u.getUserId());
			statement.setString(++index, u.getUserName());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getUserType());
			
			statement.execute();
			log.info("UserDAO user info: " + u);
			return true;
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
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
