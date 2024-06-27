Feature: Delete Promo By PromoID
  As a user
  I want to delete a promo by its PromoID
  So that I can remove unnecessary promo data

  //@Ignore
  Scenario: User deletes promo by valid PromoID
    Given I set promo API endpoint for deleting promo by PromoID
    When I send DELETE request to delete promo by PromoID
    Then I receive status code 200
    And the system should confirm successful promo deletion

  Scenario: User fails to delete promo by invalid Endpoint
    Given I set invalid promo API endpoint for deleting promo
    When I send DELETE request to delete promo by invalid Endpoint
    Then I receive status code 404

  Scenario: User fails to delete promo without providing PromoID
    Given I set promo API endpoint for deleting promo by PromoID
    When I send DELETE request without providing PromoID
    Then I receive status code 404
