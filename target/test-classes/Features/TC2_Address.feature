@Address
Feature: Address Module API Automation

  Scenario Outline: Adding user address
    Given User add headers
    And User passes payload for adding address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    When User send post request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddress response body has message "Address added successfully" and get address_Id

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Mary       | Aylin     | 9840089896 | AppaSwamy |   111 |  222 |     333 |   60078 | Chennai | home         |

  Scenario Outline: Updating user address
    Given User add headers
    And User passes payload for updating address"<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    When User send put request for updateUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the updateUserAddress response body has message "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment   | state | city | country | zipcode | address | address_type |
      | Mary       | Claena    | 9845578984 | HiraNandini |   111 |  222 |     333 |   60078 | Chennai | home         |

  Scenario: Deleting user address
    Given User add headers
    And User passes payload for deleting address
    When User send delete request for deleteAddress endpoint
    Then User should verify the status code is 200
    And User should verify the deleteAddress response body has message "Address deleted successfully"

  Scenario: Getting user address
    Given User add headers
    When User send get request for getUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the getUserAddress response body has message "OK"
