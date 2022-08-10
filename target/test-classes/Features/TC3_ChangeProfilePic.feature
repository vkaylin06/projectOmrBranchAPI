@ProfilePic
Feature: Change Profile Picture Module API Automation

  Scenario: User uploads profile picture
    Given User adds headers for form data
    And User passes form data as payload to change profile picture
    When User send post request for changeProfilePic endpoint
    Then User should verify the status code is 200
    And User verify the changeProfilePic response body message "Profile updated Successfully"
