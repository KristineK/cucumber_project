Feature: People with jobs

  Background:
    Given I open People page

  Scenario: Add Person
    When I click Add Person
    And I enter name: "John"
    And I enter surname: "Smith"
    And I enter job: "killer"
    And I choose Date of Birth: "02/12/1978"
    And I choose Language
      | English|
      | French|
      | Spanish|
    And I choose Gender: "Male"
    And I choose Employee status: "Employee"
    And I click add
    Then I can see new Person in the list with name "John" and surname "Smith"

