package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccount {

	// create object of webDriver
		
		WebDriver ldriver;
		
		// create constructor
		 
		public  RegisterUserAccount(WebDriver rdriver)
		{
			ldriver = rdriver;
			
			//create page factory method'
			PageFactory.initElements(rdriver, this);
		}
	
	//identify element on verify page
		
		 @FindBy(xpath="//span[normalize-space()='Rajesh hankare']")
	     WebElement userName;
		 
		 @FindBy(linkText = "Sign Out")
		 WebElement signOut;
		 
		 //pacle order
		 //1. search button
		 @FindBy(id="search_query_top")
		 WebElement SearchBox;
		 
		 @FindBy(name= "submit_search")
		 WebElement searchBoxButton;
		 

		 
		 // action on sign out
		public void clickOnsignOut()
		{
			signOut.click();
		}
		
	
	// method to perform action
		 
		 public String getUsername()
		 {
			 String text =userName.getText();
			 return text;
		 }
	
		//action enter serach text and click on search button;
		 
		 public void EnterDataInSearchBox(String searchkey)
		 {
			 SearchBox.sendKeys(searchkey);
		 }
		 
		 //clickonsearchButton
		 
		 public void ClikonButton()
		 {
			 searchBoxButton.click();
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
}
