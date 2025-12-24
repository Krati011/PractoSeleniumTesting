package com.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class hospitalDetailpage extends BasePage {
	
	
	public hospitalDetailpage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		
	}
	
	
	
	@FindBy (xpath=("//span[@data-qa-id='hospital_name']")) WebElement hospitalName;
	@FindBy(xpath = ("//div[@class='pure-g g-card']/div[3]/div/div/button/i")) WebElement callNowButton;
	@FindBy (css = ("div[class='u-spacer--bottom-thin c-vn__info']")) WebElement phoneNumber;
	@FindBy(css=("input[placeholder='Enter your mobile number']")) WebElement getAppLink;
	@FindBy(css = ("button[class='u-fill--light-blue u-smallest-font u-round-corner--small u-color--white u-cushion--horizontal u-bold u-spacer--top u-border--none c-sidebar__app-submit']")) WebElement clickSend;
	@FindBy(css = ("span[class='u-d-inlineblock u-xxx-small-font-size u-valign-middle u-spacer--right-thin']")) WebElement successfullmessage;
	

//-----------------------for first test case-----------------------------	
	
	public String hospitalNameFromDetail() 
	{
		waitUntilVisibilityOfElement(hospitalName);
		String hName = hospitalName.getText();
		System.out.println(hName);
		return hName;
	}
		
//------------------------for second test case-----------------------------
	
	public void clickCallNow() 
	{
		waitUntilElementToBeClickable(callNowButton);
		String text1 = callNowButton.getText();
		System.out.println(text1);
		action.moveToElement(callNowButton).click().build().perform();		
		
	}
	
	public void scrollALittle() 
	{
		JavascriptExecutor javaxe = (JavascriptExecutor) driver;
	      javaxe.executeScript("window.scrollBy(0,200)");
	}
	
	public String getPhoneNumber() 
	{
		waitUntilVisibilityOfElement(phoneNumber);
		String Number = phoneNumber.getText();
		System.out.println(Number);
		return Number;
		
	}
	
//-------------------------for third test case------------------------------
	
	public void getAppLink() 
	{
		getAppLink.click();
		getAppLink.sendKeys("9528777705");
		
	}
	
	public void clickSend() 
	{
		waitUntilElementToBeClickable(clickSend);
		clickSend.click();
	}
	
	public String confirmation() {
		String message = successfullmessage.getText();
		return message;
		
	}
	
}
