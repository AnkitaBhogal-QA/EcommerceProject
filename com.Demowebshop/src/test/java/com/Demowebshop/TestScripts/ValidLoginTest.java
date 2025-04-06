package com.Demowebshop.TestScripts;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
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


public class ValidLoginTest extends BaseTest {
	
	@Test(testName = "TC_Login_ValidLogin_01: Verify valid user is able to login successfully")
	public void loginTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		String email = e.readDataFromExcel(EXCELPATH, LOGINSHEETAFTERREG, 1, 0);
		String password = e.readDataFromExcel(EXCELPATH, LOGINSHEETAFTERREG, 1, 1);;
		
		test.log(Status.INFO, "Step 1: Clicked on Login Link on welcome page");
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
	
		test.log(Status.INFO, "Step 2: Entering credentials as: " + email + " and " + password);
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(email, password);
		
		test.log(Status.INFO, "Step 3: Login Button clicked");
		
		Thread.sleep(4000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		test.log(Status.INFO, "Step 4: Login Pass");
		
		
	}
	
	
	}
	

