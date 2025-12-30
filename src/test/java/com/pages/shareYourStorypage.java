package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shareYourStorypage extends BasePage
{

	public shareYourStorypage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//span[text()='Submit']") WebElement submit;
	@FindBy(xpath="//span[normalize-space()='How long did you wait to be seen by the doctor?']/parent::div/child::div/child::span")WebElement errorMessage;
	
	public void scrollToSubmit() 
	{
		javaxe.executeScript("window.scrollBy(0,1000)");
	}
	
	public void clickOnSubmit() 
	{
		submit.click();
	}
	
	public String errorMessage() 
	{
		System.out.println(errorMessage.getText());
		return errorMessage.getText();	
	}
	

}
