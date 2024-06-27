Feature: Get All Address
  As a user
  I want to retrieve all address
  so that I can see the list of all address available in the system

  Scenario: User retrieves all address successfully
    Given I set API endpoint for retrieving all address
    When I send a GET request to retrieve all address
    Then I receive status code 200
    And I receive valid address list data

  Scenario: User fails to retrieve all address due to invalid authorization token
    Given I set API endpoint for retrieving all address
    When I send a GET request to retrieve all address with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access

  Scenario: User retrieves all address with invalid endpoint
    Given I set invalid API endpoint for retrieving all address
    When I send a GET request to retrieve all address with invalid endpoint
    Then I receive status code 404
    And I receive an error message about invalid endpoint
