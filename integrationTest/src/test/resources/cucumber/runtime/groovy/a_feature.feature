Feature: Pebbles are so much fun
  Scenario: I pick up lots of pebbles
    Given I have 12 pebbles in my hand
    And I pick up 100 more pebbles
    Then I have 112 pebbles in my hand
    
  Scenario: I pick up some pebbles
    Given I have 3 pebbles in my hand
    And I pick up 5 more pebbles
    Then there are 0 pebbles in my hand
