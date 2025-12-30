package com.pages;


import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.parameters.practoPropertyReader;

public class hospitalsListpage extends BasePage{
	
	
	public hospitalsListpage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
	}
	
	
	@FindBy(xpath =("//input[@placeholder='Search location']")) WebElement locationInput;
	@FindBy(xpath = ("//div[text()='Bangalore']")) WebElement location;
	@FindBy(xpath=("//h2[@class='line-1' and @title='Manipal Hospitals']")) WebElement hospital1;
	@FindBy(linkText = "Koshys Hospital") WebElement hospital2;
	@FindBy(partialLinkText = "Manipal Hospital Varthur") WebElement hospital3;
	@FindBy(css= ("input[placeholder='Search doctors, clinics, hospitals, etc.']")) WebElement inputSepcialty;
	@FindBy(xpath =("//div[@data-qa-id='omni-suggestion-main' and text()='Eye Hospital']"))WebElement specialty;

	
	
	public void inputLocation()  
	{
		waitUntilVisibilityOfElement(locationInput);
		locationInput.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_A);
    	robot.keyRelease(KeyEvent.VK_A);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
 
    	robot.keyPress(KeyEvent.VK_DELETE);
    	robot.keyRelease(KeyEvent.VK_DELETE);
 
		locationInput.sendKeys(reader.get("location.value"));   //Enter the location through property reader
		
		waitUntilVisibilityOfElement(location);
		String parent= driver.getCurrentUrl();     //to get the current URL and store it in parent
		location.click();
		
		//to let the URL load and move forward when it changes.
		while(true) {
			if(!(parent.equals(driver.getCurrentUrl()))) {  //to check if the URL is changing. When it change then move forward
				break;
			}
		}
		
	}

//------------------------------------------------for test case 1-----------------------------------
	
	public void scrollInHospitalList() 
	{
		waitUntilVisibilityOfElement(hospital1);
	    javaxe.executeScript("window.scrollBy(0,400)"); // scroll in front of hospital name.
	}
	

	public void selectHospital1() 
	{
		hospital1.click();
		System.out.println(hospital1.getText()); // click on the hospital name 
		
	}
	

	public String hospitalNameInList() 
	{
	        return hospital1.getText();  // returns the hospital name that is clicked
	        
	 }
	
//--------------------------------------------For testcase 2----------------------------------------------
	public void selectHospital2() 
	{
		hospital2.click();
		System.out.println(hospital2.getText()); // click on the hospital name 
		
	}
	
	
//	------------------------------------------For test case 3--------------------------------------------
	public void selectHospital3() 
	{
		hospital3.click();
		System.out.println(hospital3.getText()); // click on the hospital name 
		
	}
//--------------------------------------------For test case 4-----------------------------------------------
	public void inputSpecialty() 
	{
		waitUntilVisibilityOfElement(inputSepcialty);
		
		inputSepcialty.click();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_A);
    	robot.keyRelease(KeyEvent.VK_A);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
 
    	robot.keyPress(KeyEvent.VK_DELETE);
    	robot.keyRelease(KeyEvent.VK_DELETE);
    	
		inputSepcialty.sendKeys(reader.get("specialty.value")); // input the specialty through property reader.
	
		waitUntilElementToBeClickable(specialty);
		specialty.click();							  //click the specialty
	}
	
	
	
	
	
	
	
	

}
