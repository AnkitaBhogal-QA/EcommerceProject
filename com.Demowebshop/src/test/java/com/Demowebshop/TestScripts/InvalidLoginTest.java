package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.LoginPage;
import com.Demowebshop.ObjectRepository.WelcomePage;
import com.aventstack.extentreports.Status;

/**
 * 
 * @author Ankita
 *
 */


public class InvalidLoginTest extends BaseTest{
	
	@Test(testName = "TC_Login_InValidLogin_01: Verify invalid credentials")
	public void inValidloginTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String email = e.readDataFromExcel(EXCELPATH, INVALIDLOGINSHEET, 1, 0);
		String password = e.readDataFromExcel(EXCELPATH, INVALIDLOGINSHEET, 1, 1);
		
		
		test.log(Status.INFO, "Step 1: Clicked on Login Link on welcome page");
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		test.log(Status.INFO, "Step 2: Entering credentials as: " + email + " and " + password);
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(email, password);
		
		test.log(Status.INFO, "Step 3: Login Button clicked");
		
		String text = lp.getErrorText1();
		
		Thread.sleep(4000);
		
		Assert.assertEquals(text, "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
		test.log(Status.INFO, "Step 4: Invalid Login Pass");
		
	}

}
