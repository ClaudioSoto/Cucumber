@tag
Feature: Search products

  @search
  Scenario Outline: Search non-existing product in home page
    Given User is on the greencart website landing page
    When User searches for the given product with name <productName>
    Then An error for failed search is displayed
    
    Examples:
    |productName|
    |not an existing product|
    
  @search
  Scenario Outline: Search existing product in home page
    Given User is on the greencart website landing page
    When User searches for the given product with name <productName>
    Then The existing product <productName> is displayed
    
    Examples:
    |productName|
    |Tomato|
    |Potato|
    |Carrot|
