package com.Demowebshop.GenericLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomListner implements ITestListener {

	ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
		spark.config().setTheme(Theme.STANDARD); // or Theme.DARK
		spark.config().setReportName("Demo Webshop Test Report");
		spark.config().setDocumentTitle("QA Automation Report");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Author", "Ankita");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		
	}

	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getDescription();
		if (testName == null || testName.isEmpty()) {
			testName = result.getMethod().getMethodName(); // fallback
		}
		test = extent.createTest(testName);

		// String method = result.getMethod().getMethodName().toLowerCase();
		String clazz = result.getTestClass().getRealClass().getSimpleName().toLowerCase();

		if (clazz.contains("login")) {
			test.assignCategory("Login");
		} else if (clazz.contains("checkout")) {
			test.assignCategory("Checkout");
		} else if (clazz.contains("search")) {
			test.assignCategory("Search");
		} else if (clazz.contains("register")) {
			test.assignCategory("Registration");
		}

		Object testClassInstance = result.getInstance();
		if (testClassInstance instanceof BaseTest) {
			((BaseTest) testClassInstance).test = test;
		}
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
