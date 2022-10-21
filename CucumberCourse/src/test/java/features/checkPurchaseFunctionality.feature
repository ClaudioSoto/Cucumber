
@tag
Feature: Place order for products

  @order
  Scenario Outline: Place order valid data
    Given User is on the greencart website landing page
    When User searches for the given product with name <productName>
    And Add "3" products to the cart
    And User add that product to the cart
    And Proceed with the checkout of that product
    And Validates that product in the checkout is <productName>
    And Place the order in the system
    And Select country "Mexico" and agre with terms
    Then The landing page is displayed
    
    Examples:
    |productName|
    |Tomato|
