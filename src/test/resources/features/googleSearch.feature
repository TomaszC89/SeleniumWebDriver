Feature: Google search feature
  As an user I want to search something in Google to have search results

  Background:
    Given Google page is opened
    When I click Accept All button

  Scenario Outline: Search in Google
    And I search for <searchPhrase> in search bar
    Then I see search results
    Examples:
      | searchPhrase |
      | "Cucumber"   |
      | "Selenium"   |
      | "SDA"        |

  Scenario: Search in Google - empty search phrase
    And I click Enter in search bar
    Then I don't see search results