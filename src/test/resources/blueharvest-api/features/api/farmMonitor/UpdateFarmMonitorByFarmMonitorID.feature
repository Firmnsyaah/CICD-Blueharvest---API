Feature: Update Farm Monitor By FarmMonitorID
  As a user
  I want to edit farm monitor details by FarmMonitorID
  So that I can update specific farm monitor information

  @Update_Farm_monitor
  Scenario: User successfully edits farm monitor details by valid FarmMonitorID
    Given I set farm monitor API endpoint for editing farm monitor by FarmMonitorID
    When I send PUT request to edit farm monitor by FarmMonitorID with valid authorization and data
    Then I receive status code 200
    And The system should confirm successful farm monitor edit

  Scenario: User fails to edit farm monitor details with missing FarmMonitorID
    Given I set farm monitor API endpoint for editing farm monitor by FarmMonitorID
    When I send PUT request to edit farm monitor without providing FarmMonitorID
    Then I receive status code 404

  Scenario: User fails to edit farm monitor details with invalid endpoint
    Given I set an invalid farm monitor API endpoint for editing farm monitor by FarmMonitorID
    When I send PUT request to edit farm monitor with valid authorization and data
    Then I receive status code 404
