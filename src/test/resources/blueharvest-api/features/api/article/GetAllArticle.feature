Feature: Get All Articles
  As a user
  I want to retrieve all articles
  so that I can see the list of all articles available in the system

  Scenario: User retrieves all articles successfully
    Given I set API endpoint for retrieving all articles
    When I send a GET request to retrieve all articles
    Then I receive status code 200
    And I receive valid article list data

  Scenario: User fails to retrieve all articles due to invalid authorization token
    Given I set API endpoint for retrieving all articles
    When I send a GET request to retrieve all articles with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access

  Scenario: User retrieves all articles with invalid endpoint
    Given I set invalid API endpoint for retrieving all articles
    When I send a GET request to retrieve all articles with invalid endpoint
    Then I receive status code 404
    And I receive an error message about invalid endpoint
