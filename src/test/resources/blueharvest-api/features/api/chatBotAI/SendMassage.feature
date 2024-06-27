@SendMassage
Feature: Send Message
  As a user
  I want to send a message
  So that I can communicate with others

  Scenario: User sends a message successfully
    Given I set message API endpoint for sending a message
    When I send POST request to send a message with valid data
    Then I receive status code 201
    And The system should confirm successful message sent

  Scenario: User fails to send a message without required fields
    Given I set message API endpoint for sending a message
    When I send POST request to send a message without providing required fields
    Then I receive status code 400

  Scenario: User fails to send a message with invalid data
    Given I set message API endpoint for sending a message
    When I send POST request to send a message with invalid data
    Then I receive status code 500
