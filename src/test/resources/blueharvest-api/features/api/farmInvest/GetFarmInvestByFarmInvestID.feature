Feature: Get Farm Invest By FarmInvestID
  As a user
  I want to retrieve farm invest details by FarmInvestID
  So that I can view specific farm invest information

  Scenario: User retrieves farm invest by valid FarmInvestID
    Given I set farm invest API endpoint for get farm invest by FarmInvestID
    When I send GET request to get farm invest by valid FarmInvestID
    Then I receive status code 200
    And I receive farm invest details with the given FarmInvestID

  Scenario: User fails to retrieve farm invest with invalid FarmInvestID
    Given I set farm invest API endpoint for get farm invest by FarmInvestID
    When I send GET request to get farm invest by invalid FarmInvestID
    Then I receive status code 404

  Scenario: User fails to retrieve farm invest with missing FarmInvestID
    Given I set farm invest API endpoint for get farm invest by FarmInvestID
    When I send GET request to get farm invest with missing FarmInvestID
    Then I receive status code 404
