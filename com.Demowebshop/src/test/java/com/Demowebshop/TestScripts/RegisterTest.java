package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.RegisterPage;
import com.Demowebshop.ObjectRepository.WelcomePage;

public class RegisterTest extends BaseTest{
	
	
	@Test
	public void register() throws InterruptedException, EncryptedDocumentException, IOException {

		//System.out.println("Test");
		
		
		  String firstName = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, 1, 0);
		  String lastName = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, 1, 1); String
		  password = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, 1, 2);
		  
		  // Step 1: click on register link WelcomePage wp = new WelcomePage(driver);
		  WelcomePage wp = new WelcomePage(driver);
		  wp.getRegisterLink().click();
		  
		  
		  // Step 2: registration RegisterPage rp = new RegisterPage(driver);
		  RegisterPage rp = new RegisterPage(driver);
		  rp.toRegister(firstName, lastName, "ankita45@testxp.com", password);
		 
	}
}
