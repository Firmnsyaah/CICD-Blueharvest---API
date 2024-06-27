Feature: Create Admin User
  As an administrator
  I want to create a new admin user
  So that I can manage the platform

  Scenario: Admin user successfully created with valid data
    Given I set API endpoint for creating admin user
    When I send a POST request to create admin user with valid data
    Then I receive status code 201
    And I receive valid admin creation data

  Scenario: Admin user creation failed due to duplicate email
    Given I set API endpoint for creating admin user
    When I send a POST request to create admin user with duplicate email
    Then I receive status code 400
    And I receive an error message about duplicate data

  Scenario: Admin user creation failed due to invalid endpoint
    Given I set an invalid API endpoint for creating admin user
    When I send a POST request to create admin user with valid data on invalid endpoint
    Then I receive status code 404
    And I receive an error message about the endpoint not being found
