Feature: Simple test to launch browser with given "appUrl"
    
  @smoke
  Scenario: To validate navigation to Online Savings Account Tab
    When user navigates to the appUrl
    Then landing page should be displayed
    When user clicks on Online Savings Account Tab
    Then Online Savings Account page should be displayed
    When user clicks on Home page icon
    Then landing page should be displayed
    And all tabs should be closed