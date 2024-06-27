Feature: Create New Article
  As a user
  I want to create a new article
  so that I can add it to the system

  Scenario: User creates a new article successfully
    Given I set API endpoint for creating a new article
    When I send a POST request to create a new article
    Then I receive status code 200
    And the system should confirm the article creation

  Scenario: User fails to create a new article due to missing required fields
    Given I set API endpoint for creating a new article
    When I send a POST request to create a new article without required fields
    Then I receive status code 400
    And I receive an error message about missing fields

  Scenario: User fails to create a new article due to unauthorized access
    Given I set API endpoint for creating a new article
    When I send a POST request to create a new article with invalid endpoint
    Then I receive status code 403
    And I receive an error message about unauthorized access
