Feature: test the automatic mower

  Scenario: automatic mowing with a file as input

    Given the following mowers are given as an input with the lawn coordinate (5,5)
      | x | y | orientation | movements  |
      | 1 | 2 | N           | GAGAGAGAA  |
      | 3 | 3 | E           | AADAADADDA |

    When the application is called

    Then the expected positions of the mowers are
      | final position |
      | 1 3 N          |
      | 5 1 E          |