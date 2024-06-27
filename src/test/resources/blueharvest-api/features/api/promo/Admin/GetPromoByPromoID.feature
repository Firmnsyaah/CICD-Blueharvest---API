Feature: Get Promo By PromoID
  As a user
  I want to retrieve a promo by its PromoID
  So that I can view the details of the promotional offer

  Scenario: User successfully retrieves a promo with a valid PromoID
    Given I set API endpoint for retrieving a promo by PromoID
    When I send a GET request to retrieve the promo with a valid PromoID
    Then I receive status code 200
    And I receive valid promo data

  Scenario: User fails to retrieve a promo with a wrong PromoID
    Given I set API endpoint for retrieving a promo by PromoID
    When I send a GET request to retrieve the promo with a wrong PromoID
    Then I receive status code 404
    And I receive an error message about promo not found

  Scenario: User fails to retrieve a promo due to invalid endpoint
    Given I set an invalid API endpoint for retrieving a promo by PromoID
    When I send a GET request to retrieve the promo with a valid PromoID to an invalid endpoint
    Then I receive status code 404
    And I receive an error message about the endpoint not being found