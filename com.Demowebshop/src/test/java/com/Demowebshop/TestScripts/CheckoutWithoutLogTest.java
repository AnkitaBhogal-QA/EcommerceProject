package com.Demowebshop.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.SearchPage;
import com.aventstack.extentreports.Status;

@Listeners(com.Demowebshop.GenericLib.CustomListner.class)
public class CheckoutWithoutLogTest extends BaseTest{

	@Test(description  = "TC_Checkout_WithoutLogin_01:- <br>Verify user is redirected to Login page when trying to checkout without login")
	public void checkoutWithoutLogin() throws InterruptedException
	{
		test.log(Status.INFO, "Step 1: Enter item name and click search");
		SearchPage sp = new SearchPage(driver);
		sp.searchItem("book");
		Thread.sleep(5);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/search?q=book");
		test.log(Status.INFO, "Step 2: Books Search Pass");
		
		test.log(Status.INFO, "Step 3: Add to cart button clicked");
		sp.addToCart();
		
		Assert.assertEquals(sp.cartQuantity(), true);
		test.log(Status.INFO, "Step 4:" + " Add to cart Pass - 1 item found in cart");
		
		test.log(Status.INFO, "Step 5:" + " Add to cart Link clicked");
		sp.clickCartLink();
		
		test.log(Status.INFO, "Step 6:" + " Checkout button clicked");
		sp.doCheckout();
		Thread.sleep(6);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart");
		test.log(Status.INFO, "Step 7:" + " User is redirected to Login page before checkout");
		
	}
	
	
}
