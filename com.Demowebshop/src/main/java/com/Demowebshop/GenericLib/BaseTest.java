package com.Demowebshop.GenericLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

/**
 * 
 * @author Ankita
 *
 */


public class BaseTest implements IAutoConstant  
{
	public FileUtility f = new FileUtility();
	public BrowserUtility d = new BrowserUtility();
	public ExcelUtility e = new ExcelUtility();
	public JavaUtility j = new JavaUtility();
	public CustomListner c = new CustomListner();
	
	public ExtentTest test;
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
	 * this method will launch the browser mentioned in CommonData.properties file
	 */

	@BeforeClass
	public void setUp() throws IOException {
		String browser = f.getDataFromProperty(PROPERTYPATH, "browser");
		String url = f.getDataFromProperty(PROPERTYPATH, "url");
		System.out.println("==launching " + browser + " browser==");
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("chromeincognito"))
		{
			ChromeOptions c = new ChromeOptions();
			c.addArguments("incognito");
			driver = new ChromeDriver(c);
		}
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("==invalid browser==");
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
