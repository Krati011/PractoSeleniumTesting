package com.pages;
// Practo basepage

import java.awt.AWTException;
import java.awt.Robot;
//import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import com.parameters.propertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.practoPropertyReader;

public class BasePage {
	
// give the name to each class
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Robot robot;
	JavascriptExecutor javaxe;
	practoPropertyReader reader;
	
//	make a variable for parentHandle
	String parentHandle;
	
	public BasePage(WebDriver driver) 
	{
		this.driver = driver;
		action = new Actions(driver);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		this.reader = new practoPropertyReader();
		javaxe=(JavascriptExecutor) driver;               //typecasting driver in js

		PageFactory.initElements(driver, this);
	}

	
	public void getwindow() 
	{
//		we perform function on the parentHandle
		parentHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) { //loop until each handle is present windows are store in set.
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);         //switch the window handle
                break;          
		
            }
     
		}
			
	}
	
	public void waitUntilElementToBeClickable(WebElement element) 
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	public void waitUntilVisibilityOfElement(WebElement element) 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		 
		
	}
	
	
}

