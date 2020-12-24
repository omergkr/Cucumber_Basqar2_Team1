Feature:  Attestation  functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then click on button with button name Attestation
      | humanBtn       |
      | SetupBtn       |
      | attestationBtn |

  @SmokeTest
  Scenario: US_12 TC_01 login
    When page validation Attestations


  Scenario: US_12 TC_02 create

    When  Create a new Attestations name as "Bescheinigung"
    Then Success message should be displayed attestation


  Scenario: US_12 TC_03 edit

    When  User Edit Attestation the "Bescheinigung" to "Neue Bescheinigung"
    Then Success message should be displayed attestation


  Scenario: US_12 TC_04 search
    When   searching by Attestation name as "Neue Bescheinigung"


  Scenario: US_12 TC_05 delete
    When  The user should delete the Attestation in the name "Neue Bescheinigung"

