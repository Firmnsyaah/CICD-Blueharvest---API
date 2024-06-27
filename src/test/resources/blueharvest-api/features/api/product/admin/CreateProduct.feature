Feature: Create Product
  As a user
  I want to create a new product
  So that I can add it to the system

  Scenario: User creates a new product successfully
    Given I set API endpoint for creating a new product
    When I send a POST request to create a new product
    Then I receive status code 201
    And I receive valid product creation data

  Scenario: User fails to create a new product due to missing required fields
    Given I set API endpoint for creating a new product
    When I send a POST request to create a new product without required fields
    Then I receive status code 400
    And I receive an error message about missing fields

  Scenario: User fails to create a new product due to invalid authorization token
    Given I set API endpoint for creating a new product
    When I send a POST request to create a new product with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access