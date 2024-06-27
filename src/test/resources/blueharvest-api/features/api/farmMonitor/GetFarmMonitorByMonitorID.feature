Feature: Get All Farm Monitor By MonitorId
  As a user
  I want to retrieve all farm monitors by MonitorId
  So that I can view specific farm monitor information

  Scenario: User retrieves all farm monitors by valid MonitorId
    Given I set farm monitor API endpoint for get all monitors by MonitorId
    When I send GET request to get all monitor monitors by valid MonitorId
    Then I receive status code 200
    And I receive a list of farm monitors with the given MonitorId

  Scenario: User fails to retrieve all farm monitors by invalid MonitorId
    Given I set farm monitor API endpoint for get all monitors by MonitorId
    When I send GET request to get all monitor monitors by invalid MonitorId
    Then I receive status code 404

  Scenario: User fails to retrieve all farm monitors with missing MonitorId
    Given I set farm monitor API endpoint for get all monitors by MonitorId
    When I send GET request to get all monitor monitors with missing MonitorId
    Then I receive status code 404
