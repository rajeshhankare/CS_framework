package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummeryPage {

	// create object of webDriver

		WebDriver ldriver;

		// create constructor

		public OrderSummeryPage (WebDriver rdriver)
		{
			ldriver = rdriver;

			//create page factory method'
			PageFactory.initElements(rdriver, this);
		}

	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;
	
	
	public void clickOnProceedTocheckOut()
	{
		proceed.click();
	}
	
	
}
