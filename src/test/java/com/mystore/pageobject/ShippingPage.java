package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

	// create object of webDriver

			WebDriver ldriver;

			// create constructor

			public ShippingPage (WebDriver rdriver)
			{
				ldriver = rdriver;

				//create page factory method'
				PageFactory.initElements(rdriver, this);
			}

	   @FindBy(name="processAddress")
	   WebElement CheckOutButton;
	
	   
	   public void clickonCheckOut()
	   {
		   CheckOutButton.click();
	   }
	
}
