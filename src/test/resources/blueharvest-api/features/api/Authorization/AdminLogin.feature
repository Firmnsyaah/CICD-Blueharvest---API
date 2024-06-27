Feature: Admin Login
  As an admin user
  I want to log in to my account
  So that I can access the admin functionalities

  Scenario: Admin successfully logs in with valid credentials
    Given I set API endpoint for admin login
    When I send a POST request to log in as admin with valid data
    Then I receive status code 200
    And I receive valid login data

  Scenario: Admin failed to log in due to invalid password
    Given I set API endpoint for admin login
    When I send a POST request to log in as admin with invalid password
    Then I receive status code 401
    And I receive an error message about invalid credentials

  Scenario: Admin failed to log in due to invalid endpoint
    Given I set an invalid API endpoint for admin login
    When I send a POST request to log in as admin with invalid endpoint
    Then I receive status code 404
    And I receive an error message about the endpoint not being found
