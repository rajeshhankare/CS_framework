package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	// create object of webDriver
	
			WebDriver ldriver;
			
			// create constructor
			 
			public SearchResultPage (WebDriver rdriver)
			{
				ldriver = rdriver;
				
				//create page factory method'
				PageFactory.initElements(rdriver, this);
			}
		
	//search result text
			@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']")
             WebElement SearchResultProduct;
			
	         @FindBy(xpath="//imag[@title='Faded Short Sleeve T-shirts']")
	         WebElement MouseoverBox;
			
			@FindBy(xpath="//span[normalize-space()='More']")
		
			WebElement MoreButton;
	
        public String getSearchProductResult() 
        {
        	return (SearchResultProduct.getText());
        	
        }
          
        public void mouseover()
        {
        	Actions act = new Actions(ldriver);
        	act.moveToElement(MouseoverBox).perform();
        }
        public void ClickOnMore()
        {
        	
        
        	MoreButton.click();
        }
        
}
