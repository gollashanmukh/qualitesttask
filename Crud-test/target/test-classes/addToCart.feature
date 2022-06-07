Feature: Performing Add to wishlist operations on the application -- tests

  @addtowish
  Scenario Outline: Adding product to the wishlist page


    Given I add four different products to my wishlist
    When  I view my wishlist table
    Then  I find total four selected items in my wishlist
    And   I am able to add the lowest price item to my cart
    Then  I am to verify the item in my cart



    Examples:
    |products     |
    |modern       |


