Feature: enter a Number
  Background:
    Given I am on 'Enter a Number' Page

  Scenario Outline: Correct
    When I enter "<number>"
    And I click submit
    Then I see a "<result>"
    Examples:
      | number | result |
      |  64    | Square root of 64 is 8.00 |

    Scenario Outline: Big
      When I enter "<number>"
      And  I click submit
      Then I see an error "<message>"
      Examples:
        | number | message |
        |  144   | Number is too big |
        |  4     | Number is too small |
        |  terg  | Please enter a number |

  Scenario Outline: Small
    When I enter "<number>"
    And  I click submit
    Then I see an error "<message>"
    Examples:
      | number | message |
      |  4     | Number is too small |

