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
	
	public void searchItem(String itemName)
	{
		searchTextbox.sendKeys(itemName);
		searchButton.click();
	}
	

}
