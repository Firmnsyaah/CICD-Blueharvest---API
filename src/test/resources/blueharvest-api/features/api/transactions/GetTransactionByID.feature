@Get_TransactionsByID
Feature: Get Transaction By ID
  As a user
  I want to retrieve transaction details by Transaction ID
  So that I can view specific transaction information

  Background:
    Given I set transaction API endpoint for get transaction by TransactionID

  Scenario: User retrieves transaction details by valid TransactionID
    Given I set transaction API endpoint for get transaction by TransactionID
    When I send GET request to get transaction by TransactionID
    Then I receive status code 200
    And I receive detail transaction with TransactionID

  Scenario: User fails to retrieve transaction details by invalid TransactionID
    Given I set transaction API endpoint for get transaction by TransactionID
    When I send GET request to get transaction by invalid TransactionID
    Then I receive status code 404

  Scenario: User fails to retrieve transaction details with missing TransactionID
    Given I set transaction API endpoint for get transaction by TransactionID
    When I send GET request to get transaction by missing TransactionID
    Then I receive status code 404
