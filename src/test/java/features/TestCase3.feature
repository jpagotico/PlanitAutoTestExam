Feature: Jupiter Toys Website

  @tc3
  Scenario: Verify subtotal, price, total in Cart Page
    Given I access the Jupiter Toys Shop page thru Start Shopping button
    When I click 2 times the buy button of Stuffed Frog
    And I click 5 times the buy button of Fluffy Bunny
    And I click 3 times the buy button of Valentine Bear
    And I go to Cart Page
    Then I verify the subtotal for Stuffed Frog is correct
    And I verify the subtotal for Fluffy Bunny is correct
    And I verify the subtotal for Valentine Bear is correct
    Then I verify the price for Stuffed Frog
    And I verify the price for Fluffy Bunny
    And I verify the price for Valentine Bear
    Then I verify the total





