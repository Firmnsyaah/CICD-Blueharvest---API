@GettAllMESSAGE
Feature: GET All Messages
  As a user
  I want to retrieve all messages
  So that I can view a list of all messages

  Scenario: User retrieves all messages successfully
    Given I set API endpoint for retrieving all messages
    When I send a GET request to retrieve all messages
    Then I receive status code 200
    And the user should receive valid message data

  Scenario: User fails to retrieve messages with invalid endpoint
    Given I set API endpoint for retrieving all messages
    When I send a GET request to retrieve all messages with invalid endpoint
    Then I receive status code 404

  Scenario: User fails to retrieve messages without proper authorization
    Given I set API endpoint for retrieving all messages
    When I send a GET request to retrieve all messages without proper authorization
    Then I receive status code 403
