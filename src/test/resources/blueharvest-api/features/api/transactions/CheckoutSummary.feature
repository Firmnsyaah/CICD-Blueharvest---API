@Checkout_Summary
Feature: Checkout Summary

  Scenario: User successfully views the checkout summary
    Given I set checkout summary API endpoint
    When I send POST request to view checkout summary with valid authorization and data
    Then I receive status code 200
    And The system should confirm successful checkout summary response

  Scenario: User views checkout summary without providing required fields
    Given I set checkout summary API endpoint
    When I send POST request to view checkout summary without providing required fields
    Then I receive status code 400

  Scenario: User views checkout summary with invalid data
    Given I set checkout summary API endpoint
    When I send POST request to view checkout summary with invalid data
    Then I receive status code 404
