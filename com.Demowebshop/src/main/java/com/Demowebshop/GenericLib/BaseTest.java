package com.Demowebshop.GenericLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class BaseTest implements IAutoConstant  {
	public FileUtility f = new FileUtility();
	public BrowserUtility d = new BrowserUtility();
	public ExcelUtility e = new ExcelUtility();
	public static WebDriver driver;

	@BeforeSuite
	public void toConnectServer() {
		System.out.println("==server connected successfully==");
	}

	@BeforeTest
	public void toConnectDatabase() {
		System.out.println("==database connected successfully");
	}

	/*
	 * this method will take care of launching the browser and application
	 */

	@BeforeClass
	public void setUp() throws IOException {
		String browser = f.getDataFromProperty(PROPERTYPATH, "browser");
		String url = f.getDataFromProperty(PROPERTYPATH, "url");
		System.out.println("==launching " + browser + " browser==");
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("==invalid browser==", true);
		d.maximizeWindow(driver);
		d.implicitWait(driver, 20);
		d.launchApplication(driver, url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("==browser closed successfully==");
	}

	@AfterTest
	public void toCloseDatabase() {
		System.out.println("==database closed successfully");
	}

	@AfterSuite
	public void toCloseServer() {
		System.out.println("==server close successfully==");
	}
	
	
}
