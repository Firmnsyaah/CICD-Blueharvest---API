
Feature: GET All Farm
  As a user
  I want to
  So that I can

  Scenario: User retrieves all farm details successfully
    Given a user wants to retrieve all farm details
    When the user sends a GET request to retrieve all farm details
    Then I receive status code 200
    And the system should provide all farm details

  Scenario: User fails to retrieve all farm details due to invalid endpoint
    Given a user wants to retrieve all farm details
    When the user sends a GET request to an invalid endpoint
    Then I receive status code 404

  Scenario: User fails to retrieve all farm details due to unauthorized access
    Given a user wants to retrieve all farm details
    When the user sends a GET request without proper authorization
    Then I receive status code 403
