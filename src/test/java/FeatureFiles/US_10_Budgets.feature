Feature: Budgets Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then User should login successfully


  Scenario: US_10 TC_01 View Budgets Page
    When Click on the element in the Budgets content class
      | budget  |
      | budgets |



  Scenario: US_10 TC_02 Create new Budgets
    When Click on the element in the Budgets content class
      | budget    |
      | budgets   |
      | addButton |

    Then User sending the keys in the Budgets content class
      | descriptionBox | Budget for Group 1 |
      | year           | 2021               |

    And Click on the element in the Budgets content class
      | budgetGroup |
      | description |
      | school      |
      | highSchool  |
      | budgetType  |
      | revision    |

    And Click on the element in the Budgets content class
      | saveButton |

    Then Success Message should be Displayed

    And Click on the element in the Budgets content class
      | closeButton |


  @SmokeTest
  Scenario: US_10 TC_03 Should not Create new Budgets
    When Click on the element in the Budgets content class
      | budget    |
      | budgets   |
      | addButton |

    Then User sending the keys in the Budgets content class
      | descriptionBox | Budget for Group 1 |



    Then Error Message should be Displayed



  Scenario: US_10 TC_04 Delete Budgets
    When Click on the element in the Budgets content class
      | budget  |
      | budgets |

    And Click on the element in the Budgets content class
      | budgetGroupSearch | description |
      | schoolSearch      | highSchool  |

    And Click on the element in the content class
      | searchButton |

    And User delete the Budgets "Budget for Group 1"


    Then Success Message should be Displayed


