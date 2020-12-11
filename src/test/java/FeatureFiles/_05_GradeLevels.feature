Feature: GradeLevels Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click Login button

  Scenario: US_05 TC_01 create
    When click on button with button at Grade Level
      | setup       |
      | parameters  |
      | gradeLevels |
      | addButton   |

    Then Send text with inputbox at Grade Level
      | nameBox      | BasqarTeam |
      | shortNameBox | team1      |
      | order        | 1          |

    And click on button with button at Grade Level
      | saveButton |
#      | nextGrade  | 1          |
#    Then Send text with inputbox name
#      | nextGrade  | 1          |

    Then User should see "successfully" at Grade Level


  Scenario: US_05 TC_02 edit
    When click on button with button at Grade Level
      | setup       |
      | parameters  |
      | gradeLevels |

    And User edit the "BasqarTeam" to "Basqarteam1" at GradeLevelName

    Then Send text with inputbox at Grade Level
      | nameBox | BasqarTeam1 |

    And click on button with button at Grade Level
      | saveButton |

    Then User should see "successfully" at Grade Level

  Scenario: US_05 TC_03 delete
    When click on button with button at Grade Level
      | setup       |
      | parameters  |
      | gradeLevels |

    And User delete the "Basqarteam1" at Grade Level

    And click on button with button at Grade Level
      | yesButton |
    Then User should see "successfully" at Grade Level


