package com.Demowebshop.GenericLib;

import java.util.Random;

/**
 * 
 * @author Ankita
 *
 */


public class JavaUtility {
	
	/*
	 * this method will generate random email id for registration
	 * 
	 * @ String file path
	 * @ String key
	 */
	
	public String randomEmail(String fname, String lname)
	{
		Random r = new Random();
		int no = r.nextInt(10000);
		String email = fname +lname +no +"@testxp.com";
		System.out.println(email);
		return email;
	}
	
	
	public int randomNumber()
	{
		Random r = new Random();
		int no = r.nextInt(10);
		System.out.println(no);
		return no+1 ;
	}
	
	public String generatePassword(String lname)
	{
		Random r = new Random();
		String password = lname +"@123";
		System.out.println(password);
		return password ;
	}

}
