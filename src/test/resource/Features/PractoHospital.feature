
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
Scenario: To validate that entering a valid mobile number sends app link and shows Sent Successfully.
	When the user click Search for hospitals from footer
	And the user enters the location
	And the user click on hospitalname
	And the user Enter phone number in get practo app box
	And the user click on send
	Then the confirmation message is visible

@testcase4
Scenario: To validate that applying years experience filter shows only eligible doctors.
	When the user click Search for hospitals from the footer
	And the user enters the valid location
	And the user enter the speciality
	And the user apply filter
	Then the user check if the doctors list is filtered
