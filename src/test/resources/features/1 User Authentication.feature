Feature: User Authentication

  Background:
    Given the user is on the homepage
    When the user navigates to the Signup/Login page

  Scenario: TC_AUTH_02 Login with valid credentials

    And enters email "s@email.com" and password "123"
    And clicks the Login button
    Then the navbar should show "Logged in as s"

  Scenario: TC_AUTH_03 Login with invalid credentials

    And enters invalid email "wrong@email.com" and invalid password "wrongpass"
    And clicks the Login button
    Then an error "Your email or password is incorrect!" should appear

  Scenario: TC_AUTH_04 Logout from account

    And enters email "s@email.com" and password "123"
    And clicks the Login button
    And the navbar should show "Logged in as s"
    And clicks Logout button
    Then user is navigated to login page











