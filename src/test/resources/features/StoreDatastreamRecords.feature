Feature: Upload Data Stream
  In order to contribute data to a datastream dataset
  As a data owner
  I want to upload the data contained in a local file,
  organised as lines and using a specified string or character as field separator

  Scenario: Create a dataset by uploading stream
    Given I login as "owner" with password "password"
    When I upload a stream with name "test.csv" and owner "owner" and title "my dataset" and separator ","
    Then The dataset contains a stream with name "test.csv"
    And The datastream content contains "test.csv" content
    And The datastream separator is ","
    And The datastream contains 4 records
    And The line 3 contains "4,Sergi,800"