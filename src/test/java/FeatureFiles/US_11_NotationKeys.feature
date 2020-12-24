Feature: Login Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button


  Scenario: US_11 TC_01 (Go to Notation Keys page)

    Given Navigate to Notation Keys page

    Then Notation Keys title control

  @SmokeTest
  Scenario: US_11 TC_02 (Creat a Notation Keys )
    Given Navigate to Notation Keys page

    When Click on Buttons  of Notation Page
      | NotationAddButton |
    Then Send text in   Input Boxes of Notation Page
      | NotationInputName       | Fatih19 |
      | NotationInputShortName  | Akar19  |
      | NotationInputMultiplier | 1       |
    And Click on Buttons  of Notation Page
      | NotationApplyButton |
    Then Success message should be displayed for Notation Key


  Scenario: US_11 TC_03 (User can Name of Notation Keys edit)
    Given Navigate to Notation Keys page

    When User can Notation Keys edit the name  "Akar1" to "Fatih"
    Then Success Edit message should be displayed for Notation Keys

  Scenario: US_11 TC_04 (User can Name of Notation Keys delete)
    Given Navigate to Notation Keys page
    When   User can Notation Keys delete the "aaa"
    Then Success delete message should be displayed for Notation Keys

  Scenario:US_11 TC_05 (Search with the Name of Notation Keys )
    Given Navigate to Notation Keys page

    When Send text in   Input Boxes of Notation Page
      | NotationKeyNameSearchBox | Fatih1 |

    And Click on Buttons  of Notation Page
      | NotationKeyNameSearchButton |
    Then Check to List of Notation Keys with  Name or Shortname
      | NotationKeyNameList | Fatih11 |

    And Send text in   Input Boxes of Notation Page
      | NotationKeyShortNameSearchBox | Akar1 |
    Then Check to List of Notation Keys with  Name or Shortname
      | NotationKeyNameList | Akar1 |



