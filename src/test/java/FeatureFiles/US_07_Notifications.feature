
Feature: Notifications Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button

  @RegressionTest
  Scenario: US_07 TC_01 View Notifications Page
    When click on button with button name
      | messaging     |
      | notifications |
    Then page validation
      | notificationsPageTitle | Notifications |

  Scenario: US_07 TC_02 create
    When click on button with button name
      | messaging     |
      | notifications |
      | addbutton     |
    Then Send text with inputbox name
      | inputNatificationName | orhangoker |
    And click on button with button name
      | type           |
      | studentPayment |
    Then Send text with inputbox name
      | description | natification |
    And click on button with button name
      | saveButton |
    Then Control to verification message
      | containsmesaj | successfully |


  Scenario: US_07 TC_03 edit
    When click on button with button name
      | messaging     |
      | notifications |
      | addbutton     |
    Then Send text with inputbox name
      | inputNatificationName | omergoker18 |
    And click on button with button name
      | type           |
      | studentPayment |
    Then Send text with inputbox name
      | description | natification1 |
    And click on button with button name
      | saveButton |
      | backbutton |
    Then Send text with inputbox name
      | nameSearch | omergoker18 |
    And click on button with button name
      | searchButton |
      | editButton   |
    Then Send text with inputbox name
      | inputNatificationName | omergoker1806 |
    And click on button with button name
      | saveButton |
    Then Control to verification message
      | containsmesaj | successfully |


  Scenario: US_07 TC_04 delete
    When click on button with button name
      | messaging     |
      | notifications |
      | addbutton     |
    Then Send text with inputbox name
      | inputNatificationName | omergoker37 |
    And click on button with button name
      | type           |
      | studentPayment |
    Then Send text with inputbox name
      | description | natification1 |
    And click on button with button name
      | saveButton |
      | backbutton |
    Then Send text with inputbox name
      | nameSearch | omergoker37 |
    And click on button with button name
      | searchButton |
      | deletButton  |
      | yesButton    |
    Then Control to verification message
      | containsmesaj | successfully |

  @SmokeTest
  Scenario: US_07 TC_05 search
    When click on button with button name
      | messaging     |
      | notifications |
    Then Send text with inputbox name
      | nameSearch | omer |
    And click on button with button name
      | searchButton |
    Then check to list with input text
      | namelist | omer |