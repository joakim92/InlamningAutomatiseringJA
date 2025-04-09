Feature: Registration functionality

  Scenario: Succesful registration at baskeballengland.com
    Given I am at the basketball registration page
    When  I enter valid registration details
    And I Click the confirm and join button
    Then I should be registered succesfully
