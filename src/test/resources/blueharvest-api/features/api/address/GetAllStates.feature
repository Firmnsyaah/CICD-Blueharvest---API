Feature: GET All States
  As a user
  I want to retrieve all states
  So that I can view a list of available states

  Scenario: User retrieves all states successfully
    Given I want to retrieve all states
    When I sends a GET request to retrieve all states
    Then I receive status code 201
    And the system should provide all state details

  Scenario: User fails to retrieve all states due to invalid endpoint
    Given I want to retrieve all states with an invalid endpoint
    When I sends a GET request to retrieve all states with an invalid endpoint
    Then I receive status code 404

  Scenario: User fails to retrieve all states due to unauthorized access
    Given I want to retrieve all states
    When I sends a GET request to retrieve all states without proper authorization
    Then I receive status code 405
