Feature: Get All Promos
  As a user
  I want to retrieve all promos
  So that I can view all promotional offers available in the system

  Scenario: User successfully retrieves all promos with valid data
    Given I set API endpoint for retrieving all promos
    When I send a GET request to retrieve all promos with valid data
    Then I receive status code 200
    And I receive a list of all promos


  Scenario: User fails to retrieve all promos due to invalid endpoint
    Given I set an invalid API endpoint for retrieving all promos
    When I send a GET request to the invalid endpoint
    Then I receive status code 404
    And I receive an error message about the endpoint not being found

  Scenario: User fails to retrieve all farm details due to unauthorized access
    Given I set API endpoint for retrieving all promos
    When I send a GET request to retrieve all promos during a server error
    Then I receive status code 404
