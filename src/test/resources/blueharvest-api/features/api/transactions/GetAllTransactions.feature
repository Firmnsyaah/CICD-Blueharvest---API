@Get_all_Transactions
Feature: Get All Transactions
  As a user
  I want to retrieve all transactions
  So that I can view the details of all transactions

  Scenario: Successfully get all transactions with valid authorization
    Given I set API endpoint to get all transactions
    When I send GET request to retrieve all transactions
    Then The system should return all transactions

  Scenario: Get all transactions with filter parameters
    Given I set API endpoint to get all transactions
    When I send a GET request to the transactions API endpoint with valid authorization and filter parameters
    Then I receive status code 200

  Scenario: Fail to get transactions with invalid filter parameters
    Given I set API endpoint to get all transactions
    When I send a GET request to the transactions API endpoint with invalid filter parameters
    Then I receive status code 500
