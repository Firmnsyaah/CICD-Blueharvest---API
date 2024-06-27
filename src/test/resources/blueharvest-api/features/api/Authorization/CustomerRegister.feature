Feature: Register
  As a user
  I want to register an account
  So that I can access the platform's features

  Scenario: User successfully registers with valid data
    Given I set API endpoint for user registration
    When I send a POST request to register a new user with valid data
    Then I receive status code 201
    And I receive valid registration data


  Scenario: User failed to register account due to duplicate data
    Given I set API endpoint for user registration
    When I send a POST request to register a new user with Duplicate data
    Then I receive status code 400

  Scenario: User fails to register due to invalid endpoint
    Given I set an invalid API endpoint for user registration
    When I send a POST request to register a new user with invalid data
    Then I receive status code 404
    Then I receive an error message about product not found







