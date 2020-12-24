Feature: Login Functionality

  Scenario: Login with valid username and password

  @Login
    Given Navigate to basqar

    When Enter username and password and click Login button

    Then User should login successfully

