package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.LoginPage;
import com.Demowebshop.ObjectRepository.WelcomePage;


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
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(email, password);
		
		Thread.sleep(4000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		
		
	}
		
	}
	

