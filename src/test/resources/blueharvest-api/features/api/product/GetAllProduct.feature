Feature: Get All Products
  As a user
  I want to retrieve all products
  so that I can see the list of all products available in the system

  Scenario: User retrieves all products successfully
    Given I set API endpoint for retrieving all products
    When I send a GET request to retrieve all products
    Then I receive status code 201
    And I receive valid product list data

  Scenario: User fails to retrieve all products due to invalid authorization token
    Given I set API endpoint for retrieving all products
    When I send a GET request to retrieve all products with invalid authorization token
    Then I receive status code 403
    And I receive an error message about unauthorized access

  Scenario: User retrieves all products with invalid endpoint
    Given I set invalid API endpoint for retrieving all products
    When I send a GET request to retrieve all products with invalid endpoint
    Then I receive status code 404
    And I receive an error message about invalid endpoint
