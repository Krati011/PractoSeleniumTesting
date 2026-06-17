package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class doctorDetailpage extends BasePage{

	public doctorDetailpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	@FindBy(css= "button[data-qa-id='book_button']") WebElement bookappointmentButton;
	@FindBy(xpath = "//div[@class='pure-u-1-3 c-day-label c-day-label--selected']/child::div[2]/child::span") WebElement dateSelector;
	@FindBy(xpath="//div[@class='c-day-session__slot ']/child::span[text()='05:45 PM']") WebElement slotStatus;
	@FindBy(xpath = "//i[@class='icon-ic_next_cheveron c-slots-header__next-btn ']")WebElement nextArrow;
	@FindBy(partialLinkText = "Share") WebElement shareYourStory;



//-------------------------------------For Fifth Testcase---------------------------------
	public void clickOnBookAppointment() 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	    javaxe.executeScript("window.scrollBy(0,500)");
	    
	    waitUntilElementToBeClickable(bookappointmentButton);
	    bookappointmentButton.click();
	}
	
	public void selectTimeAndDate() 
	{
		String date = dateSelector.getText();   // no slots available, digit slots available
		System.out.println(date);
		
		if (date.equals("No Slots Available")) 
		{
			nextArrow.click();                 // if no slots are available then it will click next arrow to move on next available date
			slotStatus.click();                // it will select the slot on the next available date.
		}
		else 
		{
			waitUntilElementToBeClickable(slotStatus);
			slotStatus.click();                // if slots are available today then select a slot
		}
		
	}
	
	
	
//--------------------------------------for sixth testcase------------------------------
	
	public void clickOnShareStory() 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));     //waiting for the page to load through static wait
		
		javaxe.executeScript("window.scrollBy(0,100)");
		
		waitUntilElementToBeClickable(shareYourStory);                        //explicit wait
		shareYourStory.click();
		
	}
}
