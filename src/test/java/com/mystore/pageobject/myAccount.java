package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	// create object of webDriver

	WebDriver ldriver;

	// create constructor

	public myAccount(WebDriver rdriver)
	{
		ldriver = rdriver;


		//create page factory method'
		PageFactory.initElements(rdriver, this);

	}

	// identify webElement on page

	@FindBy(id = "email_create")
	WebElement createEmailId;

	//identify webelement on page
	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;

	//find webElement on page
	@FindBy(id= "email")
	WebElement RegisterUserEmail;

	@FindBy(id ="passwd" )
	WebElement RegisterUserPassword;

	@FindBy(id = "SubmitLogin")
	WebElement RegisterUserSignin;







	//identify action on webElement

	public void entercreateEmailAddress(String emailAdd)
	{
		createEmailId.sendKeys(emailAdd);
	}

	public void clickSubmitCreate()
	{
		SubmitCreate.click();

	}

	// metnod to crest acction

	public void registeremailAddress(String emailAdd)
	{
		RegisterUserEmail.sendKeys(emailAdd);
	}


	public void registerUserPassword(String password)
	{
		RegisterUserPassword.sendKeys(password);
	}

	public void registerSingin()
	{
		RegisterUserSignin.click();
	}








}
