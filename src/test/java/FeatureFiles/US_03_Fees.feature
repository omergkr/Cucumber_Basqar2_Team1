Feature: Fees functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then Navigate to Fee page



  Scenario: US_3 TC_01
    When  Create a new Fees

  Scenario: US_3 TC_02
    When  User Edit Fees the "talha" to "safiye"

  Scenario: US_3 TC_03
    When   searching by Fees name as "safiye"

  Scenario: US_3 TC_04
    When  The user should delete the fees in the name "safiye"

