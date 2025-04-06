package com.Demowebshop.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Demowebshop.GenericLib.BaseTest;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="Email")
	WebElement emailTextfield;
	
	@FindBy(id="Password")
	WebElement passwordTextfield;
	
	@FindBy(xpath = "//input[@class = 'button-1 login-button']")
	WebElement loginButton;
	
	public void loginPage(String email, String password) {
		emailTextfield.sendKeys(email);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	
	}
	
	
	
	
	
	

}
