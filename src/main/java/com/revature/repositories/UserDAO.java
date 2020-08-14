//package com.revature.repositories;
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.revature.models.User;
//
//// User.java <--- UserDAO.java ---> UserService.java
//public class UserDAO {
//	
//	//ArrayList<User> userInfo = new ArrayList<User>();
//	private static final Logger log = LogManager.getLogger(UserDAO.class);
//
//
//	User[] userInfo = {new User(1, "aki", "aki","Client", true, false), 
//					new User(3, "ruki", "ruki", "Employee", true, false)};
//
//	public User findInt(int id) {		
//		log.info("id = " + id);		
//		return userInfo[id];
//	}
//	
//
//
//	
//}
//
//
//
////public Object addUser(String name, String pw) {
////for(int i = 0; i < user.length; i++) {
////	user[count+1] = new User(count, name, pw);
////	System.out.println(user[i]);
////	count++;
////}
////
////System.out.println(count + " count");
////
////return user;
////}
//
////int count = 0;;
////User[] user;
////
////public void initialUser () {
////	user= new User[100];
////	user[0] = new User(1, "aki", "aki");
////	user[1] = new User(2, "ruki", "ruki");
////	System.out.println("initialize------" + user.length);
////	count = 3;
////	
////
////}
//
////User[] namePW = {new User("aki", "aki"), new User("jj", "jj")};
//
////public User findName(int i) {
////return namePW[i];
////}
////
//
//
////public boolean save(User user);
////public boolean update(User user);
////public User findByUserId(int id) {
////  return id;
////}
////public boolean delete(User user);