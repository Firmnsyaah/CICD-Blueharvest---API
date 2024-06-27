Feature: POST Get Courier
  As a user
  I want to get courier information
  So that I can view available couriers for specific delivery details

  Scenario: I retrieve courier information successfully
    Given I want to get courier information
    When I send a POST request to get courier information
    Then I receive status code 200
    And I should receive valid courier information

  Scenario: I fail to retrieve courier information due to invalid endpoint
    Given I want to get courier information
    When I send a POST request to get courier information with an invalid endpoint
    Then I receive status code 404

  Scenario:I fail to retrieve courier information due to missing required fields
    Given I want to get courier information
    When I send a POST request to retrieve courier information with missing required fields
    Then I receive status code 400
