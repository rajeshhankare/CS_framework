package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.OrderSummeryPage;
import com.mystore.pageobject.ProcuctPage;
import com.mystore.pageobject.RegisterUserAccount;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;

public class TC_ProductPageTest extends BaseClass{
	@Test
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
		//sign in

		//System.out.println("login execution started");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();

		myAccount myaccount = new myAccount(driver);
		myaccount.registeremailAddress("raj1234@gmail.com");

		myaccount.registerUserPassword("raj@123");

		myaccount.registerSingin();

		System.out.println("log in successful");


		//product search
		RegisterUserAccount productpg = new RegisterUserAccount(driver);

		productpg.EnterDataInSearchBox(searchKey);
		productpg.ClikonButton();
        driver.manage().window().maximize();
		//get name of serch product
		captureScreenShot(driver, "test product tshirt");
		//productpg.clickOnsignOut();
	}
   @Test()
	public void VerifyBuyProduct()
	{//serrch product page object
	   System.out.println("ok 1");
	   
		SearchResultPage searchpg = new SearchResultPage(driver);
		System.out.println("ok 2");
		//searchpg.mouseover();
		System.out.println("ok 3");
		searchpg.ClickOnMore();
		System.out.println("ok 4");
		
	//product page object
		ProcuctPage productpg = new ProcuctPage(driver);
		productpg.setQuantity("2");
		productpg.setSize("M");
		productpg.ClickonAddtoCart();
		productpg.clikOnProductToCheckOut();
		
	//ordersummery page object
		OrderSummeryPage orderpg =new OrderSummeryPage(driver);
		
		orderpg.clickOnProceedTocheckOut();
    
		//my address page object
		
		System.out.println("Thank you");
		
		
		
		
		
	}











}
