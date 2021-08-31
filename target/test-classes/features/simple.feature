Feature: Rest API tests
  @api
  Scenario: Expose the CRUD operations for Rest APIs
    Given the rest api for post is ready
    When I post the record with some details
    Then validate the success status OK
    And the rest api for get is ready
    And I get the record with some details
    Then validate the address 45 Tweedy Road from get response
    And the rest api for put is ready
    And I update the record with some details
    Then validate the message Address successfully updated
    And the rest api for get is ready
    And I get the record with some details
    Then validate the address 76 college road from get response
    And the rest api for delete is ready
    And I delete the record with some details
    Then validate the delete success status OK

  @MyTest
  Scenario: test the site
    Given user clicks create account
    And user filling the personal information
    Then validate the text as Your personal information
#    When user back to home page
#    And add the items into the cart
#    Then verify the item counts in the cart
  @soap
  Scenario: test the soap
    Given perform the addition and subtraction operation
