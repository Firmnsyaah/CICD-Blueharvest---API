Feature: Update Product
  As a user
  I want to update an existing product
  so that I can update the product details in the system.

  Scenario: User updates a product successfully
    Given I set API endpoint for updating a product
    And I set the valid product ID
    When I send a PUT request to update the product
    Then I receive status code 200
    And I receive valid product update data

  Scenario: User failed to update product without productID
    Given I set API endpoint for updating a product
    And I set the valid product ID
    When I send a PUT request to update the product without productID
    Then I receive status code 404

  Scenario: User fails to update a product due to invalid authorization token
    Given I set API endpoint for updating a product
    And I set the valid product ID
    When I send a PUT request to update the product with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access

