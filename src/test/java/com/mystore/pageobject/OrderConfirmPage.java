package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage {

	// create object of webDriver

		WebDriver ldriver;

		// create constructor

		public OrderConfirmPage (WebDriver rdriver)
		{
			ldriver = rdriver;

			//create page factory method'
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(xpath="//span[normalize-space()='I confirm my order']")
		WebElement ConfirmOrder;
		
		
		//alert successmassage
		@FindBy(xpath="//p[@class='alert alert-success']")
		WebElement successMassage;
		
		@FindBy(xpath="//a[@title='Log me out']")
		WebElement FinalSighOut;
		
		public void ClickOnConfirmOrder()
		{
			ConfirmOrder.click();
		}
		
		public String getSuccessMassageAlert()
		{
			return( successMassage.getText());
		}
		
		public void ClickOnFinalSignOut()
		{
			FinalSighOut.click();
		}
}
