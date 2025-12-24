package com.setup;

// Practo basesteps
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseSteps
{
	public static WebDriver driver;
	public static EdgeOptions eoptions;
	public static ChromeOptions coptions;
	
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
		
		driver = new ChromeDriver(coptions);
		driver.get("https://www.practo.com/");
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
		
		driver = new EdgeDriver(eoptions);
		driver.get("https://www.practo.com/");
		return driver;
	}

	public static void tearDown() {
		// TODO Auto-generated method stub
		
	}
}
