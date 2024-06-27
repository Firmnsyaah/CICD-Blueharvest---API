Feature: Edit Promo By PromoID
  As a user
  I want to edit a promo by its PromoID
  So that I can update the promotional offer details

  Scenario: User successfully edits a promo with valid data
    Given I set API endpoint for editing a promo by PromoID
    When I send a PUT request to edit the promo with valid data
    Then I receive status code 200
    And the promo is successfully updated

  Scenario: User fails to edit a promo due to missing promo id
    Given I set API endpoint for editing a promo by PromoID
    When I send a PUT request to edit the promo with missing promo id
    Then I receive status code 404

  Scenario: User fails to edit a promo due to invalid PromoID
    Given I set an invalid API endpoint for editing a promo by PromoID
    When I send a PUT request to edit the promo with valid data but invalid PromoID
    Then I receive status code 404
