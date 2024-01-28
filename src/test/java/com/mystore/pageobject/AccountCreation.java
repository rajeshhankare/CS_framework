package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {

	// create object of webDriver
	
		WebDriver ldriver;
		
		// create constructor
		 
		public AccountCreation(WebDriver rdriver)
		{
			ldriver = rdriver;
			
			//create page factory method'
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelement
		@FindBy(id= "id_gender1")   //mr
		WebElement gender;
		
		@FindBy(id="customer_firstname")
		WebElement CustFirstName;
		
		@FindBy(id="customer_lastname")
		WebElement CustlastName;
		
		@FindBy(id="passwd")
		WebElement password;
		
		
		//check box
		@FindBy(id="newsletter")
		WebElement checkBox;
		
		//registier button
		@FindBy(id="submitAccount")
		WebElement SubmitButton;
		
		//perform action on element
		
		public void selectMr()
		{
			gender.click();
		}
		
		//firstname
		
		public void enterFirstName(String Fname)
		{
			CustFirstName.sendKeys(Fname);
		}
		
		//lastname
		public void enterlastName(String Lname)
		{
			CustlastName.sendKeys(Lname);
		}
		
		//password
		public void enterPassword(String passname)
		{
			password.sendKeys(passname);
		}
		
		//checkbox
		
		public void clickNewsetler()
		{
			checkBox.click();
		}
		
		//clickonRegister
		public void clickonRegister()
		{
			SubmitButton.click();
		}
		
		
		
		
		
		
		
		
		
}
