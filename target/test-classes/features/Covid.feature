Feature: Covid API
@covid
  Scenario: Get covid info for all states
    When user sends GET request to COVID api
    And status is 200
    Then User gets information about all States

