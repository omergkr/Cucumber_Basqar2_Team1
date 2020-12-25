Feature: Position Categories Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: US_13 TC_01 view Position Categories page
    When Click on the element in the position categories content class
      | humanResources     |
      | setup3             |
      | positionCategories |

    Then User should Position Categories successfully


  Scenario: US_13 TC_02 Create new Position Categories
    When Click on the element in the position categories content class
      | humanResources     |
      | setup3             |
      | positionCategories |
      | addButton          |

    Then User sending the keys in the position categories content class
      | name | Tester |

    And Click on the element in the position categories content class
      | saveButton |

    Then Success Message should be displayed



  Scenario: US_13 TC_03 Edit new Position Categories
    When Click on the element in the position categories content class
      | humanResources     |
      | setup3             |
      | positionCategories |

    Then User sending the keys in the position categories content class
      | nameSearch | Tester |

    And Click on the element in the position categories content class
      | searchButton |

    When User edit the position categories "Tester" to "Development"

    Then Success Message should be displayed



  Scenario: US_13 TC_04 Delete Position Categories
    When Click on the element in the position categories content class
      | humanResources     |
      | setup3             |
      | positionCategories |

    Then User sending the keys in the position categories content class
      | nameSearch | Development |

    And Click on the element in the position categories content class
      | searchButton |

    And User delete the position categories "Development"

    Then Success Message should be displayed



  Scenario: US_13 TC_05 User can find the name with search button
    When Click on the element in the position categories content class
      | humanResources     |
      | setup3             |
      | positionCategories |

    Then User sending the keys in the position categories content class
      | nameSearch | Development |

    And Click on the element in the position categories content class
      | searchButton |

    Then check to list with name position categories
      | namelist | Development |