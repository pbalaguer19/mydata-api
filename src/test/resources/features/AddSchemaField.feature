Feature: Add Schema Field
  In order to define the structure of a schema
  As a data owner
  I want to add a new field to a schema.

  Scenario: Add a first field to a schema
    Given I login as "owner" with password "password"
    And There is a schema with title "my own schema" and owner "owner"
    And There are 0 fields added
    When I add a field with title "my own field" and description "my own field description" to schema "my own schema"
    Then There is 1 field added
    And The schema with title "my own schema" has 1 field
    And The schema with title "my own schema" has a field with title "my own field"

  Scenario: Add another field to a schema
    Given I login as "owner" with password "password"
    And There is a schema with title "my own schema" and owner "owner"
    And There is a field with title "my own field" in schema "my own schema"
    And There are 1 field added
    When I add a field with title "my own field 2" and description "my own field description 2" to schema "my own schema"
    Then There is 2 field added
    And The schema with title "my own schema" has 2 field
    And The schema with title "my own schema" has a field with title "my own field"
    And The schema with title "my own schema" has a field with title "my own field 2"

  Scenario: Add an existing field to a schema
    Given I login as "owner" with password "password"
    And There is a schema with title "my own schema" and owner "owner"
    And There is a field with title "my own field" in schema "my own schema"
    And There are 1 field added
    When I add a field with title "my own field" and description "my own field copy" to schema "my own schema"
    Then The response code is 409
    And The error message is "FIELD_TITLE_UNIQUE_PER_SCHEMA"
    And There are 1 fields added
    And The schema with title "my own schema" has 1 fields
    And The schema with title "my own schema" has a field with title "my own field"

  Scenario: Add two fields with same title to different schemas
    Given I login as "owner" with password "password"
    And There is a schema with title "my own schema" and owner "owner"
    And There is a schema with title "my own schema 2" and owner "owner"
    When I add a field with title "my own field" and description "my own field description" to schema "my own schema"
    And I add a field with title "my own field" and description "my own field description" to schema "my own schema 2"
    Then The schema with title "my own schema" has 1 field
    Then The schema with title "my own schema 2" has 1 field
    And The schema with title "my own schema" has a field with title "my own field"
    And The schema with title "my own schema 2" has a field with title "my own field"

  Scenario: Add a field to the schema but wrong password
    Given I login as "owner" with password "wrongpassword"
    And There is a schema with title "my own schema" and owner "owner"
    When I add a field with title "my own field" and description "my own field description" to schema "my own schema"
    Then The response code is 401
    And The error message is "Bad credentials"
    And There are 0 fields added

  Scenario: Add a field to an unowned schema
    Given I login as "owner" with password "password"
    And There is a schema with title "someone else schema" and owner "owner2"
    When I add a field with title "my own field" and description "my own field description" to schema "someone else schema"
    Then The response code is 403
    And The error message is "Access is denied"
    And There are 0 fields added

  Scenario: Move existing field to an unowned schema
    Given I login as "owner" with password "password"
    And There is a schema with title "my own schema" and owner "owner"
    And There is a field with title "my own field" in schema "my own schema"
    And There is a schema with title "someone else schema" and owner "owner2"
    When I move the field with title "my own field" to schema "someone else schema"
    Then The response code is 403
    And The error message is "Access is denied"
    And The schema with title "my own schema" has 1 field
    And The schema with title "someone else schema" has 0 fields
