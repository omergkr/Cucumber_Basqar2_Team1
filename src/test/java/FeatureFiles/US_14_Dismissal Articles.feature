Feature: Dismissal Articles  Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: US_14 TC_01  Dismissal Articlespage
    When Click on the element in the Dismissal Articles page content class
      | humanResourcess     |
      | setup               |
      | dismissalArticles |

    Then User should Dismissal Articles successfully


  Scenario: US_14 TC_02 Create new Dismissal Articles
    When Click on the element in the Dismissal Articles page content class
      | humanResourcess    |
      | setup             |
      | dismissalArticles |
      | addButtonArticles |

    Then User sending the keys in the Dismissal Articles content class
      | nameArticle | leben|
      | description | hayat |

    And Click on the element in the Dismissal Articles page content class
      | saveButtonArticle|

    Then Dismissal Articles Success Message should be displayed


  Scenario: US_14 TC_03 Edit newDismissal Articles
    When Click on the element in the Dismissal Articles page content class
      | humanResourcess     |
      | setup               |
      | dismissalArticles |

    Then User sending the keys in the Dismissal Articles content class
      | dismissalnameSearch| leben |

    And Click on the element in the Dismissal Articles page content class
      | searchButton |

    When User edit the Dismissal Articles "leben" to "mylive"
    Then Dismissal Articles Success Message should be displayed

  Scenario: US_14 TC_04 Delete Dismissal Articles
    When Click on the element in the Dismissal Articles page content class
      | humanResourcess     |
      | setup               |
      | dismissalArticles |

    Then User sending the keys in the Dismissal Articles content class
      |dismissalnameSearch| mylive |

    And Click on the element in the Dismissal Articles page content class
      | searchButton |

    And User delete the Dismissal Articles "mylive"

    Then Dismissal Articles Success Message should be displayed




  Scenario: US_14 TC_05 Dismissal Articles User can find the name with search button
    When Click on the element in the Dismissal Articles page content class
      | humanResourcess     |
      | setup               |
      | dismissalArticles |

    Then User sending the keys in the Dismissal Articles content class
      | dismissalnameSearch |mylive |

    And Click on the element in the Dismissal Articles page content class
      | searchButton |

    Then check to list with name Dismissal Articles
      | dismissalnamelist | mylive  |
