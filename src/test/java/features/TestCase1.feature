Feature: Jupiter Toys Website

  @tc1and2
  Scenario Outline: Verify with or without error messages
    Given I access the Jupiter Toys Contact page
    When I click submit button
    Then I see error messages
    And I enter "<fnvalue>" in the Forename field
    And I enter "<evalue>" in the Email field
    And I enter "<mvalue>" in the Message field
    Then I should not see error messages

    Examples:
    |fnvalue|evalue       |mvalue |
    |John   |test@test.com|testing|



