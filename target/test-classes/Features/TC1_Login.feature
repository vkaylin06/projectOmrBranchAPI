@Login
Feature: Login Module API Automation

  Scenario: Get User logtoken from login endpoint
    Given User add header
    And User add basic authentication for login
    When User send post request for login endpoint
    Then User should verify the status code is 200
    And User verify the login response body first name is "Mary claena" and get logtoken should be saved
