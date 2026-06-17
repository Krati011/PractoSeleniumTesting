package com.setup;

// Practo basesteps
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.parameters.practoPropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseSteps
{
	public static WebDriver driver;
	public static EdgeOptions eoptions;
	public static ChromeOptions coptions;
	public static practoPropertyReader reader;
	
	public static WebDriver chromedriver()
	{
		WebDriverManager.chromedriver().setup();
		coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");
		coptions.addArguments("Incognito");
//		coptions.addArguments("headless");
		coptions.addArguments("disable-notifications");
		coptions.addArguments("disable-popup-blocking");
		coptions.addArguments("deny-permission-prompts");
		reader  = new practoPropertyReader();
		driver = new ChromeDriver(coptions);
		String url = reader.get("url.value");
		driver.get(url);
		return driver;
	}
	
	public static WebDriver edgedriver()
	{
		WebDriverManager.edgedriver().setup();
		eoptions= new EdgeOptions();
		eoptions.addArguments("--start-maximized");
		eoptions.addArguments("Incognito");
	//	eoptions.addArguments("headless");
		eoptions.addArguments("disable-notifications");
		eoptions.addArguments("disable-popup-blocking");
		eoptions.addArguments("deny-permission-prompts");
		reader  = new practoPropertyReader();
		driver = new EdgeDriver(eoptions);
		String url = reader.get("url.value");
		driver.get(url);
		return driver;
	}
	
	public static WebDriver getDriver()
	 
	{    
		 String browser = reader.get("url.value");
 
         if (browser.equalsIgnoreCase("chrome"))
         {
 
            return chromedriver();
         }
 
         else if (browser.equalsIgnoreCase("edge") )
         {
 
            return edgedriver();
         }
         else
         {   
        	 System.out.println("[BaseSteps] Unknown browser: " + browser );
 
        	 return edgedriver();
         }
	}	
 
}
