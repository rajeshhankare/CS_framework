package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//to raad the value from readconfig class cread object of readconfign class

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseurl();
	String browser = readConfig.getBrowser();


	public static WebDriver driver;

	@BeforeClass
	public void setup()
	{
		//String browser = "chrome";

		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;


		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//loggermethod
		//open url
		driver.get(url);
		System.out.println("url open successfully");

	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}


	//generic method to capture screenshots

	public void captureScreenShot(WebDriver driver , String testName) throws IOException
	{
		//step1 conevert webdriver objedct to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		// step2 call getscreenshotmentho to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir")+ "//ScrrenShots//"+ testName + ".png");

		//step3 

		FileUtils.copyFile(src, dest);

	}






}
