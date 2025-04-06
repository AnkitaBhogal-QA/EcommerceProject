package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.RegisterPage;
import com.Demowebshop.ObjectRepository.WelcomePage;

/**
 * 
 * @author Ankita
 *
 */


public class RegisterTest extends BaseTest{
	
	
	@Test
	public void register() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		int fno = j.randomNumber();
		int lno = j.randomNumber();
		
		String firstName = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, fno, 0);
		String lastName = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, lno, 1); 
		String email = j.randomEmail(firstName, lastName);
		String password = j.generatePassword(lastName);
		
		// Step 1: Set the email and password generated to excel sheet for Login purpose
		e.writeLoginDetailsToExcel(EXCELPATH, LOGINSHEETAFTERREG, email,password);
		
		  
		// Step 2: Click on register link on welcome page
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		  
		  
		// Step 3: To fill registration form
		RegisterPage rp = new RegisterPage(driver);
		rp.toRegister(firstName, lastName, email, password);
	
		 
	}
}
