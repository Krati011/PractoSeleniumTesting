package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class doctorsListpage extends BasePage
{

	
	public doctorsListpage(WebDriver driver) 
	{
		super(driver);
		this.driver= driver;
	}
	
	
	@FindBy(css="div[data-qa-id='years_of_experience_section']") WebElement clickOnExperience; 
	@FindBy(css="li[aria-label='10+ Years of experience']") WebElement selectExperience;
	@FindBy(xpath = "//div[@data-qa-id='doctor_experience']/child::div") List<WebElement> doctorExperience;
	@FindBy(xpath = "//div[@class=\"c-filter__box u-pos-rel c-dropdown\"]/child::span/child::span[normalize-space()='10+ Years of experience']") WebElement filteredExperience;
	@FindBy(linkText = "Dr. Adarsh S Naik" ) WebElement clickDoctor1;
	@FindBy(linkText = "Dr. Puttaswamy P" ) WebElement clickDoctor2;
	
//--------------------------------------------For Testcase 4----------------------------------
	public void experienceFilter() 
	{
		waitUntilElementToBeClickable(clickOnExperience);
		clickOnExperience.click();	
	}
	
	
	public void clickexperience() 
	{
		String parent= driver.getCurrentUrl();     //to get the current URL and store it in parent
		selectExperience.click();

		while(true) {
			if(!(parent.equals(driver.getCurrentUrl()))) {  //to check if the URL is changing. When it change then move forward
				break;
			}
		}
	}
	
	public void listScroll() 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	      javaxe.executeScript("window.scrollBy(0,200)");
	}
	

	public String filteredExperience() 
	{
		String filterExp = filteredExperience.getText();            
		String filterValue = filterExp.replaceAll("\\D+", "");      //replace all non digit character with empty string using regex
		return filterValue;                                         //10
		
	}
	
	public List<Integer> doctorExperience() 
	{
		List<Integer> newList = new ArrayList<Integer>();
		for (WebElement i:doctorExperience ) {
			String j = i.getText().replaceAll("\\D+", "");      //replace all non digit character with empty string
			int number = Integer.parseInt(j);                   //convert string to integer
			newList.add(number);
			
			
		}
		System.out.println(newList);                            // list of all the doctors experience in the list
		return newList;                                         //[28, 18, 41, 17, 16, 18, 26, 16, 25, 25]

	}
	
//----------------------------------For Testcase 5---------------------------------------
	public void SelectDoctor1() 
	{
//	      javaxe.executeScript("window.scrollBy(0,200)");
		waitUntilElementToBeClickable(clickDoctor1);
		clickDoctor1.click();
	}
	
//------------------------------------For test case 6-----------------------------------------
	
	public void SelectDoctor2() 
	{
	      javaxe.executeScript("window.scrollBy(0,200)");
		waitUntilElementToBeClickable(clickDoctor2);
		clickDoctor2.click();
	}
}
