Feature: Verifying the Search

  Scenario: Homepage verification
    Given User is on homepage
    Then Verify that "Browse By Make" is present
    Then Verify that "Browse By Style" is present
    Then Verify that "Advanced Search" is present
    And Verify that Search button is present
    Then Verify that "Any Make" and "Any Model" is present


  Scenario Outline: User checks the Advance search Link
    Given User is on Advance Search page
    Then User enter <arg0> in the zip code text box
    Then User select <arg01> check box under <arg1>
    Then User select <arg02> check box under <arg11>
    Then user update Year <arg03> to <arg12>
    Then user select <arg04> car from Make,Model and Trim section
    Then User clicks Search button
    Then User verifies that he is in result page
    Then User verifies that he sees only <arg04> cars in listing
    Then Display in console, the number of cars listed in result page
    Examples:
      | arg0    | arg01       | arg1        | arg02         | arg11   | arg03  | arg12  | arg04 |
      | "30004" | "Certified" | "Condition" | "Convertible" | "Style" | "2017" | "2020" | "BMW" |
