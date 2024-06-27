Feature: Create New Promo
  As a user
  I want to create a new promo
  So that I can add promotional offers to the system

  Scenario: User successfully creates a new promo with valid data
    Given I set API endpoint for creating a new promo
    When I send a POST request promo with valid data
    Then I receive valid promo creation data

  Scenario: User fails to create a new promo due to missing required fields
    Given I set API endpoint for creating a new promo
    When I send a POST request promo with missing required fields
    Then I receive status code 400
    And I receive an error promo message about unauthorized access

  Scenario: User fails to create a new promo due to invalid endpoint
    Given I set an invalid API endpoint for creating a new promo
    When I send a POST request promo with valid data to invalid endpoint
    Then I receive an error promo message about invalid endpoint
