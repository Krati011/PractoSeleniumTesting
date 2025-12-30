
Feature: To validate hospital and booking workflow.

Background:
Given User is on the Homepage of Practo Web after successful login.



@testcase1
Scenario: To validate that when user click on a hospital name, the hospital details page open successfully
    When the user clicks on Search for hospitals
    And the user enters required location
    And the user clicks on the hospital name 
    Then the Hospital Details page should open

@testcase2
Scenario: To validate that clicking Call Now reveals the hospital phone number.
	When the user clicks Search for hospitals from footer
	And the user enters the required location
	And the user click on a hospitalname
	And the user click on call now button
	And the user scroll down
	Then the number is visible
	
 
@testcase3
Scenario Outline: To validate that entering a valid mobile number sends app link and shows Sent Successfully.
	When the user click Search for hospitals from footer
	And the user enters the location
	And the user click on hospitalname
	And the user Enter phone number in filename "<Filename>" ,sheet <sheet> and row <row> in get practo app box
	And the user click on send
	Then the confirmation message is visible
	
	Examples:
	|Filename            |sheet|row|
	|practoExcelData.xlsx| 0   |  1 |
	|practoExcelData.xlsx| 0   |  2 |
	|practoExcelData.xlsx| 0   |  3 |
	
	


@testcase4
Scenario: To validate that applying filters shows only eligible doctors.
	When the user click Search for hospitals from the footer
	And the user enters the valid location
	And the user enter the speciality
	And the user apply filter
	Then the user check if the doctors list is filtered

@testcase5
Scenario: To validate that user can book an appointment for Other with valid details successfully.
	When the user click Search for hospitals in footer
	And the user enters location
	And the user enter the required speciality
	And the user apply the filter
	And the user select a doctor from the list
	And the user click on book appointment
	And the user select a time and date
	And the user fills the form for someone else
  | filename               |
  | practoExcelData.xlsx  |
 
	Then the user click on submit button
	And the confirmation message that the appointment is book appear
	
@testcase6
Scenario: To validate that empty form submission is blocked and Show the error message in mandetory fields
	When the user clicks Search for hospitals in footer
	And the user enter the location
	And the user enter the valid speciality
	And the user applies the filter
	And the user select the doctor from the list
	And the user click on share your story
	Then the user clicked submit button without filling the form
	And the error message shown correctly