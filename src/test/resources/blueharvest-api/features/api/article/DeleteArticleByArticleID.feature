Feature: Delete Article By ArticleID
  As a user
  I want to delete a Article by its ArticleID
  So that I can remove unnecessary Article data

 // @Ignore
  Scenario: User deletes Article by valid PromoID
    Given I set promo API endpoint for deleting Article by ArticleID
    When I send DELETE request to delete Article by ArticleID
    Then I receive status code 200
    And the system should confirm successful Article deletion

  Scenario: User fails to delete Article by invalid Endpoint
    Given I set invalid Article API endpoint for deleting Article
    When I send DELETE request to delete Article by invalid Endpoint
    Then I receive status code 404

  Scenario: User fails to delete Article without providing ArticleID
    Given I set promo API endpoint for deleting Article by ArticleID
    When I send DELETE request without providing PromoID
    Then I receive status code 404
