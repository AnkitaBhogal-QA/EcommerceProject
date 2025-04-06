package com.Demowebshop.GenericLib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 
 * @author Ankita
 *
 */

public class BrowserUtility {
	
	
	/*
	 * This method will launch the URL
	 */

	public void launchApplication(WebDriver driver, String url) {
		driver.get(url);
		
	}
	
	/*
	 * This method will maximize the browser window
	 */

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	/*
	 * This method will help to implement implicit wait
	 */

	public void implicitWait(WebDriver driver, int seconds) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

}
