package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.LoginPage;
import com.Demowebshop.ObjectRepository.SearchPage;
import com.Demowebshop.ObjectRepository.WelcomePage;
import com.aventstack.extentreports.Status;


@Listeners(com.Demowebshop.GenericLib.CustomListner.class)
public class CheckoutAfterLogTest extends BaseTest{

	@Test(description  = "TC_Checkout_AfterLogin_02:- <br>Verify user is able to checkout after Login")
	public void loginAndaddToCartItem() throws InterruptedException, EncryptedDocumentException, IOException
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
		
		//String itemName = f.getDataFromProperty(PROPERTYPATH, "item");
		
		test.log(Status.INFO, "Step 5: Enter item name and click search");
		SearchPage sp = new SearchPage(driver);
		sp.searchItem("book");
		Thread.sleep(5);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/search?q=book");
		test.log(Status.INFO, "Step 6: Books Search Pass");
		
		test.log(Status.INFO, "Step 7: Add to cart button clicked");
		sp.addToCart();
		
		Assert.assertEquals(sp.cartQuantity(), true);
		test.log(Status.INFO, "Step 8:" + " Add to cart Pass - 1 item found in cart");
		
		test.log(Status.INFO, "Step 9:" + " Add to cart Link clicked");
		sp.clickCartLink();
		
		test.log(Status.INFO, "Step 10:" + " Checkout button clicked");
		sp.doCheckout();
		Thread.sleep(6);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/onepagecheckout");
		test.log(Status.INFO, "Step 11:" + " User is redirected to Billing details in order to checkout");
	}
	
}
