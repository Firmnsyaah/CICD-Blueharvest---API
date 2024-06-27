Feature: Get Farm By FarmID
  As a user
  I want to retrieve farm details by FarmID
  So that I can view specific farm information

  Scenario: User retrieves farm details by valid FarmID
    Given I set farm API endpoint for get farm by FarmID
    When I send GET request to get farm by FarmID
    Then I receive status code 200
    And I receive detail farm with FarmID

  Scenario: User fails to retrieve farm details by invalid FarmID
    Given I set farm API endpoint for get farm by FarmID
    When I send GET request to get farm by invalid FarmID
    Then I receive status code 404

  Scenario: User fails to retrieve farm details with missing FarmID
    Given I set farm API endpoint for get farm by FarmID
    When I send GET request to get farm by missing FarmID
    Then I receive status code 404
