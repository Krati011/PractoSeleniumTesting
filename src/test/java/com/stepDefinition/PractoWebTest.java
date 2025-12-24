package com.stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.practoHomepage;
import com.pages.hospitalDetailpage;
import com.pages.hospitalsListpage;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PractoWebTest {
	WebDriver driver;
	practoHomepage homepage;
	hospitalsListpage hospitalsList;
	hospitalDetailpage hospitalDetail;

	
	
	
//-------------------BACKGROUND-----------------------------
	@Given("User is on the Homepage of Practo Web after successful login.")
	public void user_is_on_the_homepage_of_practo_web_after_successful_login() 
	{
		driver = BaseSteps.edgedriver();
		homepage = new practoHomepage(driver);
		hospitalsList = new hospitalsListpage(driver);
		hospitalDetail = new hospitalDetailpage(driver);
		
		homepage.login();		
	}
	

//------------------------------------------Scenario-1------------------------------
	@When("the user clicks on Search for hospitals")
	public void the_user_clicks_on_search_for_hospitals() 
	{
		homepage.scrolldown();
		homepage.clickSearForHospital();
	    
	}
	
	@And("the user enters required location")
	public void the_user_enters_required_location() 
	{
	    hospitalsList.inputLocation();
	    hospitalsList.scrollInHospitalList();	
		
	}
	
	@And("the user clicks on the hospital name")
	public void the_user_clicks_on_the_hospital_name() 
	{
		hospitalsList.selectHospital();
		
	}
	
	@Then("the Hospital Details page should open")
	public void the_hospital_details_page_should_open() 
	{
		String listpage = hospitalsList.hospitalNameInList();
		hospitalsList.getwindow();
		String detailpage = hospitalDetail.hospitalNameFromDetail();
		
		Assert.assertTrue(listpage.contains(detailpage) ||detailpage.contains(listpage)  , "Name is notmatched");
		
	}
	
	//------------------------------------Scenario-2 --------------------------------------------------

	
	@When("the user clicks Search for hospitals from footer")
	public void the_user_clicks_search_for_hospitals_from_footer() 
	{
		homepage.scrolldown();
		homepage.clickSearForHospital();
	}
	
	@And("the user enters the required location")
	public void the_user_enters_the_required_location() 
	{
		hospitalsList.inputLocation();
	    hospitalsList.scrollInHospitalList();	
	}
	
	@And("the user click on a hospitalname")
	public void the_user_click_on_a_hospitalname() 
	{
		hospitalsList.selectHospital();
		hospitalsList.getwindow();
	}
	
	@And("the user click on call now button")
	public void the_user_click_on_call_now_button() 
	{
		System.out.println("Pressing callNow");
		hospitalDetail.clickCallNow();
		
	}
	
	@And("the user scroll down")
	public void the_user_scroll_down() 
	{
		hospitalDetail.scrollALittle();
	    
	}
	
	@Then("the number is visible")
	public void the_number_is_visible() 
	{
		String actual = hospitalDetail.getPhoneNumber();
		String expected = "Phone number";
		
	    Assert.assertEquals(actual, expected,"Both are not same");
	}
	
	
	
//---------------------------Scenario 3-----------------------------------
	
	
	@When("the user click Search for hospitals from footer")
	public void the_user_click_search_for_hospitals_from_footer() 
	{
		homepage.scrolldown();
		homepage.clickSearForHospital();
	}
	
	@And("the user enters the location")
	public void the_user_enters_the_location() 
	{
		hospitalsList.inputLocation();
	    hospitalsList.scrollInHospitalList();
	}
	
	@And("the user click on hospitalname")
	public void the_user_click_on_hospitalname() 
	{
		hospitalsList.selectHospital();
		hospitalsList.getwindow();

	}
	
	@And("the user Enter phone number in get practo app box")
	public void the_user_enter_phone_number_in_get_practo_app_box() 
	{
		hospitalDetail.getAppLink();
	    
	}
	
	@And("the user click on send")
	public void the_user_click_on_send() 
	{
		hospitalDetail.clickSend();
	    
	}
	
	@Then("the confirmation message is visible")
	public void the_confirmation_message_is_visible() 
	{
		
		Assert.assertEquals(hospitalDetail.confirmation(), "Sent Successfully","Confirmation Failed");
	    
	}
	
	
//---------------------------Scenario 4------------------------------
	
	@When("the user click Search for hospitals from the footer")
	public void the_user_click_search_for_hospitals_from_the_footer() 
	{
		homepage.scrolldown();
		homepage.clickSearForHospital();
	}
	@And("the user enters the valid location")
	public void the_user_enters_the_valid_location() 
	{
		hospitalsList.inputLocation();
	    
	}
	@And("the user enter the speciality")
	public void the_user_enter_the_speciality() throws InterruptedException 
	{
	    hospitalsList.inputSpecialty();
	}
	@And("the user apply filter")
	public void the_user_apply_filter() 
	{
	    
	}
	@Then("the user check if the doctors list is filtered")
	public void the_user_check_if_the_doctors_list_is_filtered() 
	{
	    
	}
	
	@After 
	public void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		driver.quit();
		
	}
	
	
}
