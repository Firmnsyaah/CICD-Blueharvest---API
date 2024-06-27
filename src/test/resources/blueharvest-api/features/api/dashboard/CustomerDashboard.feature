Feature: Get Admin Dashboard
  As a user
  I want to retrieve Admin Dashboard
  so that I can see the list of all Admin Dashboard available in the system

  Scenario: User retrieves customer dashboard successfully
    Given I set API endpoint for retrieving customer dashboard
    When I send a GET request to retrieve customer dashboard
    Then I receive status code 200
    And I receive valid customer dashboard list data

  Scenario: User fails to retrieve admin dashboard due to invalid authorization token
    Given I set API endpoint for retrieving customer dashboard
    When I send a GET request to retrieve customer dashboard with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access

  Scenario: User retrieves admin dashboard with invalid endpoint
    Given I set invalid API endpoint for retrieving customer dashboard
    When I send a GET request to retrieve customer dashboard with invalid endpoint
    Then I receive status code 404
    And I receive an error message about invalid endpoint
