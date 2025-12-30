package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class practoHomepage extends BasePage{
	
	
	
	@FindBy(xpath = ("//a[text()='Login / Signup']")) WebElement loginButton;
	@FindBy(id = ("username")) WebElement number;
	@FindBy(id = ("password")) WebElement password;
	@FindBy(id = ("login")) WebElement login;
	@FindBy(linkText =("Search for hospitals")) WebElement Searchforhospital;
	
	public practoHomepage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		
	}
	
///////////for login in the website through properties
	public void login() 
	{
		loginButton.click();
		waitUntilVisibilityOfElement(number);
		String num = reader.get("number.value");
		String pass = reader.get("password.value");
		number.sendKeys(num);
		password.sendKeys(pass);
		login.click();	
	}
	
//------to scroll down to the footer.
	public void scrolldown() {
	      javaxe.executeScript("window.scrollBy(0,2500)");
		
	}
	
	
//-------to click on search for hospital in the 'for patient'' module.
	public void clickSearForHospital() {
		waitUntilVisibilityOfElement(Searchforhospital);
		Searchforhospital.click();
		
	}	

}
