Feature: Get Product By ID
  As a user
  I want to get product details by ID
  so that I can see existing product information.

  Scenario: User retrieves a product successfully
    Given I set API endpoint for retrieving a product
    And I set the valid product ID
    When I send a GET request to retrieve the product
    Then I receive status code 201
    And I receive valid product retrieval data

  Scenario: User fails to retrieve a product due to product ID not found
    Given I set API endpoint for retrieving a product
    And I set an invalid product ID
    When I send a GET request to retrieve the product with invalid product ID
    Then I receive status code 404
    And I receive an error message about product not found

  Scenario: User fails to retrieve a product due to invalid authorization token
    Given I set API endpoint for retrieving a product
    And I set the valid product ID
    When I send a GET request to retrieve the product with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access
