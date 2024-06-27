Feature: Delete Farm By FarmID
  As a user
  I want to delete a farm by its FarmID
  So that I can remove unnecessary farm data

  //@Ignore
  Scenario: User deletes farm by valid FarmID
    Given I set farm API endpoint for deleting farm by FarmID
    When I send DELETE request to delete farm by FarmID
    Then I receive status code 200
    And the system should confirm successful farm deletion

  Scenario: User fails to delete farm by invalid Endpoint
    Given I set invalid farm API endpoint for deleting farm
    When I send DELETE request to delete farm by invalid Endpoint
    Then I receive status code 404

  Scenario: User fails to delete farm without providing FarmID
    Given I set farm API endpoint for deleting farm by FarmID
    When I send DELETE request without providing FarmID
    Then I receive status code 404
