Feature: Create New Farm Invest
  As a user
  I want to create a new farm investment
  So that I can add it to the system

  Scenario: User creates a new farm investment successfully
    Given I set API endpoint for creating a new farm investment
    When I send a POST request to create a new farm investment
    Then I receive status code 201
    And I receive valid farm investment creation data

  Scenario: User fails to create a new farm investment due to missing required fields
    Given I set API endpoint for creating a new farm investment
    When I send a POST request to create a new farm investment without required fields
    Then I receive status code 400
    And I receive an error message about missing fields

  Scenario: User fails to create a new farm investment due to invalid authorization token
    Given I set API endpoint for creating a new farm investment
    When I send a POST request to create a new farm investment with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access
