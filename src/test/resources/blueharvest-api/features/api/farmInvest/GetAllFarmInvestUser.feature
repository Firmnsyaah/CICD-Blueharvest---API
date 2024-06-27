Feature: Get All Farm Invest User
  As a user
  I want to retrieve all farm invests
  So that I can view specific farm invest information

  Scenario: User retrieves all farm invests successfully
    Given I set farm invest API endpoint for get all farm invests user
    When I send GET request to get all farm invests user
    Then I receive status code 200
    And I receive a list of farm invests user

  Scenario: User fails to retrieve all farm invests with invalid endpoint
    Given I set invalid farm invest API endpoint
    When I send a GET request to retrieve all farm with invalid endpoint
    Then I receive status code 404

  Scenario: User fails to retrieve all farm invests with missing endpoint
    Given I set farm invest API endpoint for get all farm invests user
    When I send a GET request to retrieve all farm with invalid authorization token
    Then I receive status code 403

  Scenario: User fails to retrieve all articles due to invalid authorization token
    Given I set farm invest API endpoint for get all farm invests user
    When I send a GET request to retrieve all farm with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access
