package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.RegisterPage;
import com.Demowebshop.ObjectRepository.WelcomePage;
import com.aventstack.extentreports.Status;

/**
 * 
 * @author Ankita
 *
 */


public class ValidRegisterTest extends BaseTest{
	
	
	@Test(testName = "TC_Register_ValidReg_01: Verify valid user can register successfully")
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
		test.log(Status.INFO, "Step 1: Clicked on Register Link on welcome page");
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		  
		  
		// Step 3: To fill registration form
		test.log(Status.INFO, "Step 2: Entering registration details : " + firstName + " " + lastName + " " + email + " " + password);
		RegisterPage rp = new RegisterPage(driver); 
		rp.toRegister(firstName, lastName, email, password);
		
		test.log(Status.INFO, "Step 3: Register Button clicked");
		
		String text = rp.getSuccessMessage();
		
		Assert.assertEquals(text, "Your registration completed");
		test.log(Status.INFO, "Step 4: Registration sucessful");

	
		 
	}
}
