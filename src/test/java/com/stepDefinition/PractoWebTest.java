package com.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.practoHomepage;
import com.pages.shareYourStorypage;
import com.parameters.ExcelReader;
import com.pages.appointmentBookingpage;
import com.pages.doctorDetailpage;
import com.pages.doctorsListpage;
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
	doctorsListpage doctorList;
	doctorDetailpage doctorDetail;
	appointmentBookingpage appointmentBooking;
	ExcelReader excel;
	shareYourStorypage shareYourStory;

	
	
	
//------------------------------------BACKGROUND-----------------------------
	@Given("User is on the Homepage of Practo Web after successful login.")
	public void user_is_on_the_homepage_of_practo_web_after_successful_login() 
	{
		driver = BaseSteps.edgedriver();
		homepage = new practoHomepage(driver);
		hospitalsList = new hospitalsListpage(driver);
		hospitalDetail = new hospitalDetailpage(driver);
		doctorList = new doctorsListpage(driver);
		doctorDetail = new doctorDetailpage(driver);
		appointmentBooking = new  appointmentBookingpage(driver);
		excel=new ExcelReader();
		shareYourStory = new shareYourStorypage(driver);
		
		homepage.login();		
	}
	

//------------------------------------------Scenario-1------------------------------
	/*Created By: Krati Gupta
	 * Reviewed By: SME
	 * Motive:To validate that when user click on a hospital name, the hospital details page open successfully.
	 */
	
	
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
		hospitalsList.selectHospital1();	
	}
	
	@Then("the Hospital Details page should open")
	public void the_hospital_details_page_should_open() 
	{
		String listpage = hospitalsList.hospitalNameInList();
		hospitalsList.getwindow();
		String detailpage = hospitalDetail.hospitalNameFromDetail();
		
		Assert.assertTrue(listpage.contains(detailpage) ||detailpage.contains(listpage)  , "Name is notmatched");
	}
	
	//-----------------------------------------Scenario-2 --------------------------------------------------
	/*Created By: Krati Gupta
	 * Reviewed By: SME
	 * Motive:To validate that clicking Call Now reveals the hospital phone number.
	 */
	
	
	
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
		hospitalsList.selectHospital2();
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
	
	
	
