package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.revature.models.User;
import com.revature.utilities.ConnectionUtility;


public class UserDAO implements IUserDAO {
	//private IUserDAO userDao = new UserDAO();

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
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
