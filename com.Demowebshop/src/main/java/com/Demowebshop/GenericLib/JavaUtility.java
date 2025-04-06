package com.Demowebshop.GenericLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

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
	
	
	public String takeScreenshot(WebDriver driver, String methodName) throws IOException
	{
		
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("ddMMMyyyyss").format(new Date());
        String FileName = methodName + "_" + timestamp + ".png";
		
		File dst= new File("test-output/screenshots/"+FileName);
		Files.copy(src, dst);
		
		System.out.println(dst.getAbsolutePath().replace("./", ""));
		
		return dst.getAbsolutePath().replace("./", "");
	}

}
