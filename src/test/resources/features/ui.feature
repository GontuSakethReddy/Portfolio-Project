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

  Scenario: TC_PROD_01	View all products page

    And the user navigates to products page
    Then the product list should displayed
    And the page title should be "ALL PRODUCTS"

  Scenario: TC_PROD_02	Search for a product

    And the user navigates to products page
    And search for "Top" is search box
#    Then the page title should be "SEARCHED PRODUCTS "
    And Only matching "Top" products are visible









