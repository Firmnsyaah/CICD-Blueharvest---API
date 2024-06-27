Feature: Create New Farm
  As a user
  I want to create a new farm
  So that I can add my farm details to the system

  Scenario: User successfully creates a new farm with valid data
    Given I set API endpoint for creating a new farm
    When I send a POST request with valid data
    Then I receive valid farm creation data

  Scenario: User fails to create a new farm due to missing required fields
    Given I set API endpoint for creating a new farm
    When I send a POST request with missing required fields
    Then I receive an error message about missing fields

  Scenario: User fails to create a new farm due to invalid endpoint
    Given I set an invalid API endpoint for creating a new farm
    When I send a POST request with valid data to invalid endpoint
    Then I receive an error message about invalid endpoint
