package com.Demowebshop.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "gender-male")
	private WebElement maleRadioButton;
	
	@FindBy(id = "gender-female")
	private WebElement femaleRadioButton;
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextField;
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextField;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement regSuccessMessage;
	
	/*
	 * this method will perform registration
	 */
	public void toRegister(String firstName,String lastName,String email,String password)
	{
		maleRadioButton.click();
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(password);
		registerButton.click();
	}


	public String getSuccessMessage() {
		System.out.println(regSuccessMessage.getText());
		return regSuccessMessage.getText();
	}
	
}
