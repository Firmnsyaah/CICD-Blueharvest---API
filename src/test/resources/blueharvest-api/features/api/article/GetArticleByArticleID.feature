Feature: Retrieve article by ID
  As a user
  I want to retrieve articles by their ID
  So that I can view the details of a specific article

  Scenario: Successfully retrieve a valid article
    Given I set API endpoint for retrieving a valid article
    When I send a GET request to retrieve the valid article
    Then I receive status code 200
    Then I receive valid article retrieval data

  Scenario: Attempt to retrieve an article with an invalid product ID
    Given I set API endpoint for retrieving an invalid article
    When I send a GET request to retrieve the invalid article
    Then I receive status code 404
    Then I receive an error message about invalid endpoint

  Scenario: Attempt to retrieve an article with an invalid authorization token
    Given I set API endpoint for retrieving a valid article
    When I send a GET request to retrieve the article with an invalid authorization token
    Then I receive status code 403
    Then I receive an error message about unauthorized access
