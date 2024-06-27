Feature: Customer Login
  As a user
  I want to log into my account
  So that I can access the platform's features

  Scenario: User successfully logs in with valid data
    Given I set API endpoint for customer login
    When I send a POST request to login with valid data
    Then I receive status code 200
    And I receive valid login data

  Scenario: User fails to login due to incorrect password
    Given I set API endpoint for customer login
    When I send a POST request to login with incorrect password
    Then I receive status code 401

  Scenario: User fails to login due to invalid endpoint
    Given I set an invalid API endpoint for customer login
    When I send a POST request to login with invalid data
    Then I receive status code 404
    Then I receive an error message about product not found

