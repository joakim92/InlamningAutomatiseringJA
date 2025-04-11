Feature: Registration functionality

  Scenario: Succesful registration at baskeballengland.com
    Given I am at the basketball registration page
    When  I enter valid registration details
    And I Click the confirm and join button
    Then I should be registered succesfully

  Scenario: Registration should fail when Last Name is missing
    Given I am at the basketball registration page
    When I fill registration details and leave last name blanked
    And I Click the confirm and join button
    Then I should get an error message telling me that last name is missing

  Scenario: Registration should fail when passwords doesnt match
    Given I am at the basketball registration page
    When I fill registration details but passwords doesnt match
    And I Click the confirm and join button
    Then I should get an error message telling me that passwords doesnt match

  Scenario: Registration should fail when terms and conditions are not accepted
    Given I am at the basketball registration page
    When I fill registration details but doesnt accept the terms and conditions
    And I Click the confirm and join button
    Then I should get an error message telling me that terms and conditions are not accepted
