package com.Demowebshop.GenericLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class CustomListner implements ITestListener{
	
	
	ExtentReports extent;
    public ExtentTest test;
    
	public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Author", "Ankita");
        extent.setSystemInfo("Environment", "QA");
    }

	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		  Object testClassInstance = result.getInstance();
		    if (testClassInstance instanceof BaseTest) {
		        ((BaseTest) testClassInstance).test = test;}
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

		String methodName = result.getMethod().getMethodName();
	    WebDriver driver = BaseTest.driver; // Assuming you set driver here
	    
	    JavaUtility j = new JavaUtility();
	    String screenshotPath;
	    try {
	        screenshotPath = j.takeScreenshot(driver, methodName);
	        test.addScreenCaptureFromPath(screenshotPath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	}
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	}

}
