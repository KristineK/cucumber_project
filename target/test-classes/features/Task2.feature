Feature: People

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


    Scenario: Edit Person
      When I press Edit button
      Then I will be redirected to person's page
      And I enter name: "Antonio"
      And I click edit
      And see the changes in People list


  Scenario: Delete Person
    Given I reset People list
     When I press Delete button
     Then I can see that People list contains 2 items


    Scenario: Clear
      When I click Add Person
      And I enter name: "Emily"
      And I press 'Clear all' button
     Then I can see that name field is empty

  Scenario: Reset List
    Given I press Delete button
    And I can see that list of people became shorter
    When I reset People list
    Then I can see that People list contains 3 items




