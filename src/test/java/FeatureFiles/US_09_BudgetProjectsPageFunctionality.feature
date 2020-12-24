Feature: User should be able to use Budget Projects Page functionality.(Budget-Setup)

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: US_09 TC_01 User should be able to view Position Budget Projects page

    When User click on the element
      | budget         |
      | setupBudget    |
      | budgetProjects |
    Then User should see Budget Projects page correctly

  Scenario: US_09 TC_02 User should be able to add Budget Project and view  successfully validating the message

    When User click on the element
      | budget         |
      | setupBudget    |
      | budgetProjects |
      | addButton |
    Then Send value to element's inputbox
      | name        | team1111 |
      | accountCode | 3.3    |
    When User click on the element
      | saveButton         |
    Then User should see "successfully" message

    @SmokeTest
  Scenario: US_09 TC_03 User should not be able to add without Code

    When User click on the element
      | budget         |
      | setupBudget    |
      | budgetProjects |
      | addButton |
    Then Send value to element's inputbox
      | name        | team1999 |
      | accountCode |  |
    Then check the button as name of "saveButton", should be inactive

  Scenario: US_05 TC_04 delete element
    When User click on the element
      | budget         |
      | setupBudget    |
      | budgetProjects |

    And User delete the "team1111"

    And User click on the element
      | yesButton |

    Then User should see "successfully" message