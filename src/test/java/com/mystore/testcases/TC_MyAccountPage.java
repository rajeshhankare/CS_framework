package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.RegisterUserAccount;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;

import junit.framework.Assert;

public class TC_MyAccountPage extends BaseClass {

	@Test(enabled= false)
	public void verifyRegistrationAndLogin()
	{

		// indexPage class object

		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		System.out.println("click on singnin button");


		//myAccount class object

		myAccount myaccount = new myAccount(driver);
		myaccount.entercreateEmailAddress("raj1234@gmail.com");
		myaccount.clickSubmitCreate();
		System.out.println("enter emil id and click on creat account button");


		//AccountCreation
		AccountCreation accountCreationpg = new AccountCreation(driver);

		accountCreationpg.selectMr();
		accountCreationpg.enterFirstName("Rajesh");
		accountCreationpg.enterlastName("hankare");
		accountCreationpg.enterPassword("raj@123");
		accountCreationpg.clickNewsetler();
		accountCreationpg.clickonRegister();
		System.out.println("register successfully....");

		//RegisterUserAccount
		RegisterUserAccount registerUser = new RegisterUserAccount(driver);
		String UserName = registerUser.getUsername();

		Assert.assertEquals("Rajesh hankare", UserName);
		System.out.println("verify username successfully");
	}
	@Test
	public void verifyLogin() throws IOException
	{
		// indexPage class object
		//System.out.println("login execution started");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		System.out.println("click on singnin button");


		//myAccount class object

		myAccount myaccount = new myAccount(driver);
		myaccount.registeremailAddress("raj1234@gmail.com");
		
		myaccount.registerUserPassword("raj@123");
		
		myaccount.registerSingin();
		
		System.out.println("log in successful");

		
		//verifylogeduser
		RegisterUserAccount registerUser = new RegisterUserAccount(driver);
		String UserName = registerUser.getUsername();
		if(UserName.equals("Rajesh hankare"))
		{
			System.out.println("user is verified");
			
			Assert.assertTrue(true);
		}

		else
		{
			System.out.println("user is not verified");
			captureScreenShot(driver, "verify login failed");
			Assert.assertTrue(false);

		}
		System.out.println("user login verified");
	}


}
