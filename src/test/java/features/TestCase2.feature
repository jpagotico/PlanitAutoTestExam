Feature: Jupiter Toys Website

  @tc1and2
  Scenario Outline: Verify successful message
    Given I access the Jupiter Toys Contact page
    When I enter "<fnvalue>" in the Forename field
    And I enter "<evalue>" in the Email field
    And I enter "<mvalue>" in the Message field
    And I click submit button
    Then I should see successful message for "<fnvalue>"

    Examples:
    |fnvalue|evalue       |mvalue |
    |John   |test@test.com|testing1|
    |Pao    |test@test.com|testing2|
    |Hannah |test@test.com|testing3|
    |Mike   |test@test.com|testing4|
    |Ruel   |test@test.com|testing5|




