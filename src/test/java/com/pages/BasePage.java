package com.pages;
// Practo basepage



import java.awt.AWTException;
import java.awt.Robot;
//import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
//import com.parameters.propertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
//	webdriver class ko hum driver name dia similarly for wait
	WebDriver driver;
	WebDriverWait wait;
	
//	parenthandle ka variable banaya
	String parentHandle;
	Actions action;
	Robot robot;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PageFactory.initElements(driver, this);
	}

	
	public void getwindow() {
//		variable ko action perform kia
		parentHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;          
		
            }
     
		}
			
	}
	
	public void waitUntilElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	public void waitUntilVisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		 
		
	}
	
	
}

