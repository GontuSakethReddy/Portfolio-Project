Feature: Product Page

  Background:
    Given the user is on the homepage
    When the user navigates to products page

  Scenario: TC_PROD_01	View all products page

    Then the product list should displayed
    And the page title should be "ALL PRODUCTS"

  Scenario: TC_PROD_02	Search for a product

    And search for "Top" is search box
#    Then the page title should be "SEARCHED PRODUCTS "
    And Only matching "Top" products are visible

  Scenario: TC_PROD_03 View product detail page

    And search for "Top" is search box
    And click "View Product" on any product
    Then product details are visible.