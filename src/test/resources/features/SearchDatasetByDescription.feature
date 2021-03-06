Feature: SearchDatasetByDescription
  In order to list all datasets that match with a given description words
  As a data user
  I want to show the datasets that match with a description

  Scenario: Show a dataset given a description
    Given There is a dataset with description "dataset description one" and owner "owner"
    And There is 1 datasets registered
    When I search with "one"
    Then Show 1 datasets

  Scenario: Show a dataset given a erroneous description
    Given There is a dataset with description "dataset description 2" and owner "owner"
    And There is 1 datasets registered
    When I search with "notmatch"
    Then Show 0 datasets

Scenario: Show a dataset given a blank description
    Given There is a dataset with description "dataset description 3" and owner "owner"
    And There is 1 datasets registered
    When I search with a blank description
    Then Show 0 datasets