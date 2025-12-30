package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class appointmentBookingpage extends BasePage
{

	@FindBy(xpath="//div[@class='u-spacer--vertical c-patient-list__container']/child::div[2]") WebElement forSomeone;
	@FindBy(css="input[placeholder=\"Enter Patient's Full Name\"]") WebElement patientName;
	@FindBy(css="input[placeholder=\"Enter Patient's Mobile Number\"]") WebElement patientNumber;
	@FindBy(css="button[class= 'c-btn--dark ']") WebElement submit;
	@FindBy(xpath = "//h1[@class='u-jumbo-font u-spacer--large-bottom']/child::span") WebElement confirmation;
	@FindBy(tagName = "button") WebElement verify;
	
	public appointmentBookingpage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}
	
	
//------------------------------------For testcase 5-----------------------------------
	public void clickOnForSomeone() 
	{
		waitUntilVisibilityOfElement(forSomeone);
		forSomeone.click();
	}
	
	// fill the form by Excel reader.
	public void fillTheForm(String name, String num) 
	{
		patientName.sendKeys(name);
		javaxe.executeScript("window.scrollBy(0,400)");  
		patientNumber.sendKeys(num);
	}
	
	public void clickOnSubmit() 
	{
		javaxe.executeScript("arguments[0].click()", submit);
	}
	
	// if the verifying window appear.
	public void verifying() 
	{
		javaxe.executeScript("window.scrollBy(0,-200)");

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javaxe.executeScript("arguments[0].click()", verify);
	}
	
	// for asserting the text that will appear after submiting form
	public String appointmentConfirmation() 
	{
		waitUntilVisibilityOfElement(confirmation);
		String confirm = confirmation.getText();
		return confirm;                 //Appointmemt confirmed;
	}


}
