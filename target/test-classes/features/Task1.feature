@regression
Feature: Testing error cases and correct number case

  @debugs
  Scenario Outline: Testing error cases
    Given I am on number page
    When I enter number: "<number>"
    And I click submit number
    Then I see a message: "<errorMessage>"
    Examples:
      | number | errorMessage                   |
      | dad    | Please enter a number          |
      | 101    | Number is too big              |
      | 45     | Number is too small            |

  @debugs
  Scenario: Testing correct numbers
    Given I am on number page
    When I enter number: "64"
    And I click submit number
    Then I see a new message: "Square root of 64 is 8.00"