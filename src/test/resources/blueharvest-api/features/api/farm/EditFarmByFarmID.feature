
Feature: Update Farm By FarmID
  As a user
  I want to edit farm details by FarmID so that
  I can update specific farm information

  Scenario: User successfully edits farm details by valid FarmID
    Given I set farm API endpoint for editing farm by FarmID
    When I send PUT request to edit farm by FarmID with valid authorization and data
    Then I receive status code 200
    And the system should confirm successful farm edit

  Scenario: User fails to edit farm details with missing FarmID
    Given I set farm API endpoint for editing farm by FarmID
    When I send PUT request to edit farm without providing FarmID
    Then I receive status code 404

  Scenario: User fails to edit farm details with invalid endpoint
    Given I set an invalid farm API endpoint for editing farm by FarmID
    When I send PUT request to edit farm with valid authorization and data
    Then I receive status code 404
