Feature: GET All Cities
  As a user
  I want to retrieve all cities for a specific state
  So that I can view a list of cities in that state

  Scenario: User retrieves all cities for a specific state successfully
    Given I wants to retrieve all cities for a specific state
    When I sends a GET request to retrieve all cities
    Then I receive status code 201
    And the user should receive valid city data for the specific state

  Scenario: User fails to retrieve cities for an invalid state ID
    Given I wants to retrieve all cities for an invalid state ID
    When I sends a GET request to retrieve all cities with an invalid state ID
    Then I receive status code 404
    And the user should receive status code for invalid state ID

  Scenario: User fails to retrieve cities without proper authorization
    Given I wants to retrieve all cities for a specific state
    When I sends a GET request to retrieve all cities without proper authorization
    Then I receive status code 405
    And the user should receive status code for unauthorized access
