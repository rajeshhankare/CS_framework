package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.RegisterUserAccount;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageDataDrivenTesting extends BaseClass {

	@Test(enabled = false)
	public void verifyRegistrationAndLogin()
	{

		// indexPage class object

		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		System.out.println("click on singnin button");


		//myAccount class object

		myAccount myaccount = new myAccount(driver);
		myaccount.entercreateEmailAddress("raj12345@gmail.com");
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
	
	
	
	@Test(dataProvider="LoginDataProvider")
	public void verifyLogin(String userEmail,String userPassword,String expectedUserName) throws IOException
	{
		System.out.println("step 1");
		// indexPage class object
		System.out.println("login execution started");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		System.out.println("click on singnin button");


		//myAccount class object

		myAccount myaccount = new myAccount(driver);
		myaccount.registeremailAddress(userEmail);
		
		myaccount.registerUserPassword(userPassword);
		
		myaccount.registerSingin();
		
		System.out.println("log in successful");

		
		//verifylogeduser
		RegisterUserAccount registerUser = new RegisterUserAccount(driver);
		String UserName = registerUser.getUsername();
		if(UserName.equals("expectedUserName"))
		{
			System.out.println("user is verified");
			
			Assert.assertTrue(true);
			registerUser.clickOnsignOut();
			System.out.println("signout successful");
			
		}

		else
		{
			System.out.println("user is not verified");
			captureScreenShot(driver, "verify login failed");
			Assert.assertTrue(false);

		}
		System.out.println("user login verified");
		
	}
	
	
    @DataProvider(name= "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		  //System.out.println(System.getProperty("C:\Users\Rajesh\eclipse-workspace\TEstNG\Test Data\MystoreV1.xlsx"));
		  String fileName = System.getProperty("C:\\Users\\Rajesh\\eclipse-workspace\\TEstNG\\Test Data\\MystoreV1.xlsx");
		  
		  
		  int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
		  int ttlColumns = ReadExcelFile.getColCount(fileName,"LoginData");
		  
		  String data[][]= new String[ttlRows-1][ttlColumns];
		  
		  for(int i=1;i<ttlRows;i++)
		  {
			  for (int j=0;j<ttlColumns;j++)
			  {
				  data[i-1][j]= ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			  }
		  }
		  
		  return data;
		  
	}

}
