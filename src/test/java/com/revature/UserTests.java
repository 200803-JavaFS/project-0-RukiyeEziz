package com.revature;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;


public class UserTests {
	
	private UserTests userTests;
	public static String regx1;
	public static String regx2;
	public static String regx3;
	public static String regx4;
	public static boolean result;
	
	@BeforeClass
    public void init(){
		System.out.println("In BeforeClass");
		userTests = new UserTests();
		//System.out.println(userTests.setUserNameRegex());
    }
	
//	@Before
//	public Object[][] InvalidUsernameProvider() {
//		return new Object[][]{ {new String[] {
//		     "ruki","aZZ99","rev123"}}};
//	}
	@Before
	public void setUserNameRegex() {
		System.out.println("In Before");
		regx1 = "test";
		regx2 = "1Ac55";
		regx3 = "";
		regx4 = "90";
	}
	@After
	public void clearResult() {
		System.out.println("In After");
		result = false;
	}
}
