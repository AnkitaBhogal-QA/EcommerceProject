package com.Demowebshop.GenericLib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class BrowserUtility {

	public void launchApplication(WebDriver driver, String url) {
		driver.get(url);
		
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}

	public void implicitWait(WebDriver driver, int seconds) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

}
