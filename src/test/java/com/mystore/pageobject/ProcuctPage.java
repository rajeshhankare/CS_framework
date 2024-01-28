package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProcuctPage {
	// create object of webDriver

	WebDriver ldriver;

	// create constructor

	public ProcuctPage (WebDriver rdriver)
	{
		ldriver = rdriver;

		//create page factory method'
		PageFactory.initElements(rdriver, this);
	}
	//find webElement
	@FindBy(id="quantity_wanted")
	WebElement 	quantity;

	@FindBy(id="group_1")
	WebElement size;


	@FindBy(name="Submit")
	WebElement addTocart;

	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;

	//find action on above element

	public void setQuantity(String qty)	
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}

	//select size by dropdown

	public void setSize(String sizeType)
	{
		Select sizeSelect = new Select(size);
		sizeSelect.selectByVisibleText(sizeType);

	}

	//add to cart

	public void ClickonAddtoCart()
	{
		addTocart.click();
	}

	//poeceed to checkout

	public void clikOnProductToCheckOut()
	{
		proceed.click();
	}
}
