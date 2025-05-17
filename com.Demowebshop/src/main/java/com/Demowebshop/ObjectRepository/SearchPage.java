package com.Demowebshop.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTextbox;
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@value='Add to cart'][1]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	WebElement cartLink;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement checkboxTOS;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//span[text()='(1)']")
	WebElement cartQuantity;
	
	public void searchItem(String itemName)
	{
		searchTextbox.sendKeys(itemName);
		searchButton.click();
	}
	
	public void addToCart() throws InterruptedException
	{
		addToCartButton.click();
		Thread.sleep(10);
	}

	
	public boolean cartQuantity()
	{
		if(cartQuantity.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void clickCartLink()
	{
		cartLink.click();
		
	}
	 public void doCheckout()
	 {
		 checkboxTOS.click();
			checkoutButton.click();
	 }
}