//--------------------------------------------Scenario 3-----------------------------------
	/*Created By: Krati Gupta
	 * Reviewed By: SME
	 * Motive:To validate that entering a valid mobile number sends app link and shows Sent Successfully.
	 */
	
	
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
		hospitalsList.selectHospital3();
		hospitalsList.getwindow();
	}
	
	@When("the user Enter phone number in filename {string} ,sheet {int} and row {int} in get practo app box")
	public void the_user_enter_phone_number_in_filename_sheet_and_row_in_get_practo_app_box(String file, Integer sheet, Integer row) throws IOException {
	    
		String data=excel.getRowData(file, sheet, row);
		
		hospitalDetail.getAppLink(data);
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
	
	
//---------------------------------------------------Scenario 4------------------------------
	/*Created By: Krati Gupta
	 * Reviewed By: SME
	 * Motive:To validate that applying filters shows only eligible doctors
	 */
	
	
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
	public void the_user_enter_the_speciality() 
	{
	    hospitalsList.inputSpecialty();
	}
	
	@And("the user apply filter")
	public void the_user_apply_filter() 
	{
	    doctorList.experienceFilter();
	    doctorList.clickexperience();
	    doctorList.listScroll();
	    doctorList.doctorExperience();
	}
	
	@Then("the user check if the doctors list is filtered")
	public void the_user_check_if_the_doctors_list_is_filtered() 
	{
		
		int filter = Integer.parseInt(doctorList.filteredExperience());

		for(int actual :doctorList.doctorExperience()) {
			Assert.assertTrue(filter<actual, "The filter is not applied correctly");
			System.out.println(actual);
		}
	}
	
	
//-----------------------------------------------------Scenerio 5---------------------------------------
	/*Created By: Krati Gupta
	 * Reviewed By: SME
	 * Motive:To validate that user can book an appointment for Other with valid details successfully
	 */
	
	
	@When("the user click Search for hospitals in footer")
	public void the_user_click_search_for_hospitals_in_footer() 
	{
		homepage.scrolldown();
		homepage.clickSearForHospital();
	}
	
	@And("the user enters location")
	public void the_user_enters_location() 
	{
		hospitalsList.inputLocation();
	}
	
	@And("the user enter the required speciality")
	public void the_user_enter_the_required_speciality() 
	{
		hospitalsList.inputSpecialty();
	}
	
	@And("the user apply the filter")
	public void the_user_apply_the_filter() 
	{
		doctorList.experienceFilter();
	    doctorList.clickexperience();
	    doctorList.listScroll();
	}
	
	@And("the user select a doctor from the list")
	public void the_user_select_a_doctor_from_the_list() 
	{
	    doctorList.SelectDoctor1();
	    doctorList.getwindow();
	}
	
	@And("the user click on book appointment")
	public void the_user_click_on_book_appointment() 
	{
	    doctorDetail.clickOnBookAppointment();
	}
	
	@And("the user select a time and date")
	public void the_user_select_a_time_and_date() 
	{
		doctorDetail.selectTimeAndDate();
	}
	
	
	@And("the user fills the form for someone else")
	public void the_user_fills_the_form_for_someone_else(io.cucumber.datatable.DataTable dataTable)throws IOException 
	{
		appointmentBooking.clickOnForSomeone();
		
		List<String> list = dataTable.asList();
	    String[] cred = excel.AppointmentDetailsReader(list.get(1));
	    appointmentBooking.fillTheForm(cred[0], cred[1]);
	}
	
	
	@Then("the user click on submit button")
	public void the_user_click_on_submit_button() 
	{
	   appointmentBooking.clickOnSubmit();
	   appointmentBooking.verifying();
	}
	
	@And("the confirmation message that the appointment is book appear")
	public void the_confirmation_message_that_the_appointment_is_book_appear() 
	{
	    Assert.assertEquals(appointmentBooking.appointmentConfirmation(),"Appointment Confirmed","Appointment not done");
	}
	
	
//----------------------------------------------Scenario 6-------------------------------------------
	/*Created By: Krati Gupta
	 * Reviewed By: SME
	 * Motive:To validate that empty form submission is blocked and Show the error message in mandetory fields.
	 */
	
	
	@When("the user clicks Search for hospitals in footer")
	public void the_user_clicks_search_for_hospitals_in_footer() 
	{
		homepage.scrolldown();
		homepage.clickSearForHospital();
	}
	
	@And("the user enter the location")
	public void the_user_enter_the_location() 
	{
		hospitalsList.inputLocation();
	}
	
	@And("the user enter the valid speciality")
	public void the_user_enter_the_valid_speciality() 
	{
		hospitalsList.inputSpecialty();
	}
	
	@And("the user applies the filter")
	public void the_user_applies_the_filter() 
	{
		doctorList.experienceFilter();
	    doctorList.clickexperience();
	    doctorList.listScroll();
	}
	
	@And("the user select the doctor from the list")
	public void the_user_select_the_doctor_from_the_list() 
	{
		doctorList.SelectDoctor2();
	    doctorList.getwindow();
	}
	
	@And("the user click on share your story")
	public void the_user_click_on_share_your_story() 
	{
	 doctorDetail.clickOnShareStory();   
	}
	
	@Then("the user clicked submit button without filling the form")
	public void the_user_clicked_submit_button_without_filling_the_form() 
	{
		shareYourStory.scrollToSubmit();
	    shareYourStory.clickOnSubmit();
	}
	
	@And("the error message shown correctly")
	public void the_error_message_shown_correctly() 
	{
	    String error= shareYourStory.errorMessage();
	    Assert.assertTrue(error.contains("Select one or more from the list."), "Error message did not show");
	}
	
	@After 
	public void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		driver.quit();
		
	}
//	
	
}
