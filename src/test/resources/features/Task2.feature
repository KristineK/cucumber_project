Feature: People with jobs

  Background:
    Given I open "People" page

  Scenario: Add Person
    When I click Add Person
    And I enter values into fields:
      | name |surname| job |
      | Ann  | Smith  | manager |
      | Bob  | Geldof | composer |
    And I choose Date of Birth
    And I choose Language
      | English|
      | French|
      | Spanish|

    And I choose Gender
      | Male|
      | Female|
    And I choose Employee status
      | Employee |
      | Intern |
      | Contractor |
    And I click add
    Then I can see new Person in the list
