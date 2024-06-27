Feature: Get Profil
  As a user
  I want to retrieve profil
  so that I can see the list of profil available in the system

  Scenario: User retrieves profil successfully
    Given I set API endpoint for retrieving profil
    When I send a GET request to retrieve profil
    Then I receive status code 200
    And I receive valid profil list data

  Scenario: User fails to retrieve profil due to invalid authorization token
    Given I set API endpoint for retrieving profil
    When I send a GET request to retrieve profil with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access

  Scenario: User retrieves profil with invalid endpoint
    Given I set invalid API endpoint for retrieving profil
    When I send a GET request to retrieve profil with invalid endpoint
    Then I receive status code 404
    And I receive an error message about invalid endpoint
