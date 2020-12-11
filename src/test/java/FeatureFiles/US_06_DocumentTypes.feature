Feature: Login Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button


  Scenario: US_06 TC_01 (Go to Document Types page)
    Given Navigate to Document Types page
    Then Document Types title control

  Scenario: US_06 TC_02 (Creat a Document Types)
    Given Navigate to Document Types page

    When New Document Creat as Name "Fatih" as Description"AKAR"

    Then Success message should be displayed for New Document

  Scenario: US_16 TC_03 (Name of Document Types edit)
    Given Navigate to Document Types page
    When User can Document Types edit the name  "Fatih" to "akar"
    Then Success Edit message should be displayed for Document Types

  Scenario: US_06 TC_04 (Document Types  Delete)
    Given Navigate to Document Types page
    When   User can Document Types delete the "akar"
    Then Success delete message should be displayed for Document Types

  Scenario: US_06 TC_05 user can find the name with search button
    Given Navigate to Document Types page
    Then Send text in  namebox and search Document Type
      | nameSearch | SELIM |
    And click on Search Button of Document Type
      | searchButton |
    Then check to list with name Document Type
      | namelist | SELIM |



