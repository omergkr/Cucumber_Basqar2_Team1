Feature:  Item Categories Page functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then Go to the Item_Categories page
      | Inventory       |
      | Inventory_Setup |
      | Item_Categories |


  Scenario: US_08 TC_01 Item Categories
    When page validation Item_Categories


  Scenario: US_08 TC_02 Create new Item Categorie
    When page validation Item_Categories
    Then Add New
    And Check mesaj

  Scenario: US_08 TC_04 edit Item Categorie
    When Go to edit method "Kitap" to "Silgi"
    And Check mesaj


  Scenario: US_08 TC_03 delete Item Categorie
    Then Searching by Item_Categories name as "Silgi"
    When Go to delete method "Silgi"
    And Check mesaj


  Scenario: US_08 TC_05 checking the result list of the searched element
  When Searching by Item_Categories name as "as"
  Then Check name from list
    | namelists | as |







