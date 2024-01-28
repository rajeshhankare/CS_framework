package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	// create object of webDriver

	WebDriver ldriver;

	// create constructor

	public PaymentMethod (WebDriver rdriver)
	{
		ldriver = rdriver;

		//create page factory method'
		PageFactory.initElements(rdriver, this);
	}
      @FindBy(xpath="//a[@title='Pay by bank wire']")
      WebElement paybyBank;
      
	
      @FindBy(xpath="//a[@title='Pay by check'")
      WebElement paybyCheck;
      
	public void clickOnByBank()
	{
		paybyBank.click();
	}
	
	public void clickOnByCheck()
	{
		paybyCheck.click();
	}
	
}
