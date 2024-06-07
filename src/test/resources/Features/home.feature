Feature: Testing functionalities on the Home Page

  Background: 
    Given User opens browser "Chrome" and navigate to the Home Page

  Scenario: Verify Test1 functionality
    When User navigate to "Test 1" div
    Then User should see input field for Email address, Password and SignIn button
    And User enters EmailId "Resolver@resolver.com" and Password "Password" in respective fields

  Scenario: Verify Test2 functionality
    When User navigate to "Test 2" div
    Then User should see 3 values in the list group
    And the second list item text should be "List Item 2"
    And its badge value should be "6"

  Scenario: Verify Test3 functionality
    When User navigate to "Test 3" div
    Then "Option 1" should be the selected value
    When User select "Option 3" from the dropdown
    Then "Option 3" should be the selected value

  Scenario: Verify Test4 functionality
    When User navigate to "Test 4" div
    Then the first button should be enabled
    And the second button should be disabled

  Scenario: Verify Test5 functionality
    When User navigate to "Test 5" div
    And User wait for the button to be displayed
    And user click the button
    Then User should see a success message
    And the button should be disabled

  Scenario: Verify Test6 functionality
    When User navigate to "Test 6" div
    Then the value of the cell (2, 2) should be "Ventosanzap"
