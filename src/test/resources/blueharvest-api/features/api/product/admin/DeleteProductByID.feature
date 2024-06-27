Feature: Delete Product by ProductID
  As a user
  I want to delete an existing product
  so that I can remove the product from the system


  Scenario: User deletes a product successfully
    Given I set API endpoint for deleting a product
    And I set the valid product ID
    When I send a DELETE request to delete the product
    Then I receive status code 200
    And I receive valid product deletion data


  Scenario: User fails to delete a product due to product ID not found
    Given I set API endpoint for deleting a product
    And I set an invalid product ID
    When I send a DELETE request to delete the product with invalid product ID
    Then I receive status code 404
    And I receive an error message about product not found

  Scenario: User fails to delete a product due to invalid authorization token
    Given I set API endpoint for deleting a product
    And I set the valid product ID
    When I send a DELETE request to delete the product with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access
