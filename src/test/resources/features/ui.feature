Feature: User Authentication

  Background:
    Given the user is on the homepage

  Scenario: TC_AUTH_02 - Login with valid credentials
    When the user navigates to the Signup/Login page
    And enters email 's@email.com' and password '123'
    And clicks the Login button
    Then the navbar should show 'Logged in as s'




