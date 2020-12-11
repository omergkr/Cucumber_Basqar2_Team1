Feature: Nationalities Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: US_02 TC_01 Create new Nationalities
    When Click on the element in the content class
      | setup         |
      | parameters    |
      | nationalities |
      | addButton     |

    Then User sending the keys in the  content class
      | name | Diyari Basqar |

    And Click on the element in the content class
      | saveButton |

    Then Success message should be displayed


  Scenario: US_02 TC_02 Edit new Nationalities
    When Click on the element in the content class
      | setup         |
      | parameters    |
      | nationalities |


    Then User sending the keys in the  content class
      | nameSearch | Diyari Basqar |

    And Click on the element in the content class
      | searchButton |

    When User edit the nationalities "Diyari Basqar" to "Diyari Techno"


    Then Success message should be displayed


  Scenario: US_02 TC_03 Delete Nationalities
    When Click on the element in the content class
      | setup         |
      | parameters    |
      | nationalities |

    Then User sending the keys in the  content class
      | nameSearch | Diyari Techno |

    And Click on the element in the content class
      | searchButton |

    And User delete the nationalities "Diyari Techno"


    Then Success message should be displayed


  Scenario: US_02 TC_04 Create a a Nationality with similar name
    When Click on the element in the content class
      | setup         |
      | parameters    |
      | nationalities |
      | addButton     |

    Then User sending the keys in the  content class
      | name | Diyari Basqar |

    And Click on the element in the content class
      | saveButton |
      | addButton  |

    Then User sending the keys in the  content class
      | name | Diyari Basqar |

    And Click on the element in the content class
      | saveButton |

    Then Success message should be displayed