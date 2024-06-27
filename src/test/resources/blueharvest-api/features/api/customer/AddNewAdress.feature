Feature: POST Add New Address
  As a user
  I want to add a new address
  So that I can save my address details in the system

  Scenario: I add a new address successfully
    Given I want to add a new address
    When I send a POST request to add the new address
    Then I receive status code 201
    And I should receive valid address creation response

  Scenario: I fail to add a new address due to invalid endpoint
    Given I want to add a new address with an invalid endpoint
    When I send a POST request to add the new address with an invalid endpoint
    Then I receive status code 404
    And  I should receive status code 404 for invalid endpoint

  Scenario: I fail to add a new address due to missing required fields
    Given I want to add a new address
    When I send a POST request with missing required fields address
    Then I receive status code 400
    And I should receive status code 400 for missing required fields
