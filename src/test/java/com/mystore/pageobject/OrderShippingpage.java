package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingpage {

	// create object of webDriver

				WebDriver ldriver;

				// create constructor

				public OrderShippingpage(WebDriver rdriver)
				{
					ldriver = rdriver;

					//create page factory method'
					PageFactory.initElements(rdriver, this);
				}
				
				  @FindBy(id="cgv")
				   WebElement ShippingCheckBox;
				


		   @FindBy(name="processCarrier")
		   WebElement ShippingCheckOut;
		
		   
		   public void clickonCheckBox()
		   {
			   ShippingCheckBox .click();
		   }

		   public void clickonShippingCheckout()
		   {
			   ShippingCheckOut .click();
		   } 
		   
		   
}
