Feature: Citizenships Functionality


  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button



  Scenario: US_01 TC_01 create
    When click on button with button name
      | setup       |
      | parameters  |
      | citizenship |
      | addbutton     |
    Then Send text with inputbox name
      | inputCitizenshipName | orhangoker |
      | citizenshipShortName | ogkr |
    And click on button with button name
      | saveButton |
    Then Control to verification message
      | containsmesaj | successfully |


  Scenario: US_01 TC_02 edit
    When click on button with button name
      | setup       |
      | parameters  |
      | citizenship |
      | addbutton     |
    Then Send text with inputbox name
      | inputCitizenshipName | orhangoker3 |
      | citizenshipShortName | ogkr3 |
    And click on button with button name
      | saveButton |
    Then Send text with inputbox name
      | citizenshipNameSearch | orhangoker3 |
    And click on button with button name
      | searchButton |
      | editButton   |
    Then Send text with inputbox name
      | inputCitizenshipName | orhangoker33 |
      | citizenshipShortName | ogkr33 |
    And click on button with button name
      | saveButton |
    Then Control to verification message
      | containsmesaj | successfully |


  Scenario: US_01 TC_03 delete
    When click on button with button name
      | setup       |
      | parameters  |
      | citizenship |
      | addbutton     |
    Then Send text with inputbox name
      | inputCitizenshipName | orhangoker6 |
      | citizenshipShortName | ogkr6 |
    And click on button with button name
      | saveButton |
    Then Send text with inputbox name
      | citizenshipNameSearch | orhangoker6 |
    And click on button with button name
      | searchButton |
      | deletButton  |
      | yesButton    |
    Then Control to verification message
      | containsmesaj | successfully |