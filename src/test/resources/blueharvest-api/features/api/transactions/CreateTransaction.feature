@Create_Transactions
Feature: Create Transaction
  As a user
  I want to create a transaction so that
  I can purchase products.

  Scenario: Successfully create a transaction with valid data
    Given I set transaction API endpoint for creating a transaction
    When I send POST request to create a transaction with valid authorization and data
    Then I receive status code 201
    And The system should confirm successful transaction creation

  Scenario: Fail to create a transaction without providing required fields
    Given I set transaction API endpoint for creating a transaction
    When I send POST request to create a transaction without providing required fields
    Then I receive status code 400

  Scenario: Fail to create a transaction with invalid data
    Given I set transaction API endpoint for creating a transaction
    When I send POST request to create a transaction with invalid data
    Then I receive status code 404
