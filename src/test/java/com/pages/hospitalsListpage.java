package com.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.parameters.practoPropertyReader;

public class hospitalsListpage extends BasePage{
	
	practoPropertyReader reader;
	
	public hospitalsListpage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		reader  = new practoPropertyReader();
		
	}
	
	
	@FindBy(xpath =("//input[@placeholder='Search location']")) WebElement locationInput;
	@FindBy(xpath = ("//div[text()='Bangalore']")) WebElement location;
	@FindBy(xpath=("//h2[@class='line-1' and @title='Manipal Hospitals']")) WebElement hospital;
	@FindBy(css= ("input[placeholder='Search doctors, clinics, hospitals, etc.']")) WebElement inputSepcialty;


	
///////// To change the input location.
	public void inputLocation()  
	{
		waitUntilVisibilityOfElement(locationInput);
		locationInput.clear();
		locationInput.sendKeys(reader.get("location.value"));
		waitUntilVisibilityOfElement(location);
		location.click();
	}

////////To scrolldown to see the hospital name.
	public void scrollInHospitalList() 
	{
		waitUntilVisibilityOfElement(hospital);
		JavascriptExecutor javaxe = (JavascriptExecutor) driver;
	    javaxe.executeScript("window.scrollBy(0,400)");
	}
	
////////To select the hospital name we click on the name
	public void selectHospital() 
	{
		hospital.click();
		System.out.println(hospital.getText());
		
	}
	
/////////To return the string so that we can use that in assert.
	public String hospitalNameInList() 
	{
	        return hospital.getText();
	        
	 }
	
//-------------------for test case 4--------------------------
	public void inputSpecialty() throws InterruptedException {

		inputSepcialty.clear();
		inputSepcialty.sendKeys("General Physician");
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		
	}

	
	
	
	
	
	

}
