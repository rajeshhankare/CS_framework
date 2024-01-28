package com.mystore.utilities;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class BasicExtendsReports {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;


	@BeforeTest
	public void startReport()
	{
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add envoriment details

		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user", "rajesh");
		reports.setSystemInfo("Browser", "chrome");

		//configuration for change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE,MMM dd,yyyy,hh:mm a '(zzz')'");

	}
	@Test
	public void LaunchBrowser()
	{
		//create test
		test=reports.createTest("Launch Browser and open url");
		Assert.assertTrue(true);
	}

	@Test
	public void VerifyTitle()
	{
		//create test
		test=reports.createTest("verify title");
		Assert.assertTrue(false);
	}
	@Test
	public void VerifyLogo()
	{
		//create test
		test=reports.createTest("verify logo");
		Assert.assertTrue(true);
	}

	@Test
	public void VeriEmail()
	{
		//create test
		test=reports.createTest("verify Email");
		throw  new SkipException("skiping this test method with exception");
	}
	@AfterMethod
	public void getTestRest(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "Fail", ExtentColor.RED));
		}
		else  if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "pass", ExtentColor.GREEN));
		}
		if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "skip", ExtentColor.PINK));
		}
	}
    @AfterTest
	public void tearDown()
	{
		reports.flush();
	}
	
	
}
