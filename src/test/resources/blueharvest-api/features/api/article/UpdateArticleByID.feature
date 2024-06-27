Feature: Update Article by ID
  As a user
  I want to update an existing article by ID
  so that I can modify its content in the system

  Scenario: User updates an article successfully
    Given I set API endpoint for updating an article by ID
    When I send a PUT request to update the article with ID
    Then I receive status code 200
    And the system should confirm the article update

  Scenario: User fails to update an article due to missing required fields
    Given I set API endpoint for updating an article by ID
    When I send a PUT request to update the article due to missing required fields
    Then I receive status code 400
    And I receive an error message about missing fields


  Scenario: User fails to update an article due to invalid ID
    Given I set API endpoint for updating an article by ID
    When I send a PUT request to update an article with invalid ID
    Then I receive status code 404
    And I receive an error message about invalid endpoint
