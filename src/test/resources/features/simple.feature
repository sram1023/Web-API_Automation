
Feature: Rest API tests
  @2222
  Scenario: Expose the CRUD operations for Rest APIs
    Given the rest api for post is ready
    When I post the record with some details
    Then validate the success status OK
    And the rest api for get is ready
    And I get the record with some details
    Then validate the address 45 tweedy road from get response
    And the rest api for put is ready
    And I update the record with some details
    Then validate the message Address successfully updated
    And the rest api for get is ready
    And I get the record with some details
    Then validate the address 99 tweedy road from get response
    And the rest api for delete is ready
    And I delete the record with some details
    Then validate the success status OK
#    And test the properties
